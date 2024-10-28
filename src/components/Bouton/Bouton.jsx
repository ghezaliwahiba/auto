import React, { useState } from 'react';

import chevron from '../../Images/chevron down.png';
import './Bouton.css'

const Button = () => {
    const [btnActive, setBtnActive] = useState(false);

    function handleClick() { 
        setBtnActive(!btnActive);
    }
    
    return (
        <button className={`${btnActive && "btnActiveclasse"}`} onClick={handleClick} >
            <img src={chevron} alt="bouton déroulant" />
        </button>
    );
};

export default Button;
