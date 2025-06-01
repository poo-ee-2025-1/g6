import java.time.LocalDate;

public class Orcamento {
    private Cliente cliente;
    private Funcionario funcionarioResponsavel;
    private double valorEstimado;
    private double energiaGerada; // kWh/mês
    private String localInstalacao;
    private LocalDate dataCriacao;
    private boolean aprovado;

    public Orcamento(Cliente cliente, Funcionario funcionarioResponsavel,
                     double valorEstimado, double energiaGerada, String localInstalacao) {
        this.cliente = cliente;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.valorEstimado = valorEstimado;
        this.energiaGerada = energiaGerada;
        this.localInstalacao = localInstalacao;
        this.dataCriacao = LocalDate.now();
        this.aprovado = false; // padrão: não aprovado
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    public double getEnergiaGerada() {
        return energiaGerada;
    }

    public void setEnergiaGerada(double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }

    public String getLocalInstalacao() {
        return localInstalacao;
    }

    public void setLocalInstalacao(String localInstalacao) {
        this.localInstalacao = localInstalacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public String toString() {
        return "Orçamento de " + cliente.getNome() +
               "\nCriado por: " + funcionarioResponsavel.getNome() +
               "\nEnergia: " + energiaGerada + " kWh/mês" +
               "\nValor estimado: R$ " + valorEstimado +
               "\nLocal: " + localInstalacao +
               "\nData: " + dataCriacao +
               "\nStatus: " + (aprovado ? "Aprovado" : "Pendente");
    }
}
