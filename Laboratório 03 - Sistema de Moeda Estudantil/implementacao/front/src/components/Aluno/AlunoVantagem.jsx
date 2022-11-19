import { useEffect, useState } from "react";
import { Button, Form, Col, Row, Container, Badge, Alert } from "react-bootstrap";
import { buscarMoedas, resgatarVantagem } from "../../services/AlunoService";
import { buscarVantagens } from "../../services/VantagensService";
import AlunoHistorico from "./AlunoHistorico";


const AlunoVantagem = () => {
    const [validated, setValidated] = useState(false);
    const [message, setMessage] = useState();
    const [showMessage, setShowMessage] = useState(false);
    const [listData, setListData] = useState();
    const [codVantagem, setCodVantagem] = useState(1);
    const [qtdMoedas, setQtdMoedas] = useState(0);
    const [history, setHistory] = useState(false);
    const [showVantagem, setShowVantagem] = useState(false);
    const [aluno, setAluno] = useState({
        codAluno: localStorage.getItem('codigo-aluno') || 0,
        nome: null,
        email: null,
        password: null
    });

    useEffect(() => {
      async function carregaVantagens () {
          const resposta = await buscarVantagens();
          setListData(resposta);
          const valor = await buscarMoedas(aluno.codAluno);
          setQtdMoedas(valor);
      }
      carregaVantagens();
    }, []);

    const onHandleRanson = async (e) => {
        e.preventDefault();
        const form = e.currentTarget;

        if(form.checkValidity() === true){
          const idVantagem = codVantagem;
          const idAluno = localStorage.getItem("codigo-aluno") || aluno.codAluno;
          const res = await resgatarVantagem(idVantagem, idAluno);
          if(res.status === 400){
            setMessage(res.data.message);
            setShowMessage(true);
          }else{
            setMessage('Seu resgate foi realizdo com sucesso!');
          }
          const valor = await buscarMoedas(idAluno);
          setQtdMoedas(valor);
        }else{
          e.stopPropagation();
        }
        setValidated(true);
      };

    return(
      <Container>
        <Container className="m-3">
          <Row>
            <Col xs={12} md={5}>
              <Button
                className="w-100"
                variant="primary"
                type="submit"
                onClick={() => {setShowVantagem(true);
                setHistory(false);}}
              >
                Regastar vantagens
              </Button>
            </Col>
            <Col xs={12} md={5}>
              <Button
                className="w-100"
                variant="dark"
                type="submit"
                onClick={() => {setShowVantagem(false);
                setHistory(true)}}
              >
                Histórico
              </Button>
            </Col>
            <Col xs={6} md={2}>
                <Button variant="light" className="w-100">
                  MOEDAS <Badge bg="danger">{qtdMoedas}</Badge>
                </Button>
            </Col>
          </Row>
        </Container>
      
      {showVantagem && !history && <Container>
        <Form noValidate validated={validated} onSubmit={onHandleRanson}>
          {showMessage && <Alert>{message}</Alert>}
          <Row>
            <Form.Group as={Col}>
              <Form.Label>Vantagens cadastradas</Form.Label>
              {listData ? (<Form.Select value={codVantagem} onChange={(text) => setCodVantagem(text.target.value)}>
                {listData?.map((item) =>
                  <option key={item.id} value={item.id}>{item.custo} moedas - {item.descricao}</option>
                  )}
              </Form.Select>) : null}
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Código (Aluno)</Form.Label>
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
          >
            Resgatar
          </Button>
        </Form>
      </Container>}
      {history && !showVantagem && <AlunoHistorico/>}
      </Container>
    );
};

export default AlunoVantagem;