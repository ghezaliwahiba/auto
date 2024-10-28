import React from "react";
import bannerpeuget from "../../Images/bannerpeuget.png";
import "./Banner.css";
function Banner() {
  return (
    <div className="banner">
      <img className="banner_img" src={bannerpeuget} alt="Bannière Accueil" />
      <div className="banner_text">
        <p className="banner_text_p1">
          Roulez vers l'avenir avec nos voitures de qualité : 
        </p>
        <p className="banner_text_p2">
          trouvez votre véhicule idéal dès aujourd'hui !{" "}
        </p>
      </div>
    </div>
  );
}

export default Banner;
