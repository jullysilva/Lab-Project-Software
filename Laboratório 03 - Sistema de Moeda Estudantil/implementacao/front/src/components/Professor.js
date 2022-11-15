import React, { useState } from "react";
import {
  Form,
  Button,
  Container,
  Row,
  Col,
  Alert,
  Badge,
} from "react-bootstrap";
import {
  enviarBonificacao,
  loginProfessor,
  consultarExtratoProfessor,
} from "../services/ProfessorService";

const Professor = () => {
  const [validated, setValidated] = useState(false);
  const [login, setLogin] = useState(true);
  const [professor, setProfessor] = useState({
    codProfessor: 0,
    nome: null,
    email: null,
    password: null,
  });

  const [codigo, setCodigo] = useState(1);

  const [enviar, setEnviar] = useState(false);
  const [codAluno, setCodAluno] = useState();
  const [codProfessor, setCodProfessor] = useState(1);
  const [qtd, setQtd] = useState(0);
  const [mensagem, setMensagem] = useState("");

  const [showAlert, setShowAlert] = useState(false);
  const [qtdMoedas, setQtdMoedas] = useState();

  const buscarMoedas = async () => {
    const idProfessor = parseInt(
      localStorage.getItem("codigo-prof" || professor.codProfessor)
    );
    const resp = await consultarExtratoProfessor(idProfessor);
    await setQtdMoedas(resp);
  };

  const onSubmitLogin = async (e) => {
    setLogin(false);
    e.preventDefault();
    const form = e.currentTarget;
    const data = {
      id: codigo,
      nome: professor.nome,
      email: professor.email,
      senha: professor.password,
    };
    if (form.checkValidity() !== false) {
      const resp = await loginProfessor(data);
      if (resp === true) {
        localStorage.setItem("codigo-prof", codigo);
        setLogin(false);
      }
      else{
        console.log('deu ruim');
      };
    }
    else{
      e.stopPropagation();
    }
    setValidated(true);
  };

  const onSendMoney = async (e) => {
    e.preventDefault();
    const data = {
      custo: qtd,
      mensagem: mensagem,
      idProfessor: professor.codProfessor,
      idAluno: codAluno,
    };
    await enviarBonificacao(data);
    setShowAlert(true);
    setEnviar(true);
    await buscarMoedas(professor.codProfessor);
  };

  const FormLogin = () => {
    return (
      <Form noValidate validated={validated} onSubmit={onSubmitLogin}>
        <Row className="mb-3">
          <Form.Group as={Col}>
            <Form.Label>Nome</Form.Label>
            <Form.Control
              type="text"
              value={professor.nome}
              placeholder="Insira seu nome"
              onChange={(text) => {
                professor.nome = text.target.value;
                setProfessor({...professor});
              }}
              required
            />
          </Form.Group>

          <Form.Group as={Col}>
            <Form.Label>Email</Form.Label>
            <Form.Control
              type="email"
              value={professor.email}
              placeholder="Insira seu email"
              onChange={(text) => {
                professor.email = text.target.value;
                setProfessor({...professor});
              }}
              required
            />
          </Form.Group>
        </Row>
        <Row>
          <Form.Group as={Col}>
            <Form.Label>Senha</Form.Label>
            <Form.Control
              type="password"
              value={professor.password}
              placeholder="Insira a senha"
              onChange={(text) => {
                professor.password = text.target.value;
                setProfessor({...professor});
              }}
              required
            />
          </Form.Group>

          <Form.Group as={Col}>
            <Form.Label>Código</Form.Label>
            <Form.Control
              type="text"
              value={codigo}
              placeholder="Insira o código"
              onChange={(text) => setCodigo(text.target.value)}
              required
            />
          </Form.Group>
        </Row>
        <Button
          className="mt-2"
          variant="primary"
          type="submit">
          Login
        </Button>
      </Form>
    );
  };

  return (
    <Container>
      {login && FormLogin()}
      {!login && (
        <Container className="m-3">
          <Row>
            <Col xs={12} md={10}>
              <Button
                className="w-100"
                variant="primary"
                type="submit"
                onClick={() => setEnviar(true)}
              >
                Doar Moedas
              </Button>
            </Col>
            <Col xs={6} md={2}>
              <Button variant="light" className="w-100">
                MOEDAS <Badge bg="danger">{qtdMoedas}</Badge>
              </Button>
            </Col>
          </Row>
        </Container>
      )}
      {enviar && (
        <Form>
          <Row>
            <Form.Group as={Col}>
              <Form.Label>Para qual aluno (Código do aluno)</Form.Label>
              <Form.Control
                type="text"
                value={codAluno}
                placeholder="Insira o código do aluno"
                onChange={(text) => setCodAluno(text.target.value)}
                required
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Quantidade</Form.Label>
              <Form.Control
                type="number"
                value={qtd}
                placeholder="Insira a quantidade"
                onChange={(text) => setQtd(text.target.value)}
                required
              />
            </Form.Group>
          </Row>
          <Row>
            <Form.Group as={Col} className="mt-1">
              <Form.Label>Código Professor</Form.Label>
              <Form.Control
                type="number"
                value={codProfessor}
                placeholder="Insira seu código"
                onChange={(text) => setCodProfessor(text.target.value)}
                required
              />
            </Form.Group>
            <Form.Group as={Col} className="mt-1">
              <Form.Label>Mensagem</Form.Label>
              <Form.Control
                type="text"
                value={mensagem}
                placeholder="Escreva uma mensagem"
                onChange={(text) => setMensagem(text.target.value)}
                required
              />
            </Form.Group>
          </Row>

          <Row className="m-2">
            {showAlert && (
              <Alert variant="success">
                Você enviou {qtd || 1000} moedas para seu aluno!
              </Alert>
            )}
          </Row>

          <Button
            variant="success"
            type="submit"
            className={!showAlert ? "mt-2" : "mt-0"}
            onClick={(e) => onSendMoney(e)}
          >
            Enviar
          </Button>
        </Form>
      )}
    </Container>
  );
};
export default Professor;
