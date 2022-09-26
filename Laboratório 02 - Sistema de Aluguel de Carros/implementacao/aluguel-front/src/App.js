import { Grid } from "@mui/material";
import { useEffect } from "react";
import criarCarros from "./services/Carros";

function App() {
  useEffect(async () => {
    const response = criarCarros();
    console.log(response);
  }, []);

  return (
    <Grid container spacing={2}>
      {" "}
      <form id="create">
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="25836914710" />
        <label for="rg">RG:</label>
        <input type="text" id="rg" name="rg" value="58213951" />
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="Doe" />
        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" value="Rua zero" />
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="teste@gmail.com" />
        <label for="senha">Senha:</label>
        <input type="text" id="senha" name="senha" value="teste123" />
        <button type="submit">Criar cliente</button>
      </form>
    </Grid>
  );
}

export default App;
