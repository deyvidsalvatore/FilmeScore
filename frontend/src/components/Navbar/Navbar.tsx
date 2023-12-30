import React from 'react';
import { faFilm } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import './Navbar.css';

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="nav-content">
                    <FontAwesomeIcon icon={faFilm} size="4x" style={{ marginRight: '10px', alignItems: "center", color: 'white' }} />
                    <h1>FilmeScore</h1>
                    <a href="https://github.com/deyvidsalvatore">
                        <div>
                            <img width="50" height="50" src="https://img.icons8.com/ios-filled/50/github.png" alt="github"/>
                            <p>/deyvidsalvatore</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;
