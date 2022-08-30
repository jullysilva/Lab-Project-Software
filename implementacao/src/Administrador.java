import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

    private String cargo;
    private Double salario;

    public void adicionarCurso(Curso curso) {

    }

    public void removerCurso(Curso curso) {
    }

    public void adicionarDisciplina(Disciplina disciplina) {

    }

    public void removerDisciplina(Disciplina disciplina) {

    }

    public void adicionarUsuario(Usuario usuario) {
    }

    public void removerUsuario() {

    }

    public Administrador(Integer id, String nome, String cpf, String email, String senha, Boolean status) {
        super(id, nome, cpf, email, senha, status);
        setCargo(cargo);
        setSalario(salario);

    }
    public Administrador(){
        super();
        setCargo("");
        setSalario(0.0);
    }
    public Administrador(Usuario usuario){
        super(usuario.getId(),usuario.getNome(),usuario.getCpf(),usuario.getEmail(),usuario.getSenha(),usuario.getStatus());
        setCargo("");
        setSalario(0.0);
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getSalario() {
        return this.salario;
    }

}
