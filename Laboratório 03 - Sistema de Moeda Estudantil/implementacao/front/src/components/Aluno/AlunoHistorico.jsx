import { useEffect, useState } from "react";
import { Alert, Container, Table } from "react-bootstrap";
import { buscarResgates } from "../../services/AlunoService";

const AlunoHistorico = () => {
    const [data, setData] = useState();

    useEffect(() => {
        async function carregaRepositorios () {
            let idAluno = localStorage.getItem('codigo-aluno');
            const resposta = await buscarResgates(idAluno);
            setData(resposta);
            return resposta;
        }
        carregaRepositorios();
      }, []);

    return(
        <Container className="mt-4">
            {data ? (<Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Código da vantagem</th>
                        <th>Custo</th>
                        <th>Detalhe</th>
                    </tr>
                </thead>
                <tbody>
                    {data?.map((item, idx) => 
                        <tr key={idx}>
                            <td>{item.id}</td>
                            <td className="danger">{item.custo}</td>
                            <td>{item.descricao}</td>
                        </tr>
                    )}
                </tbody>
            </Table>) : <Alert variant='warning'>Nenhum resgate foi realizada. Troque moedas por vantagens!</Alert>}
        </Container>
    );
}

export default AlunoHistorico;