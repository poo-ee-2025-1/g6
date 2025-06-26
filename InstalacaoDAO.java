import java.util.ArrayList;
import java.util.List;

public class InstalacaoDAO {
    private List<Instalacao> instalacoes;

    public InstalacaoDAO() {
        instalacoes = new ArrayList<>();
    }

    public void adicionarInstalacao(Instalacao i) {
        instalacoes.add(i);
    }

    public List<Instalacao> listarInstalacoes() {
        return instalacoes;
    }

    public List<Instalacao> buscarPorCliente(Cliente cliente) {
        List<Instalacao> resultado = new ArrayList<>();
        for (Instalacao i : instalacoes) {
            if (i.getCliente().getCpf().equals(cliente.getCpf())) {
                resultado.add(i);
            }
        }
        return resultado;
    }
}
