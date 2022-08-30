import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable {

  private Integer id;
  private String nome;
  private Integer credito;
  private ArrayList<Disciplina> disciplinas;

 

  public Curso(Integer id, String nome, Integer credito, ArrayList<Disciplina> disciplinas) {
    this.id = id;
    this.nome = nome;
    this.credito = credito;
    this.disciplinas = disciplinas;
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

  public ArrayList<Disciplina> getDisciplina() {
    return disciplinas;
  }

  public void setDisciplina(ArrayList<Disciplina> disciplinas) {
    this.disciplinas = disciplinas;
  }
  
}
