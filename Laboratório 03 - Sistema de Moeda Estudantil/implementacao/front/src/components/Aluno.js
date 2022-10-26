import React, { useState } from "react";
import { loginAluno } from "../services/Aluno";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

const Aluno = () => {
  const [login, setLogin] = useState(false);

  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const onSubmitLogin = async () => {
    const data = {
      nome: nome,
      email: email,
      senha: password,
    };
    const response = await loginAluno(data);
    console.log(response);
  };

  const FormLogin = () => {
    return (
      <Form>
        <Form.Group className="mb-3" controlId="formBasicText">
          <Form.Label>Nome</Form.Label>
          <Form.Control
            type="text"
            placeholder="Insira seu nome"
            onChange={(text) => setNome(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            placeholder="Insira seu email"
            onChange={(text) => setEmail(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Senha</Form.Label>
          <Form.Control
            type="password"
            placeholder="Insira a senha"
            onChange={(text) => setPassword(text.target.value)}
          />
        </Form.Group>

        <Button variant="primary" type="submit" onClick={onSubmitLogin}>
          Cadastrar
        </Button>
      </Form>
    );
  };

  return <>{login && FormLogin()}</>;
};

export default Aluno;
