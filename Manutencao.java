import java.time.LocalDate;

public class Manutencao {
    private int id;
    private Funcionario responsavel;
    private String cpfCliente;
    private Cliente cliente;
    private String descricao;
    private LocalDate dataSolicitacao;
    private String status;

    public Manutencao() {}

    public Manutencao(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.dataSolicitacao = LocalDate.now();
        this.status = "Pendente";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCpfCliente() {
        return cpfCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    public Funcionario getResponsavel() {
    return responsavel;
    }
    public void setResponsavel(Funcionario responsavel) {
    this.responsavel = responsavel;
    }
    public void setResolvido(boolean resolvido) {
    if (resolvido) {
        this.status = "Concluído";
    } else {
        this.status = "Pendente";
    }
    }
    public boolean isResolvido() {
    return "Concluído".equalsIgnoreCase(this.status);
    }

}
