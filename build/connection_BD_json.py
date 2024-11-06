import json
import psycopg2

def load_json_data(file_path):
    """Charger les données du fichier JSON"""
    with open(file_path, 'r', encoding='utf-8') as f:
        return json.load(f)

def update_vehicle_data(conn, cur, vehicle):
    """Mettre à jour un véhicule s'il existe, sinon l'insérer"""
    # Vérifier si le véhicule existe déjà (par exemple, via le titre ou un autre champ unique)
    cur.execute("SELECT id FROM vehicules WHERE title = %s", (vehicle['title'],))
    result = cur.fetchone()

    if result:
        # Le véhicule existe déjà, mettre à jour les champs (prix, cover, etc.)
        vehicle_id = result[0]
        cur.execute("""
            UPDATE vehicules SET prix = %s, cover = %s WHERE id = %s
        """, (vehicle['prix'], vehicle['cover'], vehicle_id))
        
        # Supprimer les anciennes images, descriptions et options associées
        cur.execute("DELETE FROM images WHERE vehicle_id = %s", (vehicle_id,))
        cur.execute("DELETE FROM descriptions WHERE vehicle_id = %s", (vehicle_id,))
        cur.execute("DELETE FROM options WHERE vehicle_id = %s", (vehicle_id,))
    else:
        # Le véhicule n'existe pas encore, l'insérer
        cur.execute("""
            INSERT INTO vehicules (title, prix, cover)
            VALUES (%s, %s, %s) RETURNING id;
        """, (vehicle['title'], vehicle['prix'], vehicle['cover']))
        vehicle_id = cur.fetchone()[0]

    # Insérer les nouvelles images, descriptions et options
    for image in vehicle['pictures']:
        cur.execute("""
            INSERT INTO images (vehicle_id, image_url)
            VALUES (%s, %s);
        """, (vehicle_id, image))

    for desc in vehicle['description']:
        cur.execute("""
            INSERT INTO descriptions (vehicle_id, description)
            VALUES (%s, %s);
        """, (vehicle_id, desc))

    current_category = None
    for option in vehicle['options']:
        if ':' in option:
            current_category, option_value = option.split(':')
            cur.execute("""
                INSERT INTO options (vehicle_id, category, option)
                VALUES (%s, %s, %s);
            """, (vehicle_id, current_category.strip(), option_value.strip()))

def delete_vehicles_not_in_json(conn, cur, json_titles):
    """Supprimer les véhicules qui ne sont plus dans le fichier JSON"""
    cur.execute("SELECT title FROM vehicules")
    db_titles = [row[0] for row in cur.fetchall()]

    # Trouver les titres qui sont dans la base mais plus dans le JSON
    to_delete = set(db_titles) - set(json_titles)
    
    for title in to_delete:
        # Supprimer les véhicules et toutes leurs données associées
        cur.execute("DELETE FROM vehicules WHERE title = %s RETURNING id", (title,))
        vehicle_id = cur.fetchone()[0]
        cur.execute("DELETE FROM images WHERE vehicle_id = %s", (vehicle_id,))
        cur.execute("DELETE FROM descriptions WHERE vehicle_id = %s", (vehicle_id,))
        cur.execute("DELETE FROM options WHERE vehicle_id = %s", (vehicle_id,))

def synchronize_database_with_json(json_file, db_config):
    """Synchroniser les données JSON avec la base de données"""
    try:
        # Charger les données JSON
        data = load_json_data(json_file)
        
        # Connexion à la base de données PostgreSQL
        conn = psycopg2.connect(**db_config)
        cur = conn.cursor()

        # Boucle à travers chaque véhicule dans le fichier JSON
        for vehicle in data:
            update_vehicle_data(conn, cur, vehicle)

        # Supprimer les véhicules qui ne sont plus dans le fichier JSON
        json_titles = [vehicle['title'] for vehicle in data]
        delete_vehicles_not_in_json(conn, cur, json_titles)

        # Commit les changements
        conn.commit()
        print("Base de données synchronisée avec succès.")

    except (Exception, psycopg2.DatabaseError) as error:
        print(f"Erreur : {error}")
        if conn:
            conn.rollback()
    finally:
        # Fermer la connexion proprement
        if cur:
            cur.close()
        if conn:
            conn.close()

if __name__ == "__main__":
    # Configuration de la base de données
    db_config = {
        'dbname': "vehicules_db",
        'user': "postgres",
        'password': "G-papa30",
        'host': "localhost",
        'port': "5432"
    }

    # Fichier JSON contenant les données
    json_file = 'data.json'

    # Synchroniser la base de données avec le fichier JSON
    synchronize_database_with_json(json_file, db_config)

    # Connexion à la base de données PostgreSQL
conn = psycopg2.connect(
    dbname="vehicules_db",
    user="postgres",
    password="G-papa30",
    host="localhost",
    port="5432"
)

cur = conn.cursor()

# Exécuter une requête pour voir tous les véhicules
cur.execute("SELECT * FROM vehicules;")
vehicles = cur.fetchall()

# Afficher les résultats
for vehicle in vehicles:
    print(vehicle)

# Fermer la connexion proprement
cur.close()
conn.close()
