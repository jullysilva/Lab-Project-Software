import java.util.Map;

public class Curso {

  private Integer id;
  private String nome;
  private Integer credito;
  private Disciplina disciplina;

  public Curso(Integer id, String nome, Integer credito, Disciplina disciplina) {
    this.id = id;
    this.nome = nome;
    this.credito = credito;
    this.disciplina = disciplina;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getCredito() {
    return credito;
  }

  public void setCredito(Integer credito) {
    this.credito = credito;
  }

  public Disciplina getDisciplina() {
    return disciplina;
  }

  public void setDisciplina(Disciplina disciplina) {
    this.disciplina = disciplina;
  }
}
