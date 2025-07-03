import java.time.LocalDate;

public class Orcamento {
    private int id;
    private String cpfCliente;
    private String cpfFuncionario;
    private double valorEstimado;
    private double energiaGerada;
    private String localInstalacao;
    private LocalDate dataCriacao;
    private String status; // Agora é String, p.ex: "Pendente", "Aprovado", "Recusado"

    private Cliente cliente; // opcional, para facilitar uso no código
    private Funcionario funcionarioResponsavel; // opcional

    public Orcamento() {}
    public Orcamento(Cliente cliente, Funcionario funcionarioResponsavel,
                     double valorEstimado, double energiaGerada, String localInstalacao) {
        this.cliente = cliente;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.valorEstimado = valorEstimado;
        this.energiaGerada = energiaGerada;
        this.localInstalacao = localInstalacao;
        this.dataCriacao = LocalDate.now();
        this.status = "Pendente";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCpfCliente() {
        return cpfCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    public String getCpfFuncionario() {
        return cpfFuncionario;
    }
    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
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
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }
    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }
    public boolean isAprovado() {
        return status != null && status.equalsIgnoreCase("Aprovado");
    }
}
