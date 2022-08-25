import java.util.List;

public class Administrador extends Usuario {

    private String cargo;
    private Double salario;

    public void adicionarCurso(Curso curso) {
    }

    public void removerCurso(Curso curso) {
    }

    public Administrador(Integer id, String nome, String cpf, String email, String senha, Boolean status) {
        super(id, nome, cpf, email, senha, status);
    }
}
