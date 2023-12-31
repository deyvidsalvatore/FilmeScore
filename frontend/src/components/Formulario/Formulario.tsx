import { Link, useNavigate } from "react-router-dom";
import "./Formulario.css";
import { useEffect, useState } from "react";
import { Filme } from "../../types/Filme";
import { BASE_URL } from "../../utils/requests";
import axios, { AxiosRequestConfig } from "axios";
import { validateEmail } from "../../utils/validateEmail";

type Props = {
  filmeId: string;
};

function Formulario({ filmeId }: Props) {

  const navigate = useNavigate();
  const [filme, setFilme] = useState<Filme>();

  useEffect(() => {
    axios.get(`${BASE_URL}/api/v1/filmes/${filmeId}`)
      .then(response => {
        setFilme(response.data);
      })
  }, [filmeId])

      const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const email = (event.target as any).email.value;
        const score = (event.target as any).score.value;
        console.log(email, score);
        if (!validateEmail(email)) {
          return;
        }
        const config: AxiosRequestConfig = {
          baseURL: BASE_URL,
          method: "PUT",
          url: "/api/v1/score",
          data: {
            email: email,
            filmeId: filmeId,
            score: score,
          },
        };
        axios(config).then(() => {
          navigate("/");
        });
      };
    
  return (
    <div className="filme-form-container">
      <img
        className="filme-card-image"
        src={filme?.imagem}
        alt={filme?.titulo}
      />
      <div className="card-bottom-container filme-card-bottom-container">
        <h3>{filme?.titulo}</h3>
        <form className="filme-form" onSubmit={handleSubmit}>
          <div className="form-group filme-form-group">
            <label htmlFor="email">Informe seu email</label>
            <input type="email" className="form-control" id="email" />
          </div>
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
              <button type="submit" className="btn btn-primary filme-btn">Salvar</button>
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
