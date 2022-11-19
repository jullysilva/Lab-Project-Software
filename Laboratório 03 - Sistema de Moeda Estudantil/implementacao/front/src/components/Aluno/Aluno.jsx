import React, { useState } from "react";
import {
  loginAluno,
} from "../../services/AlunoService";
import { Form, Col, Button, Row, Alert } from "react-bootstrap";
import AlunoVantagem from "./AlunoVantagem";

const Aluno = () => {
  const [validated, setValidated] = useState(false);
  const [message, setMessage] = useState(false);
  const [login, setLogin] = useState(false);
  const [aluno, setAluno] = useState({
    id: 0,
    nome: null,
    email: null,
    senha: null
  });

  const onSubmitLogin = async (e) => {
    e.preventDefault();
    const form = e.currentTarget;
    if(form.checkValidity() === true){
      const response = await loginAluno(aluno);
      if (response) {
        localStorage.setItem('codigo-aluno', aluno.id);
        setLogin(true);
      }else{
        setMessage(true);
      }
    }else{
      e.stopPropagation();
    }
      setValidated(true);
  };
  

  const FormLogin = () => {
    return (
      <Form noValidate validated={validated} onSubmit={onSubmitLogin}>
        {message && <Alert variant="danger">Erro ao logar. Tente novamente!</Alert>}
        <Row>
          <Form.Group as={Col}>
            <Form.Label>Nome</Form.Label>
            <Form.Control
              type="text"
              placeholder="Insira seu nome"
              value={aluno.nome}
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
              value={aluno.email}
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
              value={aluno.id}
              onChange={(text) => { 
                aluno.id = text.target.value;
                setAluno({...aluno});
              }} required
            />
          </Form.Group>
          <Form.Group as={Col}>
            <Form.Label>Senha</Form.Label>
            <Form.Control
              type="password"
              placeholder="Insira a senha"
              value={aluno.senha}
              onChange={(text) => {
                aluno.senha = text.target.value;
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
      {!login && FormLogin()}
      {login && <AlunoVantagem />}
    </>
  );
};

export default Aluno;
