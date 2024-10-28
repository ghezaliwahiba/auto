import React from "react";
import Collapse from "../Collapse/Collapse";
import "./About.css";

function About() {
  return (
    <div className="App">
      <div className="DivCollapse">
        <Collapse
          className="collapse__about"
          title="Qui sommes-nous"
          description="RK AUTO est une société spécialisée dans la réparation, carrosserie et la vente de véhicules d'occasion, offrant une large gamme de voitures fiables et abordables pour répondre à tous les besoins et budgets. Forts de notre expertise et de notre passion pour l'automobile, nous sélectionnons rigoureusement chaque véhicule afin de garantir la meilleure qualité à nos clients. Chez RK AUTO, nous nous engageons à fournir un service client exceptionnel, avec des conseils personnalisés et un accompagnement tout au long du processus d'achat. Venez découvrir notre inventaire diversifié et trouvez la voiture idéale qui correspond à vos attentes chez RK AUTO."
        />
      </div>
      <div className="DivCollapse">
        <Collapse
          className="collapse__about"
          title="Nos services"
          description={
            <ul>
              <li>
                <strong>
                  Diagnostic de moteurs automobiles - À partir de 29 €
                </strong>
                : Détecte les problèmes de performance.
              </li>
              <li>
                <strong>Freins - À partir de 30 €</strong>: Contrôle et
                réparation des freins pour la sécurité.
              </li>
              <li>
                <strong>Pneus - À partir de 49 €</strong>: Sélection de pneus,
                équilibrage et réparation.
              </li>
              <li>
                <strong>Vidange - À partir de 29 €</strong>: Prolongez la vie de
                votre moteur avec notre service de vidange. Nous remplaçons
                l'huile usée par une huile de haute qualité, tout en vérifiant
                les filtres et les niveaux pour un fonctionnement optimal.
              </li>
              <li>
                <strong>Batterie - À partir de 59 €</strong>: Ne laissez pas une
                batterie déchargée vous bloquer ! Nous proposons des diagnostics
                et des remplacements de batteries pour vous assurer un démarrage
                fiable à chaque fois.
              </li>
              <li>
                <strong>
                  Dépannage et réparation de freins - À partir de 79 €
                </strong>
                En cas de problème avec vos freins, faites appel à nos experts.
                Nous intervenons rapidement pour réparer ou remplacer vos
                systèmes de freinage afin de garantir votre sécurité sur la
                route.
              </li>

              <li>
                <strong>
                  Remplacement de filtres d'air pour habitacle - À partir de 29
                  €
                </strong>
                Respirez un air pur dans votre véhicule avec notre service de
                remplacement des filtres d'air pour habitacle. Un filtre propre
                améliore la qualité de l’air et le confort de vos trajets.
              </li>
              <li>
                <strong>Réparation de carrosseries - À partir de 79 €</strong>
                Redonnez un coup de neuf à votre véhicule grâce à notre service
                de réparation de carrosserie. Nous traitons les bosses, rayures
                et autres dommages pour un aspect impeccable.
              </li>

              <li>
                <strong>Transmissions - À partir de 199 €</strong>
                Confiez-nous la réparation de votre transmission pour une
                performance optimale. Nos techniciens expérimentés s’assurent
                que chaque composant fonctionne parfaitement pour une conduite
                fluide.
              </li>

              <li>
                <strong>Kit distribution - À partir de 149 €</strong>
                Le remplacement du kit de distribution est crucial pour éviter
                des dommages majeurs à votre moteur. Nous proposons un service
                complet pour garantir un fonctionnement fiable et sécurisé de
                votre véhicule.
              </li>
            </ul>
          }
        />
      </div>
      <div className="DivCollapse">
        <Collapse
          className="collapse__about"
          title="Nous contacter"
          description="Nos équipes se tiennent à votre disposition pour vous fournir une expérience parfaite. N'hésitez pas à nous contacter si vous avez la moindre question.
        Par téléphone : 06 75 28 07 15, 
Par Mail: rkautomobile86@gmail.com, 
ou dans notre garage à l'adresse: 5 Av. des Temps Modernes."
        />
      </div>
    </div>
  );
}

export default About;
