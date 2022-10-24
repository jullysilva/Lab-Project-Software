import api from "./api";

export const loginProfessor = async (data) => {
  const response = await api.post("/login-professor", data);

  return response.data;
};

export const enviarBonificacao = async (data) => {
  const response = await api.post("/enviar-bonificacao", data);
  return response.data;
};

export const criarProfessor = async (data) => {
  const response = await api.post("/criar-professor", data);
  return response.data;
};

export const consultarExtratoProfessor = async (id) => {
  const response = await api.get("/consultar-extrato-professor", id);
  return response.data;
};
