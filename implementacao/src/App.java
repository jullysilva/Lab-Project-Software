import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(System.in);
        int TLogin = 1;
    	
    	System.out.println("PROJETO MATRÍCULA");
        
        do {
        	System.out.print("\t 1 - ALUNO \n\t 2 - PROFESSOR \n\t 3 - ADMINISTRADOR \n\t 0 - ABANDONAR SISTEMA");
        	System.out.print("\n\nEscolha: ");
        	TLogin = scanner.nextInt();
        	
        	switch (TLogin) {
        	case 1:
        		loginAluno();
        		break;
        	case 2: 
        		loginProfessor();
        		break;
        	case 3: 
        		loginAdministrador();
        		break;
        	default:
        		break;
        	}
        } while(TLogin != 0);
        
        scanner.close();
    }

    public static void loginAluno() {
    	System.out.println("ACESSO ALUNO");
    }
    
    public static void loginProfessor() {
    	System.out.println("ACESSO PROFESSOR");
    }
    
    public static void loginAdministrador() {
    	System.out.println("ACESSO ADMINISTRADOR");
    }
}
