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
import { criarInstituicao } from "../services/InstituicaoService";
import { criarVantagem, buscarVantagens } from "../services/VantagensService";
import Aluno from "./Aluno/Aluno";
import AlunoCadastro from "./Aluno/AlunoCadastro";
import ProfCadastro from "./Professor/ProfCadastro";
import Professor from "./Professor/Professor";

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

  const [nomeEmpresa,setNomeEmpresa] =useState("");

  const onSubmitCadastroEmpresa = async (e) => {
    e.preventDefault();
    const data = {
      nome: nomeEmpresa
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
        {createP && <ProfCadastro />}
        {createA && <AlunoCadastro />}
      </Container>
    </>
  );
};

export default Home;
