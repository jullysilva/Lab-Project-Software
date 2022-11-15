import React, { useState } from "react";
import {
  Card,
  Container,
  Row,
  Button,
  Table,
  Form,
  Col,
} from "react-bootstrap";
import { criarAluno } from "../services/Aluno";
import { criarInstituicao } from "../services/Instituicao";
import { criarProfessor } from "../services/Professor";
import { criarVantagem, buscarVantagens } from "../services/Vantagens";
import Aluno from "./Aluno";
import Professor from "./Professor";

const Home = () => {
  const [createP, setCreateP] = useState(false);
  const [createA, setCreateA] = useState(false);
  const [aluno, setAluno] = useState(false);
  const [professor, setProfessor] = useState(false);
  const [cadastrarVantagem, setCadastrarVantagem] = useState(false);
  const [vantagens, setVantagens] = useState();
  const [empresa, setEmpresa] = useState(false);

  const [custo, setCusto] = useState("");
  const [descricao, setDescricao] = useState("");

  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [idInst, setIdInst] = useState(1);
  const [cpf, setCpf] = useState();
  const [departamento, setDepartamento] = useState();

  const [rg, setRg] = useState("");
  const [curso, setCurso] = useState("");
  const [instituicao, setInstituicao] = useState("");
  const [endereco, setEndereco] = useState("");

  const [nomeEmpresa,setNomeEmpresa] =useState("");

  const onSubmitCadastroEmpresa = async (e) => {
    e.preventDefault();
    const data = {
      nome: nome
    };
    const response = await criarInstituicao(data);
    if (response) {
      setNomeEmpresa(response.nome);
      setEmpresa(false);
    
    }
    setEmpresa(false);
  };

  const onHandleGenerate = async () => {
    const data = {
      nome: "Una",
    };
    await criarInstituicao(data);
  };

  const handleRegisterVantagem = async (e) => {
    e.preventDefault();
    const data = {
      custo: custo,
      descricao: descricao,
    };
    await criarVantagem(data);
    setCadastrarVantagem(false);
    onLoadVantagens();
    setCusto("");
    setDescricao("");
  };

  const onLoadVantagens = async () => {
    const resp = await buscarVantagens();
    setVantagens(resp);
  };

  const onSubmitCadastroProf = async (e) => {
    e.preventDefault();
    const data = {
      nome: nome,
      email: email,
      senha: password,
      idInstituicao: idInst,
      cpf: cpf,
      departamento: departamento,
    };
    const res = await criarProfessor(data);
    localStorage.setItem("codigo-prof", res.id);
    AcessoP();
  };

  const onSubmitCadastroAlu = async (e) => {
    e.preventDefault();
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
    localStorage.setItem("codigo-aluno", resp.id);
    AcessoA();
  };

  const RegistroP = () => {
    setCadastrarVantagem(false);
    setVantagens(false);
    setAluno(false);
    setCreateA(false);
    setCreateP(true);
    setProfessor(false);
  };

  const AcessoP = () => {
    setCadastrarVantagem(false);
    setVantagens(false);
    setAluno(false);
    setCreateA(false);
    setCreateP(false);
    setProfessor(true);
  };

  const RegistroA = () => {
    setCadastrarVantagem(false);
    setVantagens(false);
    setAluno(false);
    setCreateA(true);
    setCreateP(false);
    setProfessor(false);
  };

  const AcessoA = () => {
    setCadastrarVantagem(false);
    setVantagens(false);
    setAluno(true);
    setCreateA(false);
    setCreateP(false);
    setProfessor(false);
  };

  const cadastroV = () => {
    setCadastrarVantagem(true);
    setVantagens(false);
    setAluno(false);
    setCreateA(false);
    setCreateP(false);
    setProfessor(false);
  };
  const cadastroEmpresa = () => {
    setEmpresa(true);
    setVantagens(false);
    setAluno(false);
    setCreateA(false);
    setCreateP(false);
    setProfessor(false);
  }

  return (
    <>
      <Container onLoad={onHandleGenerate} className="mt-3">
        <Row style={{ justifyContent: "space-evenly" }}>
          <Card style={{ width: "18rem" }}>
            <Card.Body>
              <Card.Title>Portal Aluno</Card.Title>
              <Row>
                <Col>
                  <Button variant="success" onClick={AcessoA}>
                    Acessar
                  </Button>
                </Col>
                <Col>
                  <Button variant="primary" onClick={RegistroA}>
                    Registrar
                  </Button>
                </Col>
              </Row>
            </Card.Body>
          </Card>

          <Card style={{ width: "18rem" }}>
            <Card.Body>
              <Card.Title>Portal Professor</Card.Title>
              <Row>
                <Col>
                  <Button variant="success" onClick={AcessoP}>
                    Acessar
                  </Button>
                </Col>
                <Col>
                  <Button variant="primary" onClick={RegistroP}>
                    Registrar
                  </Button>
                </Col>
              </Row>
            </Card.Body>
          </Card>

          <Card style={{ width: "18rem" }}>
            <Card.Body>
              <Card.Title>Empresa</Card.Title>
              <Row>
                <Col>
                  <Button variant="primary" onClick={cadastroV}>
                    Cadastrar Vantagem
                  </Button>
                </Col>
                <Col>
                  <Button variant="success" onClick={cadastroEmpresa}>
                    Cadastrar Empresa
                  </Button>
                </Col>
              </Row>


            </Card.Body>
          </Card>
        </Row>
      </Container>
      <Container>
        {cadastrarVantagem && (
          <Form>
            <Form.Group className="mb-3">
              <Form.Label>Descrição</Form.Label>
              <Form.Control
                type="text"
                placeholder="Descreva a vantagem"
                value={descricao}
                onChange={(e) => setDescricao(e.target.value)}
                required
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Quantas moedas?</Form.Label>
              <Form.Control
                type="number"
                placeholder="Custo"
                value={custo}
                onChange={(e) => setCusto(e.target.value)}
                required
              />
            </Form.Group>
            <Button
              variant="primary"
              type="submit"
              onClick={(e) => handleRegisterVantagem(e)}
            >
              Cadastrar
            </Button>
          </Form>
        )}
        {vantagens && (
          <Table striped bordered hover className="mt-2">
            <thead>
              <tr>
                <th>#</th>
                <th>Custo</th>
                <th>Descricao</th>
              </tr>
            </thead>
            <tbody>
              {vantagens.map((vantagem) => {
                return (
                  <tr>
                    <td>{vantagem.id}</td>
                    <td>{vantagem.custo} moedas</td>
                    <td>{vantagem.descricao}</td>
                  </tr>
                );
              })}
            </tbody>
          </Table>
        )}

{empresa && (
           <Form>
           <Row>
             <Form.Group as={Col}>
               <Form.Label>Nome</Form.Label>
               <Form.Control
                 type="text"
                 placeholder="Insira seu nome"
                 onChange={(text) => setNomeEmpresa(text.target.value)} required
               />
             </Form.Group>
           </Row>
           <Button
             className="mt-2"
             variant="primary"
             type="submit"
             onClick={(e) => onSubmitCadastroEmpresa(e)}
           >
             Cadastrar
           </Button>
         </Form>
        )}
        {aluno && !createA && <Aluno />}
        {professor && !createP && <Professor />}
        {createP && (
          <Form>
            <Row className="mb-3 mt-3">
              <Form.Group as={Col}>
                <Form.Label>Nome</Form.Label>
                <Form.Control
                  type="text"
                  value={nome}
                  placeholder="Insira seu nome"
                  onChange={(e) => setNome(e.target.value)}
                  required
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>Email</Form.Label>
                <Form.Control
                  type="email"
                  value={email}
                  placeholder="Insira seu email"
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
              </Form.Group>
            </Row>
            <Row>
              <Form.Group as={Col}>
                <Form.Label>Senha</Form.Label>
                <Form.Control
                  type="password"
                  value={password}
                  placeholder="Insira a senha"
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>Código da Instituicao</Form.Label>
                <Form.Control
                  type="number"
                  value={idInst}
                  placeholder="Código da instituição"
                  onChange={(e) => setIdInst(e.target.value)}
                  required
                />
              </Form.Group>
            </Row>
            <Row className="mb-3">
              <Form.Group as={Col} controlId="formGridCity">
                <Form.Label>CPF</Form.Label>
                <Form.Control
                  type="text"
                  value={cpf}
                  maxLength={10}
                  placeholder="Insira seu CPF"
                  onChange={(e) => setCpf(e.target.value)}
                  required
                />
              </Form.Group>

              <Form.Group as={Col} controlId="formGridZip">
                <Form.Label>Departamento</Form.Label>
                <Form.Control
                  type="text"
                  value={departamento}
                  placeholder="Insira o Departamento"
                  onChange={(e) => setDepartamento(e.target.value)}
                  required
                />
              </Form.Group>
            </Row>

            <Button
              variant="primary"
              type="submit"
              onClick={onSubmitCadastroProf}
            >
              Cadastrar
            </Button>
          </Form>
        )}
        {createA && (
          <Form>
            <Row>
              <Form.Group as={Col}>
                <Form.Label>Nome</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Insira seu nome"
                  value={nome}
                  onChange={(text) => setNome(text.target.value)}
                  required
                />
              </Form.Group>

              <Form.Group as={Col}>
                <Form.Label>Email</Form.Label>
                <Form.Control
                  type="email"
                  placeholder="Insira seu email"
                  value={email}
                  onChange={(text) => setEmail(text.target.value)}
                  required
                />
              </Form.Group>
            </Row>
            <Row>
              <Form.Group as={Col}>
                <Form.Label>Senha</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Insira a senha"
                  value={password}
                  onChange={(text) => setPassword(text.target.value)}
                  required
                />
              </Form.Group>

              <Form.Group as={Col}>
                <Form.Label>CPF</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Insira seu CPF"
                  maxLength={10}
                  value={cpf}
                  onChange={(text) => setCpf(text.target.value)}
                  required
                />
              </Form.Group>
            </Row>
            <Row>
              <Form.Group as={Col}>
                <Form.Label>RG</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Insira seu RG"
                  maxLength={8}
                  value={rg}
                  onChange={(text) => setRg(text.target.value)}
                  required
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>Endereco</Form.Label>
                <Form.Control
                  type="text"
                  value={endereco}
                  placeholder="Insira seu endereço"
                  onChange={(text) => setEndereco(text.target.value)}
                  required
                />
              </Form.Group>
            </Row>
            <Row>
              <Form.Group as={Col}>
                <Form.Label>Curso</Form.Label>
                <Form.Control
                  type="text"
                  value={curso}
                  placeholder="Insira seu curso"
                  onChange={(text) => setCurso(text.target.value)}
                  required
                />
              </Form.Group>

              <Form.Group as={Col}>
                <Form.Label>Id da Instituicao</Form.Label>
                <Form.Control
                  type="number"
                  value={instituicao}
                  placeholder="Insira o código da instituição"
                  onChange={(text) => setInstituicao(text.target.value)}
                  required
                />
              </Form.Group>
            </Row>

            <Button
              className="mt-2"
              variant="primary"
              type="submit"
              onClick={(e) => onSubmitCadastroAlu(e)}
            >
              Cadastrar
            </Button>
          </Form>
        )}
      </Container>
    </>
  );
};

export default Home;
