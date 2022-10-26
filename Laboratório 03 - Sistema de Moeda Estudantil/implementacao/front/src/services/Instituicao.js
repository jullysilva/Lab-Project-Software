import api from "./api";

export const data = {
  nome: "PUCMINAS",
};

export const criarInstituicao = async () => {
  const response = await api.post("/criar-instituicao", data);

  return response.data;
};
