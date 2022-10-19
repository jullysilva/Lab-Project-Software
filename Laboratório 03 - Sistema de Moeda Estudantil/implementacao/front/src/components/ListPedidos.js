import React, { usePromise, useCallback } from "react";
import BuscarTodosPedidos from "../services/Pedidos";

const ListPedido = () => {
  const buscarPedidos = useCallback(async () => {
    return await BuscarTodosPedidos();
  }, []);

  // const data = buscarPedidos();

  // console.log(data);
  const data = [
    {
      id: "1",
      concideracaoAgente: null,
      parecer: null,
      cliente: {
        id: 1,
        cpf: "string",
        rg: "string",
        nome: "string",
        endereco: "string",
        email: "string",
        senha: "string",
      },
      agente: null,
      automovel: {
        matricula: "1111",
        ano: 2000,
        marca: "Honda",
        modelo: "aaa",
        placa: "AAA1111",
      },
      contrato: {
        id: 1,
        valor: null,
        parcela: null,
      },
    },
  ];

  return (
    <>
      <table>
        <tr>
          <th>Cliente</th>
          <th>Agente</th>
          <th>Automovel</th>
          <th>Contrato</th>
          <th>Parecer</th>
          <th id="l">Alteração</th>
        </tr>

        {data.map((index, item, array) => (
          <tr index={index}>
            {console.log(array[item].cliente.nome)}
            <td class="cursor">{array[item].cliente.nome}</td>
            <td>{array[item].agente}</td>
            <td>
              {array[item].automovel.modelo}, {array[item].automovel.marca},{" "}
              {array[item].automovel.placa},{array[item].automovel.ano}
            </td>
            <td>{array[item].parecer}</td>
            <td>{array[item].concideracaoAgente}</td>
            <td>
              <a>
                <button class="btn btn-warning" onclick="alterar({i})">
                  Alterar
                </button>
              </a>{" "}
              |{" "}
              <a>
                <button class="btn btn-danger" onclick="excluir(${i})">
                  Cancelar pedido
                </button>
              </a>{" "}
              |{" "}
              <button
                class="btn btn-info"
                data-toggle="modal"
                data-target="#visualizar"
                onclick="preencheModal(${i})"
              >
                Ver mais
              </button>
            </td>
          </tr>
        ))}
      </table>
    </>
  );
};
export default ListPedido;
