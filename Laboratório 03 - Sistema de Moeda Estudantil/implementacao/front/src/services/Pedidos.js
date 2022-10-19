import api from "./api";

const BuscarTodosPedidos = async () => {
  const response = await api
    .get("/consultar-todos-pedidos")
    .then(() => {
      console.log("Deus certo");
    })
    .catch(() => {
      console.log("Deu ruim");
    });
  return response.data;
};

export default BuscarTodosPedidos;
