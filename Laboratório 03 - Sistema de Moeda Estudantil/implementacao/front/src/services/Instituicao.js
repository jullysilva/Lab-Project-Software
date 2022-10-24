import api from "./api";

export const criarInstituicao = async (data) => {
  const response = await api.post("/criar-instituicao", data);

  return response.data;
};
