import api from "./api";

export const criarAluno = async (data) => {
  const response = await api.post("/criar-aluno", data);

  return response.data;
};

export const loginAluno = async (data) => {
  const response = await api.post("/login-aluno", data);

  return response.data;
};

export const resgatarVantagem = async (idVantagem, idAluno) => {
  const url = `/resgatar-vantagem/${idVantagem}/${idAluno}`;
  const response = await api.post(url);

  return response.data;
};

export const consultarExtratoAluno = async (idAluno) => {
  const url = `/consultar-extrato-aluno/${idAluno}`;
  const response = await api.get(url);

  return response.data;
};
