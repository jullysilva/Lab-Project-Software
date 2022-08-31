import java.util.ArrayList;

public class Usuario {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Boolean status;

    public boolean logar(ArrayList<Usuario> usuarios) {
        if (usuarios.stream().anyMatch(u -> u.getEmail() == this.getEmail() && u.getSenha() == this.getSenha())) {
            return true;
        }
        return false;
    }

    public Usuario(Integer id, String nome, String cpf, String email, String senha, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.status = status;
    }
    public Usuario(){
        setId(-1);
        setNome("");
        setCpf("");
        setEmail("");
        setSenha("");
        setStatus(false);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String ToString() {
        StringBuilder sr = new StringBuilder();
        sr.append("\nNome :").append(this.getNome()).append("\nCpf: ").append(this.getCpf()).append("\nEmail: ")
                .append(this.getEmail());
        return sr.toString();
    }
}