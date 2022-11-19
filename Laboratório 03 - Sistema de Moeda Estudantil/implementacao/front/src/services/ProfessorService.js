import api from "./api";

export const loginProfessor = async (data) => {
  try{
    const response = await api.post("/login-professor", data);
    return response.data;
  }catch(error){
    return error.data;
  };
};

export const enviarBonificacao = async (data) => {
  try{
    const response = await api.post("/enviar-bonificacao", data);
    return response.data;
  }catch(error){
    return error.data;
  };
};

export const criarProfessor = async (data) => {
  try{
    const response = await api.post("/criar-professor", data);
    return response.data;
  }catch(error){
    return error.data;
  };
};

export const buscarMoedas = async (id) => {
  const url = `/consultar-extrato-professor/${id}`;
  try{
  const response = await api.get(url);
  return response.data;
  }catch(error){
    return error.data;
};
};

export const listarHistorico = async () => {
  try{
  const response = await api.get('/consultar-bonificacoes');
  return response.data;
  }catch(error){
    return error.data;
  };
}
