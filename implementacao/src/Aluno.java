import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Usuario implements Serializable  {

    private static final int MAX_DISCIPLINAS_OBRIGATORIAS = 4;
    private static final int MAX_DISCIPLINAS_OPTATIVAS = 2;

    private String matricula;
    private ArrayList<Disciplina> disciplinasMatriculadas;

    public Aluno(Integer id, String nome, String cpf, String email, String senha, Boolean status, String matricula,
            ArrayList<Disciplina> disciplinasMatriculadas) {
        super(id, nome, cpf, email, senha, status);
        this.matricula = matricula;
        setDisciplinasMatriculadas(disciplinasMatriculadas);
    }
    public Aluno(){
        super();
        setMatricula("");
        setDisciplinasMatriculadas(null);
    }
    public Aluno(Usuario usuario){
        super(usuario.getId(),usuario.getNome(),usuario.getCpf(),usuario.getEmail(),usuario.getSenha(),usuario.getStatus());
        setMatricula("");
        setDisciplinasMatriculadas(null);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>(disciplinasMatriculadas);
        if (disciplina.getEhOptativa() && getDisciplinasOpcionais() < MAX_DISCIPLINAS_OPTATIVAS
                && disciplina.getAlunos().size() < Disciplina.LIMITE_ALUNOS) {
            disciplinas.add(disciplina);
        } else if (!disciplina.getEhOptativa() && getDisciplinasObrigatorias() < MAX_DISCIPLINAS_OBRIGATORIAS
                && disciplina.getAlunos().size() < Disciplina.LIMITE_ALUNOS) {
            disciplinas.add(disciplina);
        } else {
            System.out.println("Erro ao adicionar disciplina");
        }

        setDisciplinasMatriculadas(disciplinas);
    }

    public void removerDisciplina(Disciplina disciplina) {
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>(disciplinasMatriculadas);
        if (disciplinas.remove(disciplina)) {
            System.out.println("Disciplina removida com sucesso");
        } else {
            System.out.println("Disciplina não encontrada");
        }
    }

    private int getDisciplinasOpcionais() {
        int optativas = (int) disciplinasMatriculadas.stream().map(d -> d.getEhOptativa()).count();
        return optativas;
    }

    private int getDisciplinasObrigatorias() {
        int obrigatorias = (int) disciplinasMatriculadas.stream().map(d -> !d.getEhOptativa()).count();
        return obrigatorias;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setDisciplinasMatriculadas(ArrayList<Disciplina> disciplinasMatriculadas) {
        if (disciplinasMatriculadas != null) {
            this.disciplinasMatriculadas = disciplinasMatriculadas;
        } else {
            this.disciplinasMatriculadas = new ArrayList<Disciplina>();
        }
    }

    @Override
    public String ToString() {
        StringBuilder sr = new StringBuilder(super.toString());
        sr.append("\nMatricula: ").append(this.getMatricula());
        return sr.toString();
    }
}
