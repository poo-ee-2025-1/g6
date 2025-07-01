import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // 1. Cria uma única instância estática e privada da própria classe.
    private static ClienteDAO instance = null;
    
    private List<Cliente> clientes;

    // 2. O construtor se torna privado. Nenhuma outra classe pode criar um "new ClienteDAO()" diretamente.
    private ClienteDAO() {
        clientes = new ArrayList<>();
    }

    // 3. Este é o método público que todos usarão para obter a única instância.
    public static ClienteDAO getInstance() {
        // Se a instância ainda não foi criada, cria ela.
        if (instance == null) {
            instance = new ClienteDAO();
        }
        // Retorna a instância única.
        return instance;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
    
    // Adiciona o método buscarPorLogin que estava faltando na versão anterior
    public Cliente buscarPorLogin(String login) {
        for (Cliente c : clientes) {
            if (c.getLogin().equals(login)) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }
}