import java.util.List;

public class Disciplina {

    private static final int LIMITE_ALUNOS = 60;
    private static final int MIN_ALUNOS = 3;

    private Integer id;
    private Boolean EhOptativa;
    private Boolean EhAtiva;
    private List<Aluno> alunos;
    private List<Professor> professores;
    public List<Aluno> ListarAlunos;

    public Disciplina(Integer id, Boolean ehOptativa, Boolean ehAtiva, List<Aluno> alunos, List<Professor> professores, List<Aluno> listarAlunos) {
        this.id = id;
        EhOptativa = ehOptativa;
        EhAtiva = ehAtiva;
        this.alunos = alunos;
        this.professores = professores;
        ListarAlunos = listarAlunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEhOptativa() {
        return EhOptativa;
    }

    public void setEhOptativa(Boolean ehOptativa) {
        EhOptativa = ehOptativa;
    }

    public Boolean getEhAtiva() {
        return EhAtiva;
    }

    public void setEhAtiva(Boolean ehAtiva) {
        EhAtiva = ehAtiva;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aluno> getListarAlunos() {
        return ListarAlunos;
    }

    public void setListarAlunos(List<Aluno> listarAlunos) {
        ListarAlunos = listarAlunos;
    }
}
