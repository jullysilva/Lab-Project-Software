import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Serializable {

    private String cargo;

    private Double salario;
    private List<Disciplina> disciplinas;

    public Professor(Integer id, String nome, String cpf, String email, String senha, Boolean status, String cargo,
            Double salario, List<Disciplina> disciplinas) {
        super(id, nome, cpf, email, senha, status);
        this.cargo = cargo;
        this.salario = salario;
        this.disciplinas = disciplinas;
    }
    public Professor(Usuario usuario){
        super(usuario.getId(),usuario.getNome(),usuario.getCpf(),usuario.getEmail(),usuario.getSenha(),usuario.getStatus());
        setSalario(0.0);
        setDisciplinas(null);
    }

    public Professor() {
        super();
        setSalario(0.0);
        setDisciplinas(null);
    }

    public void ListarAlunos() {
        StringBuilder sr = new StringBuilder();
        sr.append("\n*--Lista alunos--*");
        for (Disciplina disciplina : disciplinas) {
            sr.append("\n Disciplina: ").append(disciplina.getNome());
            for (Aluno aluno : disciplina.getAlunos()) {
                aluno.ToString();
            }
            sr.append("===================================================================================");
        }
        System.out.println(sr.toString());
    }

    @Override
    public String ToString() {

        StringBuilder sr = new StringBuilder(super.toString());
        sr.append("\nCargo: ").append(this.getCargo()).append("\nSalario: ").append(this.getSalario().toString());
        return sr.toString();
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return this.salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        if (disciplinas == null) {
            this.disciplinas = new ArrayList<Disciplina>();
        } else {
            this.disciplinas = disciplinas;
        }

    }
}
