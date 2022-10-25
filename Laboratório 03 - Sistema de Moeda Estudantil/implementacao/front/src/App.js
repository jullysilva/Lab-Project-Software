import Home from "./components/Home";
import { criarInstituicao } from "./services/Instituicao";
import { criarProfessor } from "./services/Professor";

function App() {
  const startarData = async () => {
    const data = {
      nome: "PUC",
    };

    const resp = await criarInstituicao(data);
    if (resp !== null) {
      startarProfessor(resp.id);
    }
  };

  const startarProfessor = async (id) => {
    const data = {
      nome: "Professor Cleitin",
      email: "professor@professor.com",
      senha: "1234",
      idInstituicao: id,
      cpf: "85236920147",
      departamento: "ICEI",
      moeda: 1000,
    };
    const resp = await criarProfessor(data);
  };

  return (
    <div className="container" onLoad={startarData}>
      <Home />
    </div>
  );
}

export default App;
