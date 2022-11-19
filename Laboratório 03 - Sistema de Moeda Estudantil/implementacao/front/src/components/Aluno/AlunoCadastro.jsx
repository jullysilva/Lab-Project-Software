import { useState } from "react";
import { Alert, Button, Col, Form, Row } from "react-bootstrap";
import { criarAluno } from "../../services/AlunoService";



const AlunoCadastro = () => {
    const [validated, setValidated] = useState(false);
    const [cod, setCod] = useState(0);
    const [message, setMessage] = useState(false);
    const [aluno, setAluno] = useState({
        nome: null,
        email: null,
        password: null,
        cpf: null,
        rg: null,
        endereco: null,
        curso: null,
        idInst: null
    });

    const onHandleSubmit = async (e) => {
        e.preventDefault();
        const form = e.currentTarget;

        if (form.checkValidity() === true) {
            const resp = await criarAluno(aluno);
            localStorage.setItem("codigo-aluno", resp.id);
            setCod(resp.id);
            setMessage(true);
        } else{
            e.stopPropagation();
        }
        setValidated(true);
      };

    return (
        <>
            {!message && <Form noValidate validated={validated} onSubmit={onHandleSubmit}>
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
                <Form.Group as={Col}>
                    <Form.Label>Senha</Form.Label>
                    <Form.Control
                    type="password"
                    placeholder="Insira a senha"
                    value={aluno.password}
                    onChange={(text) => {aluno.password = text.target.value;
                        setAluno({...aluno});
                    }}
                    required
                    />
                </Form.Group>
                </Row>
                <Row>
                <Form.Group as={Col}>
                    <Form.Label>CPF</Form.Label>
                    <Form.Control
                    type="text"
                    placeholder="Insira seu CPF"
                    maxLength={10}
                    value={aluno.cpf}
                    onChange={(text) => {aluno.cpf = text.target.value;
                        setAluno({...aluno});
                    }}
                    required
                    />
                </Form.Group>

                <Form.Group as={Col}>
                    <Form.Label>RG</Form.Label>
                    <Form.Control
                    type="text"
                    placeholder="Insira seu RG"
                    maxLength={8}
                    value={aluno.rg}
                    onChange={(text) => {aluno.rg = text.target.value;
                        setAluno({...aluno});
                    }}
                    required
                    />
                </Form.Group>
                <Form.Group as={Col}>
                    <Form.Label>Endereco</Form.Label>
                    <Form.Control
                    type="text"
                    value={aluno.endereco}
                    placeholder="Insira seu endereço"
                    onChange={(text) => {aluno.endereco = text.target.value;
                        setAluno({...aluno});
                    }}
                    required
                    />
                </Form.Group>
                </Row>
                <Row>
                <Form.Group as={Col}>
                    <Form.Label>Curso</Form.Label>
                    <Form.Control
                    type="text"
                    value={aluno.curso}
                    placeholder="Insira seu curso"
                    onChange={(text) => {aluno.curso = text.target.value;
                        setAluno({...aluno});
                    }}
                    required
                    />
                </Form.Group>

                <Form.Group as={Col}>
                    <Form.Label>Id da Instituicao</Form.Label>
                    <Form.Control
                    type="number"
                    value={aluno.idInst}
                    placeholder="Insira o código da instituição"
                    onChange={(text) => {aluno.idInst = text.target.value;
                        setAluno({...aluno});
                    }}
                    required
                    />
                </Form.Group>
                </Row>

                <Button
                className="mt-2"
                variant="primary"
                type="submit"
                >
                Cadastrar
                </Button>
            </Form>}
            {message && <Alert variant="success">Cadastro realizado com sucesso. Acesse sua conta de ALUNO! Seu código de acesso é {cod}.</Alert>}
        </>
    );
};

export default AlunoCadastro;