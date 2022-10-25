import React, { useState } from "react";
import { Form, Button, Container, Row } from "react-bootstrap";
import { enviarBonificacao, loginProfessor } from "../services/Professor";

const Professor = () => {
  const [login, setLogin] = useState(true);
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [enviar, setEnviar] = useState(false);
  const [codAluno, setCodAluno] = useState();
  const [qtd, setQtd] = useState(0);
  const [mensagem, setMensagem] = useState("");

  const onSubmitLogin = async (e) => {
    await setLogin(false);
    e.preventDefault();
    const data = {
      nome: nome,
      email: email,
      senha: password,
    };
    const resp = await loginProfessor(data);
    if (resp) {
      setLogin(false);
    }
  };

  const onSendMoney = async (e) => {
    e.preventDefault();
    const data = {
      custo: qtd,
      mensagem: mensagem,
      idProfessor: 1,
      idAluno: codAluno,
    };
    const resp = await enviarBonificacao(data);
    console.log(resp);
    setEnviar(true);
  };

  const FormLogin = () => {
    return (
      <Form>
        <Form.Group className="mb-3" controlId="formBasicText">
          <Form.Label>Nome</Form.Label>
          <Form.Control
            type="text"
            value={nome}
            placeholder="Insira seu nome"
            onChange={(text) => setNome(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            value={email}
            placeholder="Insira seu email"
            onChange={(text) => setEmail(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Senha</Form.Label>
          <Form.Control
            type="password"
            value={password}
            placeholder="Insira a senha"
            onChange={(text) => setPassword(text.target.value)}
          />
        </Form.Group>

        <Button
          variant="primary"
          type="submit"
          onClick={(e) => onSubmitLogin(e)}
        >
          Cadastrar
        </Button>
      </Form>
    );
  };

  return (
    <Container>
      {login && FormLogin()}
      {!login && (
        <Container>
          <Row>
            <Button
              variant="primary"
              type="submit"
              onClick={() => setEnviar(true)}
            >
              Enviar Moedas
            </Button>
            <Button
              variant="success"
              type="submit"
              onClick={(e) => console.log(e)}
            >
              Consultar extrato
            </Button>
          </Row>
        </Container>
      )}
      {enviar && (
        <Form>
          <Form.Group className="mb-3" controlId="formBasicText">
            <Form.Label>Para qual aluno (Código do aluno)</Form.Label>
            <Form.Control
              type="text"
              value={codAluno}
              placeholder="Insira o código do aluno"
              onChange={(text) => setCodAluno(text.target.value)}
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Label>Mensagem</Form.Label>
            <Form.Control
              type="text"
              value={mensagem}
              placeholder="Escreva uma mensagem"
              onChange={(text) => setMensagem(text.target.value)}
            />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Quantidade</Form.Label>
            <Form.Control
              type="number"
              value={qtd}
              placeholder="Insira a quantidade"
              onChange={(text) => setQtd(text.target.value)}
            />
          </Form.Group>

          <Button
            variant="success"
            type="submit"
            onClick={(e) => onSendMoney(e)}
          >
            Enviar Moedas
          </Button>
        </Form>
      )}
    </Container>
  );
};
export default Professor;
