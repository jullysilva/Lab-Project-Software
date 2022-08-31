import java.io.Serializable;

public class Matricula implements Serializable  {

    private Integer id;
    private Disciplina disciplina;
    private Aluno aluno;

    public Matricula(Integer id, Disciplina disciplina, Aluno aluno) {
        this.id = id;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
