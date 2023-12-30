import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar/Navbar";
import Lista from "./pages/Lista";
import Formulario from "./pages/Formulario";

function App() {
  return (
    <BrowserRouter>
        <Navbar/>
        <Routes>
          <Route path="/" element={<Lista /> } />
          <Route path="/form">
            <Route path=":filmeId" element={<Formulario />}/>
          </Route>
        </Routes>
    </BrowserRouter>
  );
}

export default App;
