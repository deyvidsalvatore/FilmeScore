import { Link } from "react-router-dom";
import "./formulario.css";

function Formulario() {
  const filme = {
    id: 1,
    imagem:
      "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg",
    titulo: "The Witcher",
    contador: 2,
    score: 4.5,
  };

  return (
    <div className="filme-form-container">
      <img className="filme-card-image" src={filme.imagem} alt={filme.titulo} />
      <div className="card-bottom-container filme-card-bottom-container">
        <h3>{filme.titulo}</h3>
        <form className="filme-form">
          <div className="form-group filme-form-group">
            <label htmlFor="score">Informe sua avaliação</label>
            <select name="score" id="score" className="form-control">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
            </select>
          </div>
          <div className="filme-form-btn-container">
            <div className="filme-form-div-btn">
              <button className="btn btn-primary filme-btn">Salvar</button>
            </div>
            <div className="filme-form-div-btn">
              <Link to="/">
                <button className="btn btn-danger filme-btn mt-10 mb-10">
                  Cancelar
                </button>
              </Link>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Formulario;
