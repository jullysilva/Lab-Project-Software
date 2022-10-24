import React from "react";
import { criarAluno } from "../services/Aluno";

const Aluno = () => {
  const data = {
    id: 1,
    nome: "teste",
    email: "teste@teste.com",
    senha: "123456",
    cpf: "85274196301",
    rg: "20456789",
    endereco: "Rua zero",
    curso: "Economia",
    moeda: 0,
    idInstituicao: 357852,
    vantagens: [
      {
        id: 756,
        custo: 1,
        descricao: "Compra de material",
      },
    ],
  };

  const onSubmit = async () => {
    const response = await criarAluno(data);
    console.log(response);
  };

  return (
    <div className="card">
      <div className="card_body">
        <h2 className="card_title"></h2>
        <p className="card_description>"></p>
      </div>
      <button className="card_btn" onClick={onSubmit}>
        Editar
      </button>
      <button className="card_btn">excluir</button>
    </div>
  );
};

export default Aluno;
