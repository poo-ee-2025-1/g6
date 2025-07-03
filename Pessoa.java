public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    // Construtor vazio
    public Pessoa() {
        // pode deixar vazio ou inicializar algo se quiser
    }

    // Construtor com parâmetros
    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e setters
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + 
               "\nCPF: " + cpf + 
               "\nEmail: " + email + 
               "\nTelefone: " + telefone;
    }
}
