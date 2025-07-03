import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;
    private OrcamentoDAO orcamentoDAO;
    private InstalacaoDAO instalacaoDAO;
    private ManutencaoDAO manutencaoDAO;
    public ClienteController() {
        // Garante que estamos usando as listas centrais de dados para TODOS os DAOs
        clienteDAO = ClienteDAO.getInstance(); 
        orcamentoDAO = OrcamentoDAO.getInstance();
        instalacaoDAO = InstalacaoDAO.getInstance();
        manutencaoDAO = ManutencaoDAO.getInstance(); // ATUALIZADO
    }
    public void solicitarManutencao(Cliente cliente, String descricao) {
        Manutencao m = new Manutencao(cliente, descricao);
        // Este método agora adicionará à lista central
        manutencaoDAO.adicionarManutencao(m);
    }
    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.adicionarCliente(cliente);
    }
    public void solicitarOrcamento(Cliente cliente, Funcionario funcionarioResponsavel,
                     double valorEstimado, double energiaGerada, String localInstalacao) {
        Orcamento novo = new Orcamento(cliente, funcionarioResponsavel, valorEstimado, energiaGerada,localInstalacao);
        orcamentoDAO.adicionarOrcamento(novo);
    }
    public Orcamento consultarOrcamentoAprovado(Cliente cliente) {
        for (Orcamento o : orcamentoDAO.listarOrcamentos()) {
            if (o.getCliente().getCpf().equals(cliente.getCpf()) && o.isAprovado()) {
                return o;
            }
        }
        return null;
    }
    public Instalacao consultarProgressoInstalacao(Cliente cliente) {
        for (Instalacao i : instalacaoDAO.listarInstalacoes()) {
            if (i.getCliente().getCpf().equals(cliente.getCpf())) {
                return i;
            }
        }
        return null;
    }
    public List<Instalacao> historicoInstalacoes(Cliente cliente) {
        return instalacaoDAO.buscarPorCliente(cliente);
    }
    public List<Manutencao> historicoManutencoes(Cliente cliente) {
        return manutencaoDAO.buscarPorCliente(cliente);
    }
}