import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManutencaoDAO {
    // 1. Adiciona a instância estática e privada
    private static ManutencaoDAO instance = null;
    private List<Manutencao> manutencoes;

    // 2. O construtor se torna privado
    private ManutencaoDAO() {
        manutencoes = new ArrayList<>();
    }

    // 3. Cria o método público getInstance()
    public static ManutencaoDAO getInstance() {
        if (instance == null) {
            instance = new ManutencaoDAO();
        }
        return instance;
    }

    public void adicionarManutencao(Manutencao m) {
        manutencoes.add(m);
    }

    public List<Manutencao> listarManutencoes() {
        return new ArrayList<>(manutencoes); // Retorna uma cópia para segurança
    }

    public List<Manutencao> buscarPorCliente(Cliente cliente) {
        if (cliente == null) {
            return new ArrayList<>(); // Retorna lista vazia se o cliente for nulo
        }
        return manutencoes.stream()
                .filter(m -> m.getCliente() != null && m.getCliente().getCpf().equals(cliente.getCpf()))
                .collect(Collectors.toList());
    }
    
    // Adicionado para consistência
    public List<Manutencao> buscarPorResponsavel(Funcionario funcionario) {
        if (funcionario == null) {
            return new ArrayList<>(); // Retorna lista vazia se o funcionário for nulo
        }
        return manutencoes.stream()
                .filter(m -> m.getResponsavel() != null && m.getResponsavel().getCpf().equals(funcionario.getCpf()))
                .collect(Collectors.toList());
    }
}