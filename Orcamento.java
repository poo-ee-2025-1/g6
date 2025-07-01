import java.time.LocalDate;

public class Orcamento {
    private Cliente cliente;
    private Funcionario funcionarioResponsavel;
    private double valorEstimado;
    private double energiaGerada;
    private String localInstalacao;
    private LocalDate dataCriacao;
    private boolean aprovado; 
    private String status; 

    public Orcamento(Cliente cliente, Funcionario funcionarioResponsavel,
                     double valorEstimado, double energiaGerada, String localInstalacao) {
        this.cliente = cliente;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.valorEstimado = valorEstimado;
        this.energiaGerada = energiaGerada;
        this.localInstalacao = localInstalacao;
        this.dataCriacao = LocalDate.now();
        this.aprovado = false;
        this.status = "Pendente"; 
    }

    // Getters e Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        
        this.aprovado = status.equals("Aprovado");
    }
    
    
    public Cliente getCliente() { return cliente; }
    public Funcionario getFuncionarioResponsavel() { return funcionarioResponsavel; }
    public double getValorEstimado() { return valorEstimado; }
    public void setValorEstimado(double valorEstimado) { this.valorEstimado = valorEstimado; }
    public double getEnergiaGerada() { return energiaGerada; }
    public void setEnergiaGerada(double energiaGerada) { this.energiaGerada = energiaGerada; }
    public String getLocalInstalacao() { return localInstalacao; }
    public void setLocalInstalacao(String localInstalacao) { this.localInstalacao = localInstalacao; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public boolean isAprovado() { return aprovado; }
    
    
    public void setAprovado(boolean aprovado) {
        if (aprovado) {
            setStatus("Aprovado");
        } else {
            if (!"Recusado".equals(this.status)) {
                setStatus("Pendente");
            }
        }
    }
    
    
}