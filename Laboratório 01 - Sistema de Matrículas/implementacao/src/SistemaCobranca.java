
public class SistemaCobranca {

    public static void cobrarAluno(Aluno aluno) {
        Double valor = 0.0;
        StringBuilder sr = new StringBuilder();
        for (Disciplina disciplina : aluno.getDisciplinasMatriculadas()) {
            valor += disciplina.getValorDisciplina();
            sr.append("\n Disciplina: ").append(disciplina.getNome()).append("\n Valor: ")
                    .append(disciplina.getValorDisciplina());
        }
        sr.append("\n===========================================").append("\n Valor final :").append(valor);
        System.out.println(sr.toString());
    }
}
