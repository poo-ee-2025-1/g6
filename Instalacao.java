import java.time.LocalDate;

public class Instalacao {
    private int id;
    private String cpfCliente;
    private int idOrcamento;
    private String cpfFuncionario;
    private String endereco;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private StatusInstalacao status;;

    public Instalacao() {}
    public Instalacao(Cliente cliente, Orcamento orcamento, Funcionario funcionarioResponsavel, String endereco) {
        this.cliente = cliente;
        this.orcamento = orcamento;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.endereco = endereco;
        this.dataInicio = LocalDate.now();
        this.status = StatusInstalacao.AGUARDANDO_APROVACAO;
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

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
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
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }
    private Cliente cliente;
    private Orcamento orcamento;
    private Funcionario funcionarioResponsavel;
    
}
