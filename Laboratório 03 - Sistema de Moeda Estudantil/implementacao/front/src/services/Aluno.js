import api from "./api";

export const criarAluno = async (data) => {
  const response = await api.post("/criar-aluno", data);

  return response.data;
};

export const loginAluno = async (data) => {
  const response = await api.post("/login-aluno", data);

  return response.data;
};

export const resgatarVanatagem = async (idVantagem, idAluno) => {
  const response = await api.post("/resgatar-vantagem", idVantagem, idAluno);

  return response.data;
};

export const consultarExtratoAluno = async (id) => {
  const response = await api.get("/consultar-extrato-aluno", id);
  return response.data;
};
