import { useState } from "react";
import { Alert, Button, Col, Form, Row } from "react-bootstrap";
import { criarProfessor } from "../../services/ProfessorService";



const ProfCadastro = () => {
    const [validated, setValidated] = useState(false);
    const [message, setMessage] = useState(false);
    const [cod, setCod] = useState('');
    const [professor, setProfessor] = useState({
        nome: null,
        email: null,
        senha: null,
        idInst: 0,
        cpf: null,
        departamento: null 
    });

    const onSubmitCadastroProf = async (e) => {
        e.preventDefault();
        const form = e.currentTarget;
        if(form.checkValidity() === true){
            const res = await criarProfessor(professor);
            localStorage.setItem("codigo-prof", res.id);
            setCod(res.id);
            setMessage(true);
        }else{
            e.stopPropagation();
        }
        setValidated(true);
    };

    return(
        <>
        {!message && <Form noValidate validated={validated} onSubmit={onSubmitCadastroProf}>
            <Row className="mb-3 mt-3">
              <Form.Group as={Col}>
                <Form.Label>Nome</Form.Label>
                <Form.Control
                  type="text"
                  value={professor.nome}
                  placeholder="Insira seu nome"
                  onChange={(e) => {
                    professor.nome = e.target.value;
                    setProfessor({...professor});
                    }} required
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>Email</Form.Label>
                <Form.Control
                  type="email"
                  value={professor.email}
                  placeholder="Insira seu email"
                  onChange={(e) => {
                    professor.email = e.target.value;
                    setProfessor({...professor});
                    }}
                  required
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>Senha</Form.Label>
                <Form.Control
                  type="password"
                  value={professor.senha}
                  placeholder="Insira a senha"
                  onChange={(e) => {
                    professor.senha = e.target.value;
                    setProfessor({...professor});
                    }}
                  required
                />
              </Form.Group>
            </Row>
            <Row className="mb-3">
              <Form.Group as={Col}>
                <Form.Label>Código da Instituicao</Form.Label>
                <Form.Control
                  type="number"
                  value={professor.idInst}
                  placeholder="Código da instituição"
                  onChange={(e) => {
                    professor.idInst = e.target.value;
                    setProfessor({...professor});
                    }}
                  required
                />
              </Form.Group>
              <Form.Group as={Col} controlId="formGridCity">
                <Form.Label>CPF</Form.Label>
                <Form.Control
                  type="text"
                  value={professor.cpf}
                  maxLength={10}
                  placeholder="Insira seu CPF"
                  onChange={(e) => {
                    professor.cpf = e.target.value;
                    setProfessor({...professor});
                    }}
                  required
                />
              </Form.Group>

              <Form.Group as={Col} controlId="formGridZip">
                <Form.Label>Departamento</Form.Label>
                <Form.Control
                  type="text"
                  value={professor.departamento}
                  placeholder="Insira o Departamento"
                  onChange={(e) => {
                    professor.departamento = e.target.value;
                    setProfessor({...professor});
                    }}
                  required
                />
              </Form.Group>
            </Row>

            <Button
              variant="primary"
              type="submit"
            >
              Cadastrar
            </Button>
        </Form>}
        {message && <Alert variant="success">Cadastro realizado com sucesso. Acesse sua conta de PROFESSOR! Seu código de acesso é {cod}.</Alert>}
        </>
    );
};

export default ProfCadastro;