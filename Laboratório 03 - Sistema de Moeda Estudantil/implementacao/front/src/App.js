import Home from "./components/Home";
import { criarInstituicao } from "./services/InstituicaoService";

function App() {
  const startarData = async () => {
    const data = {
      nome: "PUC",
    };

    await criarInstituicao(data);
  };

  return (
    <div className="container" onLoad={startarData}>
      <Home />
    </div>
  );
}

export default App;
