import React, { useState } from "react";
import CarousselNext from "../../Images/CarrouselNext.svg";
import CarousselPrevious from "../../Images/CarrousePrevious.svg";
import "./Caroussel.css";

function Carrousel({ slide }) {
  //console.log(slide);

  const [CurentSlide, setIndex] = useState(0);
  console.log(CurentSlide);

  function preventSlide() {
    const newSlide = CurentSlide - 1;
    setIndex(newSlide < 0 ? slide.length - 1 : newSlide);
    console.log(newSlide);
  }

  function nextSlide() {
    const newSlide = CurentSlide + 1;
    setIndex(newSlide === slide.length ? 0 : newSlide); // vérifier si la diapositive actuelle est égale à la valeur maximale de la diapositive (c'est-à-dire qu'elle est à la dernière diapositive), et lorsque cette condition est vraie, réinitialisez la valeur de la diapositive actuelle à 0 — ramenant les diapositives à la première.
    console.log(newSlide);
  }

  return (
    <div className="slide">
      <div className="FicheImages">
        <img
          src={slide[CurentSlide]}
          alt="slide(s) du logement"
          className="slideLogement"
        />
        <img
          className="FlechGauche"
          src={CarousselPrevious}
          alt="bouton slide précédent"
          onClick={preventSlide}
        />
        <img
          className=" FlechDroite"
          src={CarousselNext}
          alt="bouton slide suivant"
          onClick={nextSlide}
        />
      </div>
    </div>
  );
}

export default Carrousel;
