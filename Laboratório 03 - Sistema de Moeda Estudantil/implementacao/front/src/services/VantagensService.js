import api from "./api";

export const criarVantagem = async (data) => {
  try{
    const response = await api.post("/cadastrar-vantagens", data);
    return response.data;
  }catch(error){
    return error.data;
  };
};

export const buscarVantagens = async () => {
  try{
  const response = await api.get("/buscar-todas-vantagens");
  return response.data;
}catch(error){
  return error.data;
};
};
