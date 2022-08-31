import java.io.Serializable;
import java.util.Scanner;

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
    

    public void adicionarUsuario(Usuario usuario, Scanner teclado) {
        System.out.println("\n\tDigite o tipo de usuario");
		System.out.println(" \n 1 - ALUNO \n 2 - PROFESSOR \n 3 - ADMINISTRADOR");
		int tipo = teclado.nextInt();
        teclado.nextLine();
		switch (tipo) {
			case 1:
				Aluno aluno = new Aluno(usuario);
                System.out.println("Digite a matricula: ");
				String matricula = teclado.nextLine();
				aluno.setMatricula(matricula);
                aluno.setDisciplinasMatriculadas(null);
				FileManager.listaAlunos.add(aluno);
				break;
			case 2:
				Professor professor = new Professor(usuario);
                System.out.println("Digite o salario: ");
				Double salarioprofessor = teclado.nextDouble();
				professor.setSalario(salarioprofessor);
                //implementar buscar disciplinas para serem adicionadas
                professor.setDisciplinas(null);
				FileManager.listaProfessores.add(professor);
				break;
			case 3:
				Administrador adm = new Administrador(usuario);
				System.out.println("Digite o cargo: ");
				String cargo = teclado.nextLine();
				adm.setCargo(cargo);
				System.out.println("Digite o salario: ");
				Double salarioAdm = teclado.nextDouble();
				teclado.nextLine();
				adm.setSalario(salarioAdm);
				FileManager.listaAdministradores.add(adm);
				break;
		}
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
    private static Usuario coletarDados(Scanner teclado) {
		System.out.println("Digite nome: ");
		String nome = teclado.nextLine();
		teclado.nextLine();

		System.out.print("Digite o cpf: ");
		String cpf = teclado.nextLine();

		System.out.print("Digite o email: ");
		String email = teclado.nextLine();

		System.out.print("Digite a senha: ");
		String senha = teclado.nextLine();

		return new Usuario(1, nome, cpf, email, senha, false);
	}

}
