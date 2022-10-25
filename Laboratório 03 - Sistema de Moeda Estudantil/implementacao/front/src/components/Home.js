import React, { useState } from "react";
import { Card, Container, Row, Button, Table, Form } from "react-bootstrap";
import { criarInstituicao } from "../services/Instituicao";
import { criarVantagem, buscarVantagens } from "../services/Vantagens";
import Aluno from "./Aluno";
import Professor from "./Professor";

const Home = () => {
  const [aluno, setAluno] = useState(false);
  const [professor, setProfessor] = useState(false);
  const [cadastrarVantagem, setCadastrarVantagem] = useState(false);
  const [vantagens, setVantagens] = useState();

  const [custo, setCusto] = useState("");
  const [descricao, setDescricao] = useState("");

  const onHandleGenerate = async () => {
    const res = await criarInstituicao();
  };

  const handleRegisterVantagem = async (e) => {
    e.preventDefault();
    const data = {
      custo: custo,
      descricao: descricao,
    };
    const resp = await criarVantagem(data);
    setCadastrarVantagem(false);
    onLoadVantagens();
    setCusto("");
    setDescricao("");
  };

  const onLoadVantagens = async () => {
    const resp = await buscarVantagens();
    setVantagens(resp);
  };

  return (
    <>
      <Container fluid>
        <Row style={{ justifyContent: "space-evenly" }}>
          <Card style={{ width: "18rem" }}>
            <Card.Body>
              <Card.Title>Portal Aluno</Card.Title>
              <Button variant="primary" onClick={() => setAluno(true)}>
                Acessar
              </Button>
            </Card.Body>
          </Card>

          <Card style={{ width: "18rem" }}>
            <Card.Body>
              <Card.Title>Portal Professor</Card.Title>
              <Button variant="primary" onClick={() => setProfessor(true)}>
                Acessar
              </Button>
            </Card.Body>
          </Card>

          <Card style={{ width: "18rem" }}>
            <Card.Body>
              <Card.Title>Empresa</Card.Title>
              <Button
                variant="primary"
                onClick={() => setCadastrarVantagem(true)}
              >
                Cadastrar Vantagem
              </Button>
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
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Quantas moedas?</Form.Label>
              <Form.Control
                type="number"
                placeholder="Custo"
                value={custo}
                onChange={(e) => setCusto(e.target.value)}
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
          <Table striped bordered hover>
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
        {aluno && <Aluno />}
        {professor && <Professor />}
      </Container>
    </>
  );
};

export default Home;
