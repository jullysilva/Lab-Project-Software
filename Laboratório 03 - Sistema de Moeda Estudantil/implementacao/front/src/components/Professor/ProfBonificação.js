import { useState } from "react";
import { Badge, Button, Col, Container, Form, Row } from "react-bootstrap";
import { enviarBonificacao } from "../../services/ProfessorService";


const ProfBonificacao = () => {
    const [validated, setValidated] = useState(false);
    const [showForm, setShowForm] = useState(false);
    const [bonificacao, setBonificacao] = useState({
        custo: 0,
        mensagem: null,
        idProfessor: localStorage.getItem('codigo-prof'),
        idAluno: null
    });

    const onSendMoney = async (e) => {
        e.preventDefault();
        const form = e.currentTarget;
        if(form.checkValidity() === true){
            await enviarBonificacao(bonificacao);
        // await buscarMoedas(bonificacao.idProfessor);
        }else{
            e.stopPropagation();
        }
        setValidated(true);
      };
    
    return(
        <Container className="m-3">
          <Row>
            <Col xs={12} md={10}>
              <Button
                className="w-100"
                variant="primary"
                type="submit"
                onClick={() => setShowForm(true)}
              >
                Doar Moedas
              </Button>
            </Col>
            <Col xs={6} md={2}>
              <Button variant="light" className="w-100">
                MOEDAS <Badge bg="danger">qtdMoedas</Badge>
              </Button>
            </Col>
          </Row>
          {showForm && <Container>
            <Form noValidate validated={validated} onSubmit={onSendMoney}>
                <Row>
                    <Form.Group as={Col}>
                        <Form.Label>Para qual aluno (Código do aluno)</Form.Label>
                        <Form.Control
                            type="number"
                            value={bonificacao.idAluno}
                            placeholder="Insira o código do aluno"
                            onChange={(text) => {
                                bonificacao.idAluno = text.target.value;
                                setBonificacao({...bonificacao});
                            }}
                            required
                        />
                    </Form.Group>

                    <Form.Group as={Col}>
                        <Form.Label>Quantidade</Form.Label>
                        <Form.Control
                            type="number"
                            value={bonificacao.custo}
                            placeholder="Insira a quantidade"
                            onChange={(text) => {
                                bonificacao.custo = text.target.value;
                                setBonificacao({...bonificacao});
                            }}
                            required
                        />
                    </Form.Group>
                </Row>
                <Row>
                    <Form.Group as={Col} className="mt-1">
                        <Form.Label>Código Professor</Form.Label>
                        <Form.Control
                            type="number"
                            value={bonificacao.idProfessor}
                            placeholder="Insira seu código"
                            onChange={(text) => {
                                bonificacao.idProfessor = text.target.value;
                                setBonificacao({...bonificacao});
                            }}
                            required
                        />
                    </Form.Group>
                    <Form.Group as={Col} className="mt-1">
                        <Form.Label>Mensagem</Form.Label>
                        <Form.Control
                            type="text"
                            value={bonificacao.mensagem}
                            placeholder="Escreva uma mensagem"
                            onChange={(text) => {
                                bonificacao.mensagem = text.target.value;
                                setBonificacao({...bonificacao});
                            }}
                            required
                        />
                    </Form.Group>
                </Row>

          <Button
            variant="success"
            type="submit"
            className="mt-3"
          >
            Enviar
          </Button>
        </Form>
          </Container>}
        </Container>
    );
};

export default ProfBonificacao;