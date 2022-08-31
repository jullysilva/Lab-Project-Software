import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private static final String arqDadosMatriculas = "Matriculas.bin";
    private static final String arqDadosProfessores = "Professores.bin";
    private static final String arqDadosAlunos = "Alunos.bin";
    private static final String arqDadosAdministradores = "Administradores.bin";
    private static final String arqDadosCursos = "Cursos.bin";
    static ArrayList<Matricula> listaMatriculas;
    static ArrayList<Professor> listaProfessores;
    static ArrayList<Aluno> listaAlunos;
    static ArrayList<Administrador> listaAdministradores;
    static ArrayList<Curso> listaCursos;

    public static void gravarDados() throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosMatriculas));
        if (listaMatriculas.size() > 0) {
            for (Matricula matricula : listaMatriculas) {
                obj.writeObject(matricula);
            }
        }
        obj.close();

        obj = new ObjectOutputStream(new FileOutputStream(arqDadosProfessores));
        if (listaProfessores.size() > 0) {
            for (Professor professor : listaProfessores) {
                obj.writeObject(professor);
            }
        }
        obj.close();

        obj = new ObjectOutputStream(new FileOutputStream(arqDadosAlunos));
        if (listaAlunos.size() > 0) {
            for (Aluno aluno : listaAlunos) {
                obj.writeObject(aluno);
            }
        }
        obj.close();

        obj = new ObjectOutputStream(new FileOutputStream(arqDadosAdministradores));
        if (listaAdministradores.size() > 0) {
            for (Administrador administrador : listaAdministradores) {
                obj.writeObject(administrador);
            }
        }
        obj.close();

        obj = new ObjectOutputStream(new FileOutputStream(arqDadosCursos));
        if (listaCursos.size() > 0) {
            for (Curso curso : listaCursos) {
                obj.writeObject(curso);
            }
        }
        obj.close();
    }

    public static void carregarDados(Scanner teclado) {
        FileInputStream dados;
         ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
         ArrayList<Professor> professores = new ArrayList<Professor>();
         ArrayList<Aluno> alunos =new ArrayList<Aluno>();
         ArrayList<Administrador> administradores = new ArrayList<Administrador>();
         ArrayList<Curso> cursos = new ArrayList<Curso>();

        try {
            dados = new FileInputStream(arqDadosMatriculas);
            ObjectInputStream obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Matricula novo = (Matricula) obj.readObject();
                matriculas.add(novo);
            }
            obj.close();
            dados = new FileInputStream(arqDadosProfessores);
            obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Professor novo = (Professor) obj.readObject();
                professores.add(novo);
            }
            obj.close();
            dados = new FileInputStream(arqDadosAlunos);
            obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Aluno novo = (Aluno) obj.readObject();
                alunos.add(novo);
            }
            obj.close();
            dados = new FileInputStream(arqDadosAdministradores);
            obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Administrador novo = (Administrador) obj.readObject();
                administradores.add(novo);
            }
            obj.close();
            dados = new FileInputStream(arqDadosCursos);
            obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Curso novo = (Curso) obj.readObject();
                cursos.add(novo);
            }
            obj.close();
            listaMatriculas = matriculas;
            listaProfessores = professores;
            listaAlunos = alunos;
            listaAdministradores = administradores;
            listaCursos = cursos;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            listaMatriculas = matriculas;
            listaProfessores = professores;
            listaAlunos = alunos;
            listaAdministradores = administradores;
            listaCursos = cursos;
        } catch (IOException ex) {
            System.out.println("Problema no uso do arquivo.");
            System.out.println("Favor reiniciar o sistema.");
            listaMatriculas = matriculas;
            listaProfessores = professores;
            listaAlunos = alunos;
            listaAdministradores = administradores;
            listaCursos = cursos;
        } catch (ClassNotFoundException cex) {
            listaMatriculas = matriculas;
            listaProfessores = professores;
            listaAlunos = alunos;
            listaAdministradores = administradores;
            listaCursos = cursos;
        }
    }
}
