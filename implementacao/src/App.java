import java.util.Scanner;


public class App {
	public static void main(String[] args) throws Exception {
		
		Scanner teclado = new Scanner(System.in);
		FileManager.carregarDados(teclado);
		int TLogin = 1;
		String email, senha;

		System.out.println("PROJETO MATRÍCULA");

		do {

			System.out.print("\n\t 1 - ALUNO \n\t 2 - PROFESSOR \n\t 3 - ADMINISTRADOR \n\t 0 - ABANDONAR SISTEMA");
			System.out.print("\n\nEscolha: ");
			TLogin = teclado.nextInt();
			System.out.print("\n\t Digite o email: ");
			email = teclado.nextLine();
			System.out.print("\n\t Digite a senha: ");
			senha = teclado.nextLine();
			switch (TLogin) {
				case 1:
					Aluno aluno = loginAluno(email, senha);
					if (aluno.equals(new Aluno())) {
						TLogin = -1;
					} else {
						System.out.print("\t 1 - MATRICULAR \n\t 2 - EXCLUIR MATRICULA ");
					}
					break;
				case 2:
					// loginProfessor();
					System.out.println("\n\t 1- VISUALIZAR ALUNOS");
					break;
				case 3:
					Administrador adm = loginAdministrador(email, senha);
					pausa(teclado);
					System.out.print(
							"\t 1 - CADASTRO \n\t 2 - EXCLUSÃO \n\t 3 - ADMINISTRADOR \n\t 0 - ABANDONAR SISTEMA");
					break;
				default:
					System.out.println("Opção inválida");
					TLogin = 0;
					break;
			}
		} while (TLogin != 0);

		teclado.close();
	}

	private static void cadastroMenu(Scanner teclado) {
		System.out.println("\n\tDigite o tipo de usuario");
		System.out.println(" \n 1 - ALUNO \n 2 - PROFESSOR \n 3 - ADMINISTRADOR");
		int tipo = teclado.nextInt();
		switch (tipo) {
			case 1:
				Aluno aluno = new Aluno(coletarDados(teclado));
				break;
			case 2:
				Professor professor = new Professor(coletarDados(teclado));
				break;
			case 3:
				Administrador adm = new Administrador(coletarDados(teclado));
				System.out.println("Digite o cargo: ");
				String cargo = teclado.nextLine();
				adm.setCargo(cargo);
				System.out.println("Digite o salario: ");
				Double salario = teclado.nextDouble();
				teclado.nextLine();
				adm.setSalario(salario);
				FileManager.listaAdministradores.add(adm);
				break;
		}
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

	private void montarMenu(Scanner teclado) {

		System.out.print("\t 1 - CADASTRO USUARIO \n\t 2 - CADASTRO CURSO \n\t 3- CADASTRO DISCIPLINA ");
		int opcao = teclado.nextInt();
		switch (opcao) {
			case 1:

				break;
			case 2:
				break;
			default:
				break;
		}
	}

	public static Aluno loginAluno(String email, String senha) {
		System.out.println("ACESSO ALUNO");
		Aluno usuario = FileManager.listaAlunos.stream().filter(a -> a.getEmail() == email && a.getSenha() == senha)
				.findFirst().orElse(new Aluno());
		return usuario;

	}

	public static Professor loginProfessor(String email, String senha) {
		System.out.println("ACESSO PROFESSOR");
		Professor usuario = FileManager.listaProfessores.stream()
				.filter(a -> a.getEmail() == email && a.getSenha() == senha)
				.findFirst().orElse(new Professor());
		return usuario;
	}

	public static Administrador loginAdministrador(String email, String senha) {
		System.out.println("ACESSO ADMINISTRADOR");
		Administrador usuario = FileManager.listaAdministradores.stream()
				.filter(a -> a.getEmail() == email && a.getSenha() == senha)
				.findFirst().orElse(new Administrador());
		return usuario;

	}

	static void pausa(Scanner teclado) {
		System.out.println("Enter para continuar.");
		teclado.nextLine();
	}
}
