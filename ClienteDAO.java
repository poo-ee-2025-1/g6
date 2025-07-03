import java.sql.*;

public class ClienteDAO {
    private static ClienteDAO instance;
    public boolean inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, email, telefone, endereco, login, senha, energia_desejada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getLogin());
            stmt.setString(7, cliente.getSenha());
            stmt.setDouble(8, cliente.getEnergiaDesejada());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Cliente buscarPorLogin(String login) {
        String sql = "SELECT * FROM cliente WHERE login = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setEnergiaDesejada(rs.getDouble("energia_desejada"));
                return cliente;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Cliente não encontrado
    }
    private ClienteDAO() {
        // Construtor privado evita criação direta fora da classe
    }
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    public boolean adicionarCliente(Cliente cliente) {
    return inserir(cliente); // se o método inserir já existe
    }
}



    