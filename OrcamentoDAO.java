import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrcamentoDAO {
    private static OrcamentoDAO instance = null;
    private List<Orcamento> orcamentos;

    private OrcamentoDAO() {
        orcamentos = new ArrayList<>();
    }

    public static OrcamentoDAO getInstance() {
        if (instance == null) {
            instance = new OrcamentoDAO();
        }
        return instance;
    }

    public void adicionarOrcamento(Orcamento orcamento) {
        orcamentos.add(orcamento);
    }

    public List<Orcamento> listarOrcamentos() {
        return orcamentos;
    }

    /**
     * MÉTODO NOVO: Busca na lista central todos os orçamentos
     * que pertencem a um cliente específico.
     * @param cliente O cliente cujos orçamentos queremos encontrar.
     * @return Uma lista com os orçamentos do cliente.
     */
    public List<Orcamento> buscarPorCliente(Cliente cliente) {
        List<Orcamento> resultado = new ArrayList<>();
        for (Orcamento orcamento : orcamentos) {
            // Compara o CPF do cliente do orçamento com o CPF do cliente logado
            if (orcamento.getCliente().getCpf().equals(cliente.getCpf())) {
                resultado.add(orcamento);
            }
        }
        return resultado;
    }
}