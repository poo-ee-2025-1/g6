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
        this.dataConclusao = null; // A conclusão só é definida quando o status muda para CONCLUIDA
        this.status = StatusInstalacao.AGUARDANDO_APROVACAO; // Status inicial
    }

    // Getters
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

    public StatusInstalacao getStatus() {
        return status;
    }

    // Setters
    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setStatus(StatusInstalacao status) {
        this.status = status;
        // Se o status for alterado para CONCLUIDA, define a data de conclusão automaticamente
        if (status == StatusInstalacao.INSTALACAO_CONCLUIDA) {
            this.dataConclusao = LocalDate.now();
        }
    }

    /**
     * MÉTODO ADICIONADO: Permite que o gerente altere ou defina
     * o funcionário responsável pela instalação.
     */
    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Instalação para cliente: " + cliente.getNome() +
               "\nEndereço: " + endereco +
               "\nResponsável: " + (responsavel != null ? responsavel.getNome() : "N/A") +
               "\nStatus: " + status +
               "\nInício: " + dataInicio +
               (dataConclusao != null ? "\nConclusão: " + dataConclusao : "");
    }
}