import java.util.ArrayList;
import java.util.List;

public class OrcamentoDAO {
    private List<Orcamento> orcamentos;

    public OrcamentoDAO() {
        orcamentos = new ArrayList<>();
    }

    public void adicionarOrcamento(Orcamento orcamento) {
        orcamentos.add(orcamento);
        // salvarOrcamentos(); // se quiser implementar persistência
    }

    public List<Orcamento> listarOrcamentos() {
        return orcamentos;
    }
}
