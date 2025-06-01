import java.io.Serializable;
import java.time.LocalDate;

public class Manutencao implements Serializable {
    private Cliente cliente;
    private String descricao;
    private LocalDate dataSolicitacao;
    private boolean resolvido;

    public Manutencao(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.dataSolicitacao = LocalDate.now();
        this.resolvido = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }
}
