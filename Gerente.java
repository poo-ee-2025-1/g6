import java.util.List;

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
        if (orcamento == null || orcamento.isAprovado()) {
            return; // Não faz nada se o orçamento não existe ou já foi aprovado
        }
        
        orcamento.setStatus("Aprovado");

        // Cria uma nova instalação baseada nos dados do orçamento aprovado
        Instalacao novaInstalacao = new Instalacao(
            orcamento.getCliente(),
            orcamento,
            orcamento.getFuncionarioResponsavel(), // Pode ser nulo por enquanto
            orcamento.getLocalInstalacao()
        );
        
        // Salva a nova instalação na lista central do DAO
        instalacaoDAO.adicionarInstalacao(novaInstalacao);
    }

    public void recusarOrcamento(Orcamento orcamento) {
        orcamento.setStatus("Recusado");
    }

    @Override
    public String toString() {
        return super.toString() + "\n[Gerente]";
    }
}