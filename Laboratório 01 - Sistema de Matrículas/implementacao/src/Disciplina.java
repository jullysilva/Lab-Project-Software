import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    static final int LIMITE_ALUNOS = 60;
    static final int MIN_ALUNOS = 3;

    private Integer id;
    private String nome;
    private Boolean EhOptativa;
    private Boolean EhAtiva;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private Integer cargaHoraria;
    private Double valorHoraAula;

    public Disciplina(Integer id, Boolean ehOptativa, Boolean ehAtiva, ArrayList<Aluno> alunos, ArrayList<Professor> professores,
            Double valorHoraAula, Integer cargaHoraria, String nome) {
        this.id = id;
        EhOptativa = ehOptativa;
        EhAtiva = ehAtiva;
        this.alunos = alunos;
        this.professores = professores;
        this.cargaHoraria = cargaHoraria;
        this.valorHoraAula = valorHoraAula;
        this.nome = nome;
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

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public Double getValorDisciplina() {
        return this.valorHoraAula * this.cargaHoraria;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void ativarDisciplina() {
        if (alunos.size() >= 3) {
            setEhAtiva(true);
        } else {
            setEhAtiva(false);
        }
    }
}
