import java.io.Serializable;
import java.time.LocalDate;

public class Manutencao implements Serializable {
    private Cliente cliente;
    private String descricao;
    private LocalDate dataSolicitacao;
    private boolean resolvido;
    private Funcionario responsavel; // <-- CAMPO ADICIONADO

    public Manutencao(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.dataSolicitacao = LocalDate.now();
        this.resolvido = false;
        this.responsavel = null; // Um responsável pode ser atribuído depois
    }

    // Getters
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
    
    // --- MÉTODO GET ADICIONADO ---
    public Funcionario getResponsavel() {
        return responsavel;
    }

    // Setters
    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }
    
    // --- MÉTODO SET ADICIONADO ---
    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }
}