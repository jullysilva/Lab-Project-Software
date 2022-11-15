import { useState } from "react";
import { Button, Form, Col, Row } from "react-bootstrap";
import { consultarExtratoAluno, resgatarVantagem } from "../../services/AlunoService";


const AlunoVantagem = () => {
    const [codVantagem, setCodVantagem] = useState(1);
    const [qtdMoedas, setQtdMoedas] = useState(0);
    const [aluno, setAluno] = useState({
        codAluno: 1,
        nome: '',
        email: '',
        password: ''
      });

    const onHandleRanson = async (e) => {
        e.preventDefault();
        const idVantagem = codVantagem;
        const idAluno = parseInt(localStorage.getItem("codigo-aluno") || aluno.codAluno);
        await resgatarVantagem(idVantagem, idAluno);
        const valor = await consultarExtratoAluno(idAluno);
        setQtdMoedas(valor);
      };

    return(
        <Form>
          <Row>
            <Form.Group as={Col}>
              <Form.Label>Código da vantagem</Form.Label>
              <Form.Control
                type="text"
                value={codVantagem}
                placeholder="Insira o código da vantagem"
                onChange={(text) => setCodVantagem(text.target.value)}
                required
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Código</Form.Label>
              <Form.Control
                type="number"
                value={aluno.codAluno}
                placeholder="Insira seu código"
                onChange={(text) => {
                  aluno.codAluno = text.target.value;
                  setAluno({...aluno});
                }} required
              />
            </Form.Group>
          </Row>

          <Button
            variant="success"
            type="submit"
            className="mt-2"
            onClick={(e) => onHandleRanson(e)}
          >
            Resgatar
          </Button>
        </Form>
    );
};

export default AlunoVantagem;