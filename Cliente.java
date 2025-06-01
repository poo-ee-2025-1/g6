import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String endereco;
    private String login;
    private String senha;
    private double energiaDesejada; // em kWh/mês
    private List<Orcamento> orcamentos;
    private List<Instalacao> instalacoes;

    public Cliente(String nome, String cpf, String email, String telefone, 
                   String endereco, String login, String senha, double energiaDesejada) {
        super(nome, cpf, email, telefone);
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.energiaDesejada = energiaDesejada;
        this.orcamentos = new ArrayList<>();
        this.instalacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public double getEnergiaDesejada() {
        return energiaDesejada;
    }

    public void setEnergiaDesejada(double energiaDesejada) {
        this.energiaDesejada = energiaDesejada;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void adicionarOrcamento(Orcamento orcamento) {
        this.orcamentos.add(orcamento);
    }

    public List<Instalacao> getInstalacoes() {
        return instalacoes;
    }

    public void adicionarInstalacao(Instalacao instalacao) {
        this.instalacoes.add(instalacao);
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nEndereço: " + endereco +
               "\nLogin: " + login +
               "\nEnergia desejada: " + energiaDesejada + " kWh/mês";
    }
}
