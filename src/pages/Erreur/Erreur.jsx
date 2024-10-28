import React from "react";
import { Link } from "react-router-dom";
import "./Erreur.css"
 function Erreur() {
  return (
    <div>
      <div className="Erreur-404">
      <h1>404</h1>
      </div>
      <div className="Erreur-Oops">
      <h1>Oops! La page que vous demandez n'existe pas.</h1>
      </div>
      <nav className="nav-Erreur">
      <div className="nav-links-Erreur">
    <Link  to="/">
        <p>Retourner sur la page d'accueil</p>
      </Link>

      </div>
      </nav>
      </div>
  );
}
export default Erreur;