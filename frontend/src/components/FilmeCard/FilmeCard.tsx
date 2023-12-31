import { Link } from "react-router-dom";
import { Filme } from "../../types/Filme";
import FilmeScore from "../FilmeScore/FilmeScore";
import './FilmeCard.css'

type Props = {
    filme: Filme;
}

function FilmeCard({ filme }: Props) {
    return (
        <div>
            <img src={filme.imagem} alt={filme.titulo} className="filme-card-image" />
            <div className="filme-card-bottom-container">
                <h3>{filme.titulo}</h3>
                <FilmeScore contador={filme.contador} score={filme.score} />
                <Link to={`/form/${filme.id}`}>
                    <div className="btn btn-primary filme-btn">Avaliar</div>
                </Link>
            </div>
        </div>
    );

}

export default FilmeCard;