import java.util.List;

public class Professor extends Usuario {

    private String cargo;
    private Double salario;
    private List<Disciplina> disciplinas;


    public Professor(Integer id, String nome, String cpf, String email, String senha, Boolean status, String cargo, Double salario, List<Disciplina> disciplinas) {
        super(id, nome, cpf, email, senha, status);
        this.cargo = cargo;
        this.salario = salario;
        this.disciplinas = disciplinas;
    }

    public void ListarAlunos() {
    }
}
