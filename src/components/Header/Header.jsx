import React from "react";
import { NavLink } from "react-router-dom";
import Logo from "../../Images/Logo__RK.jpg";
import "./Header.css";

function Header() {
  return (
    <header>
      <nav className="nav_container">
        <NavLink to="/">
          <img className="home_logo" src={Logo} alt="Logo RK AUTO" />
        </NavLink>
        <div>
          <NavLink className="nav_link" to="/">
            Accueil
          </NavLink>
          <NavLink className="nav_link" to="/Apropos">
            À propos
          </NavLink>
        </div>
      </nav>
    </header>
  );
}

export default Header;
