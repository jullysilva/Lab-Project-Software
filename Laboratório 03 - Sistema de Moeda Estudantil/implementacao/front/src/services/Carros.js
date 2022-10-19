import api from "./api";

const criarCarros = async () => {
  const response = await api
    .get("/salvar-automoveis")
    .then(() => {
      console.log("Deus certo");
    })
    .catch(() => {
      console.log("Deu ruim");
    });
  return response.data;
};

const buscarCarros = async () => {
  const response = await api
    .get("/buscar-todos-automoveis")
    .then(() => {
      console.log("Deus certo");
    })
    .catch(() => {
      console.log("Deu ruim");
    });
  return response.data;
}

export default criarCarros;
