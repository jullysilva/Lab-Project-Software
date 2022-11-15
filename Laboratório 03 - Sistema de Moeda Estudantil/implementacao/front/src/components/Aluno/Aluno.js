import React, { useState } from "react";
import {
  loginAluno,
} from "../../services/AlunoService";
import { Form, Col, Button, Row, Container, Badge } from "react-bootstrap";
import AlunoVantagem from "./AlunoVantagem";

const Aluno = () => {
  const [validated, setValidated] = useState(false);
  const [resgate, setResgate] = useState(false);
  const [moedas, setMoedas] = useState(0);
  const [showVantagem, setShowVantagem] = useState(false);
  const [aluno, setAluno] = useState({
    codAluno: 0,
    nome: null,
    email: null,
    password: null
  });

  

  const onSubmitLogin = async (e) => {
    const form = e.currentTarget;
    e.preventDefault();
    if(form.checkValidity() === true){
      const data = {
        id: localStorage.getItem("codigo-aluno") || aluno.codAluno,
        nome: aluno.nome,
        email: aluno.email,
        senha: aluno.password,
      };
      const response = await loginAluno(data);
      if (response) {
        setResgate(true);
      }
    }else{
      e.stopPropagation();
    }
      setValidated(true);
  };

  

  const FormLogin = () => {
    return (
      <Form noValidate validated={validated} onSubmit={onSubmitLogin}>
        <Row>
          <Form.Group as={Col}>
            <Form.Label>Nome</Form.Label>
            <Form.Control
              type="text"
              placeholder="Insira seu nome"
              onChange={(text) => {
                aluno.nome = text.target.value;
                setAluno({...aluno});
              }} required
            />
          </Form.Group>

          <Form.Group as={Col}>
            <Form.Label>Email</Form.Label>
            <Form.Control
              type="email"
              placeholder="Insira seu email"
              onChange={(text) => {
                aluno.email = text.target.value;
                setAluno({...aluno});
              }} required
            />
          </Form.Group>
        </Row>
        <Row>
          <Form.Group as={Col}>
            <Form.Label>Código</Form.Label>
            <Form.Control
              type="text"
              placeholder="Insira seu código"
              onChange={(text) => { 
                aluno.codAluno = text.target.value;
                setAluno({...aluno});
              }} required
            />
          </Form.Group>
          <Form.Group as={Col}>
            <Form.Label>Senha</Form.Label>
            <Form.Control
              type="password"
              placeholder="Insira a senha"
              onChange={(text) => {
                aluno.password = text.target.value;
                setAluno({...aluno});
              }} required
            />
          </Form.Group>
        </Row>
        <Button
          className="mt-2"
          variant="primary"
          type="submit"
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
                <Button variant="light" className="w-100">
                  MOEDAS <Badge bg="danger">qtdMoedas</Badge>
                </Button>
            </Col>
          </Row>
        </Container>
      )}
      {showVantagem && <AlunoVantagem />}
    </>
  );
};

export default Aluno;
