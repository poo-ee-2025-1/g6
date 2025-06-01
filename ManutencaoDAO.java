import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {
    private List<Manutencao> manutencoes;

    public ManutencaoDAO() {
        manutencoes = new ArrayList<>();
    }

    public void adicionarManutencao(Manutencao m) {
        manutencoes.add(m);
    }

    public List<Manutencao> listarManutencoes() {
        return manutencoes;
    }

    public List<Manutencao> buscarPorCliente(Cliente cliente) {
        List<Manutencao> resultado = new ArrayList<>();
        for (Manutencao m : manutencoes) {
            if (m.getCliente().getCpf().equals(cliente.getCpf())) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}
