import java.util.List;

public class Aluno extends Usuario {

    private static final int MAX_DISCIPLINAS_OBRIGATORIAS = 4;
    private static final int MAX_DISCIPLINAS_OPTATIVAS = 2;

    private String matricula;
    private List<Disciplina> disciplinasMatriculadas;

    public Aluno(Integer id, String nome, String cpf, String email, String senha, Boolean status, String matricula, List<Disciplina> disciplinasMatriculadas) {
        super(id, nome, cpf, email, senha, status);
        this.matricula = matricula;
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
    }

    public void removerDisciplina(Disciplina disciplina) {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setDisciplinasMatriculadas(List<Disciplina> disciplinasMatriculadas) {
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }
}
