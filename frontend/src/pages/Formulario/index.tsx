import Formulario from "../../components/Formulario/Formulario";
import { useParams } from "react-router-dom";

function Form() {
  const params = useParams();
  return <Formulario filmeId={`${params.filmeId}`} />;
}

export default Form;
