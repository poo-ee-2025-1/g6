import java.util.ArrayList;
import java.util.List;

public class InstalacaoDAO {
    // 1. A única instância da classe, inicializada como nula.
    private static InstalacaoDAO instance = null;
    
    private List<Instalacao> instalacoes;

    // 2. O construtor é privado para impedir que outras classes usem "new InstalacaoDAO()".
    private InstalacaoDAO() {
        instalacoes = new ArrayList<>();
    }
    
    // 3. O método público que todos usarão para obter a instância única.
    public static InstalacaoDAO getInstance() {
        // Se a instância ainda não foi criada, cria uma nova.
        if (instance == null) {
            instance = new InstalacaoDAO();
        }
        // Retorna a instância existente.
        return instance;
    }

    // Métodos de negócio
    public void adicionarInstalacao(Instalacao i) {
        instalacoes.add(i);
    }

    public List<Instalacao> listarInstalacoes() {
        return instalacoes;
    }

    public List<Instalacao> buscarPorCliente(Cliente cliente) {
        List<Instalacao> resultado = new ArrayList<>();
        if (cliente == null) return resultado;
        
        for (Instalacao i : instalacoes) {
            if (i.getCliente() != null && i.getCliente().getCpf().equals(cliente.getCpf())) {
                resultado.add(i);
            }
        }
        return resultado;
    }

   
    public List<Instalacao> buscarPorResponsavel(Funcionario responsavel) {
        List<Instalacao> resultado = new ArrayList<>();
        if (responsavel == null) {
            return resultado;
        }
        for (Instalacao i : instalacoes) {
            // Verifica se a instalação tem um responsável e se o CPF dele bate com o do funcionário logado
            if (i.getResponsavel() != null && i.getResponsavel().getCpf().equals(responsavel.getCpf())) {
                resultado.add(i);
            }
        }
        return resultado;
    }
}