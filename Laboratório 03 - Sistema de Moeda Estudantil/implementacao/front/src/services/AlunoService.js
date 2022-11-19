import api from "./api";

export const criarAluno = async (data) => {
  try{
    const response = await api.post("/criar-aluno", data);
    return response.data;
  }catch(error){
    return error.data;
  };
};

export const loginAluno = async (data) => {
  try{
    const response = await api.post("/login-aluno", data);
    return response.data;
  }catch(error){
    return error.response;
  };
};

export const resgatarVantagem = async (idVantagem, idAluno) => {
  const url = `/resgatar-vantagem/${idVantagem}/${idAluno}`;
  try{
    const response = await api.post(url);
    return response.data;
  }catch(error){
    return error.response;
  };
};

export const buscarResgates = async(idAluno) => {
  const url = `/consultar-minhas-vantagens/${idAluno}`;
  try{
    const response = await api.get(url);
    return response.data; 
  }catch(error){
    return error.response;
  }
}

export const buscarMoedas = async (idAluno) => {
  const url = `/consultar-extrato-aluno/${idAluno}`;
  try{
    const response = await api.get(url);
    return response.data;
  }catch(error){
    return error.response;
  };
};
