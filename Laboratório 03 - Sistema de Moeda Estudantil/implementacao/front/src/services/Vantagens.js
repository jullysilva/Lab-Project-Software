import api from "./api";

export const criarVantagem = async (data) => {
  const response = await api.post("/cadastrar-vantagens", data);

  return response.data;
};

export const buscarVantagens = async () => {
  const response = await api.get("/buscar-todas-vantagens");
  return response.data;
};
