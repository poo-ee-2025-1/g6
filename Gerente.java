import java.util.List;
import java.time.LocalDate;


public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf, String email, String telefone,
                   int idFuncionario, String cargo, double salario,
                   String login, String senha) {
        super(nome, cpf, email, telefone, idFuncionario, cargo, salario, login, senha);
    }

    // ... métodos de gerenciar funcionário ...

    /**
     * MÉTODO ATUALIZADO: Agora, além de aprovar, este método CRIA a instalação.
     * @param orcamento O orçamento a ser aprovado.
     * @param instalacaoDAO O DAO onde a nova instalação será salva.
     */
    public void aprovarOrcamento(Orcamento orcamento, InstalacaoDAO instalacaoDAO) {
        if (orcamento == null || "Aprovado".equals(orcamento.getStatus())) {
            return; // Não faz nada se o orçamento não existe ou já foi aprovado
        }
        
        orcamento.setStatus("Aprovado");

        // Cria uma nova instalação baseada nos dados do orçamento aprovado
        Instalacao novaInstalacao = new Instalacao();
        novaInstalacao.setCpfCliente(orcamento.getCpfCliente());
        novaInstalacao.setIdOrcamento(orcamento.getId());
        novaInstalacao.setCpfFuncionario(
        orcamento.getFuncionarioResponsavel() != null ? orcamento.getFuncionarioResponsavel().getCpf() : null
        );
        novaInstalacao.setEndereco(orcamento.getLocalInstalacao());
        novaInstalacao.setDataInicio(LocalDate.now());
        novaInstalacao.setStatus(StatusInstalacao.INSTALACAO_EM_ANDAMENTO);
        // Salva a nova instalação na lista central do DAO
        instalacaoDAO.inserir(novaInstalacao);
    }

    public void recusarOrcamento(Orcamento orcamento) {
        orcamento.setStatus("Recusado");
    }

    @Override
    public String toString() {
        return super.toString() + "\n[Gerente]";
    }
}