import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes;

    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

public Cliente buscarPorLogin(String login) {
    for (Cliente c : clientes) {
        if (c.getLogin().equals(login)) {
            return c;
        }
    }
    return null; 
}
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        // salvarClientes(); // se quiser implementar persistência
    }

    public List<Cliente> listarClientes() {
        return clientes;
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
