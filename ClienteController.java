import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;
    private OrcamentoDAO orcamentoDAO;
    private InstalacaoDAO instalacaoDAO;
    private ManutencaoDAO manutencaoDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
        orcamentoDAO = new OrcamentoDAO();
        instalacaoDAO = new InstalacaoDAO();
        manutencaoDAO = new ManutencaoDAO();
    }

    // Este é o método que estava faltando na sua versão do arquivo
    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.adicionarCliente(cliente);
    }

    // Solicitar novo orçamento
    public void solicitarOrcamento(Cliente cliente, Funcionario funcionarioResponsavel,
                     double valorEstimado, double energiaGerada, String localInstalacao) {
        Orcamento novo = new Orcamento(cliente, funcionarioResponsavel, valorEstimado, energiaGerada,localInstalacao);
        orcamentoDAO.adicionarOrcamento(novo);
    }

    // Ver orçamento aprovado
    public Orcamento consultarOrcamentoAprovado(Cliente cliente) {
        for (Orcamento o : orcamentoDAO.listarOrcamentos()) {
            if (o.getCliente().getCpf().equals(cliente.getCpf()) && o.isAprovado()) {
                return o;
            }
        }
        return null;
    }

    // Ver progresso da instalação
    public Instalacao consultarProgressoInstalacao(Cliente cliente) {
        for (Instalacao i : instalacaoDAO.listarInstalacoes()) {
            if (i.getCliente().getCpf().equals(cliente.getCpf())) {
                return i;
            }
        }
        return null;
    }

    // Solicitar manutenção
    public void solicitarManutencao(Cliente cliente, String descricao) {
        Manutencao m = new Manutencao(cliente, descricao);
        manutencaoDAO.adicionarManutencao(m);
    }

    // Histórico de instalações
    public List<Instalacao> historicoInstalacoes(Cliente cliente) {
        return instalacaoDAO.buscarPorCliente(cliente);
    }

    // Histórico de manutenções
    public List<Manutencao> historicoManutencoes(Cliente cliente) {
        return manutencaoDAO.buscarPorCliente(cliente);
    }
}