import React, { useState } from "react";
import {
  Form,
  Button,
  Container,
  Row,
  Col,
  Alert
} from "react-bootstrap";
import {
  loginProfessor,
} from "../../services/ProfessorService";
import ProfBonificacao from "./ProfBonificação";

const Professor = () => {
  const [validated, setValidated] = useState(false);
  const [message, setMessage] = useState(false);
  const [login, setLogin] = useState(true);
  const [professor, setProfessor] = useState({
    id: null,
    nome: null,
    email: null,
    senha: null,
  });

  const onSubmitLogin = async (e) => {
    e.preventDefault();
    const form = e.currentTarget;
    
    if (form.checkValidity() === true) {
      const resp = await loginProfessor(professor);
      if (resp === true) {
        localStorage.setItem("codigo-prof", professor.id);
        setLogin(false);
      }
      else{
        setMessage(true);
      };
    }
    else{
      e.stopPropagation();
    }
    setValidated(true);
  };

  return (
    <Container>
      {login && <Form noValidate validated={validated} onSubmit={onSubmitLogin}>
        {message && <Alert variant='danger'>Dados incorretos!</Alert>}
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
              value={professor.senha}
              placeholder="Insira a senha"
              onChange={(text) => {
                professor.senha = text.target.value;
                setProfessor({...professor});
              }}
              required
            />
          </Form.Group>

          <Form.Group as={Col}>
            <Form.Label>Código</Form.Label>
            <Form.Control
              type="text"
              value={professor.id}
              placeholder="Insira o código"
              onChange={(text) => {
                professor.id = text.target.value;
                setProfessor({...professor});  
              }}
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
      </Form>}
      {!login && <ProfBonificacao />}
    </Container>
  );
};
export default Professor;
