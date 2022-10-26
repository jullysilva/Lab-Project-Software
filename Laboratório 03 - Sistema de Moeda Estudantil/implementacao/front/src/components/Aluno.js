import React, { useState } from "react";
import {
  loginAluno,
  resgatarVantagem,
  consultarExtratoAluno,
} from "../services/Aluno";
import { Form, Col, Button, Row, Container, Badge } from "react-bootstrap";

const Aluno = () => {
  const [resgate, setResgate] = useState(false);
  const [moedas, setMoedas] = useState(false);
  const [showVantagem, setShowVantagem] = useState(false);

  const [codAluno, setCodAluno] = useState(1);
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [qtdMoedas, setQtdMoedas] = useState(0);
  const [codVantagem, setCodVantagem] = useState(1);

  const onSubmitLogin = async (e) => {
    e.preventDefault();
    const data = {
      id: localStorage.getItem("codigo-aluno") || codAluno,
      nome: nome,
      email: email,
      senha: password,
    };
    const response = await loginAluno(data);
    if (response) {
      setResgate(true);
    }
  };

  const onHandleRanson = async (e) => {
    e.preventDefault();
    const idVantagem = codVantagem;
    const idAluno = parseInt(localStorage.getItem("codigo-aluno") || codAluno);
    await resgatarVantagem(idVantagem, idAluno);
    const valor = await consultarExtratoAluno(idAluno);
    setMoedas(true);
    setQtdMoedas(valor);
  };

  const FormLogin = () => {
    return (
      <Form>
        <Row>
          <Form.Group as={Col}>
            <Form.Label>Nome</Form.Label>
            <Form.Control
              type="text"
              placeholder="Insira seu nome"
              onChange={(text) => setNome(text.target.value)}
            />
          </Form.Group>

          <Form.Group as={Col}>
            <Form.Label>Email</Form.Label>
            <Form.Control
              type="email"
              placeholder="Insira seu email"
              onChange={(text) => setEmail(text.target.value)}
            />
          </Form.Group>
        </Row>
        <Row>
          <Form.Group as={Col}>
            <Form.Label>Código</Form.Label>
            <Form.Control
              type="text"
              placeholder="Insira seu código"
              onChange={(text) => setCodAluno(text.target.value)}
            />
          </Form.Group>
          <Form.Group as={Col}>
            <Form.Label>Senha</Form.Label>
            <Form.Control
              type="password"
              placeholder="Insira a senha"
              onChange={(text) => setPassword(text.target.value)}
            />
          </Form.Group>
        </Row>
        <Button
          className="mt-2"
          variant="primary"
          type="submit"
          onClick={(e) => onSubmitLogin(e)}
        >
          Entrar
        </Button>
      </Form>
    );
  };

  return (
    <>
      {!resgate && FormLogin()}
      {resgate && (
        <Container className="m-3">
          <Row>
            <Col xs={12} md={10}>
              <Button
                className="w-100"
                variant="primary"
                type="submit"
                onClick={() => setShowVantagem(true)}
              >
                Regastar vantagens
              </Button>
            </Col>
            <Col xs={6} md={2}>
              {moedas && (
                <Button variant="light" className="w-100">
                  MOEDAS <Badge bg="danger">{qtdMoedas}</Badge>
                </Button>
              )}
            </Col>
          </Row>
        </Container>
      )}
      {showVantagem && (
        <Form>
          <Row>
            <Form.Group as={Col}>
              <Form.Label>Código da vantagem</Form.Label>
              <Form.Control
                type="text"
                value={codVantagem}
                placeholder="Insira o código da vantagem"
                onChange={(text) => setCodVantagem(text.target.value)}
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Código</Form.Label>
              <Form.Control
                type="number"
                value={codAluno}
                placeholder="Insira seu código"
                onChange={(text) => setCodAluno(text.target.value)}
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
      )}
    </>
  );
};

export default Aluno;
