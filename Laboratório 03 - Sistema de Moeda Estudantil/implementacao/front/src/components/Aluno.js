import React, { useState } from "react";
import { criarAluno } from "../services/Aluno";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { easing } from "@mui/material";

const Aluno = () => {
  const [login, setLogin] = useState(false);
  const [cadastro, setCadastro] = useState(true);

  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [cpf, setCpf] = useState("");
  const [rg, setRg] = useState("");
  const [curso, setCurso] = useState("");
  const [instituicao, setInstituicao] = useState("");
  const [endereco, setEndereco] = useState("");

  const onSubmitLogin = async () => {
    const data = {
      nome: nome,
      email: email,
      senha: password,
    };
    const response = await criarAluno(data);
    console.log(response);
  };

  const onSubmitCadastro = async () => {
    const data = {
      nome: nome,
      email: email,
      senha: password,
      cpf: cpf,
      rg: rg,
      endereco: endereco,
      curso: curso,
      idInstituicao: instituicao,
    };

    const resp = await criarAluno(data);
    console.log(resp);
  };

  const FormCadastro = () => {
    return (
      <Form>
        <Form.Group className="mb-1" controlId="formBasicText">
          <Form.Label>Nome</Form.Label>
          <Form.Control
            type="text"
            placeholder="Insira seu nome"
            value={nome}
            onChange={(text) => setNome(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-1" controlId="formBasicEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            placeholder="Insira seu email"
            value={email}
            onChange={(text) => setEmail(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-1" controlId="formBasicPassword">
          <Form.Label>Senha</Form.Label>
          <Form.Control
            type="password"
            placeholder="Insira a senha"
            value={password}
            onChange={(text) => setPassword(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>CPF</Form.Label>
          <Form.Control
            type="text"
            placeholder="Insira seu CPF"
            maxLength={10}
            value={cpf}
            onChange={(text) => setCpf(text.target.value)}
          />
        </Form.Group>
        <Form.Group className="mb-1">
          <Form.Label>RG</Form.Label>
          <Form.Control
            type="text"
            placeholder="Insira seu RG"
            maxLength={8}
            value={rg}
            onChange={(text) => setRg(text.target.value)}
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Endereco</Form.Label>
          <Form.Control
            type="text"
            value={endereco}
            placeholder="Insira seu endereço"
            onChange={(text) => setEndereco(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>Curso</Form.Label>
          <Form.Control
            type="text"
            value={curso}
            placeholder="Insira seu curso"
            onChange={(text) => setCurso(text.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>Id da Instituicao</Form.Label>
          <Form.Control
            type="number"
            value={instituicao}
            placeholder="Insira o código da instituição"
            onChange={(text) => setInstituicao(text.target.value)}
          />
        </Form.Group>

        <Button variant="primary" type="submit" onClick={onSubmitCadastro}>
          Cadastrar
        </Button>
      </Form>
    );
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

  return (
    <>
      {login && FormLogin()}
      {cadastro && FormCadastro()}
    </>
  );
};

export default Aluno;
