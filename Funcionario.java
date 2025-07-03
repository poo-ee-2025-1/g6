public class Funcionario extends Pessoa {
    private int idFuncionario;
    private String cargo;
    private double salario;
    private String login;
    private String senha;
    
    public Funcionario() {
    super(); // chama o construtor vazio da classe Pessoa
    }

    public Funcionario(String nome, String cpf, String email, String telefone,
                       int idFuncionario, String cargo, double salario,
                       String login, String senha) {
        super(nome, cpf, email, telefone);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nID Funcional: " + idFuncionario +
               "\nCargo: " + cargo +
               "\nSalário: R$ " + salario +
               "\nLogin: " + login;
    }
}
