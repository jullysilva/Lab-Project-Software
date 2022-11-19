import { useEffect, useState } from "react";
import { Alert, Container, Table } from "react-bootstrap";
import { listarHistorico } from "../../services/ProfessorService";

const ProfHistorico = () => {
    const [data, setData] = useState();

    useEffect(() => {
        async function carregaRepositorios () {
            let idProfessor = localStorage.getItem("codigo-prof");
            const resposta = await listarHistorico(idProfessor);
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
                        <th>#</th>
                        <th>Código do aluno</th>
                        <th>Valor enviado</th>
                        <th>Mensagem</th>
                    </tr>
                </thead>
                <tbody>
                    {data?.map((item, idx) => 
                        <tr key={idx}>
                            <td>{idx}</td>
                            <td>{item.idAluno}</td>
                            <td>{item.custo}</td>
                            <td>{item.mensagem}</td>
                        </tr>
                    )}
                </tbody>
            </Table>) : <Alert variant='warning'>Nenhuma bonificação foi realizada. Envie moedinhas!</Alert>}
        </Container>
    );
}

export default ProfHistorico;