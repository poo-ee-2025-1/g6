import java.time.LocalDate;

public class Instalacao {
    private Cliente cliente;
    private Orcamento orcamento;
    private Funcionario responsavel;
    private String endereco;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private StatusInstalacao status;

    public Instalacao(Cliente cliente, Orcamento orcamento, Funcionario responsavel, String endereco) {
        this.cliente = cliente;
        this.orcamento = orcamento;
        this.responsavel = responsavel;
        this.endereco = endereco;
        this.dataInicio = LocalDate.now();
        this.dataConclusao = null;
        this.status = StatusInstalacao.AGUARDANDO_APROVACAO;
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusInstalacao getStatus() {
        return status;
    }

    public void setStatus(StatusInstalacao status) {
        this.status = status;
        if (status == StatusInstalacao.INSTALACAO_CONCLUIDA) {
            this.dataConclusao = LocalDate.now();
        }
    }

    @Override
    public String toString() {
        return "Instalação para cliente: " + cliente.getNome() +
               "\nEndereço: " + endereco +
               "\nResponsável: " + responsavel.getNome() +
               "\nStatus: " + status +
               "\nInício: " + dataInicio +
               (dataConclusao != null ? "\nConclusão: " + dataConclusao : "");
    }
}
