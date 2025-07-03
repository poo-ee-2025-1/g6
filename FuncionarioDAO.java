import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioDAO {
    private static FuncionarioDAO instance;
    public boolean inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (cpf, nome, email, telefone, id_funcionario, cargo, salario, login, senha) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setInt(5, funcionario.getIdFuncionario());
            stmt.setString(6, funcionario.getCargo());
            stmt.setDouble(7, funcionario.getSalario());
            stmt.setString(8, funcionario.getLogin());
            stmt.setString(9, funcionario.getSenha());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static FuncionarioDAO getInstance() {
    if (instance == null) {
        instance = new FuncionarioDAO();
    }
    return instance;
    }
    public FuncionarioDAO() {
    }
    public List<Funcionario> listarFuncionarios() {
    List<Funcionario> lista = new ArrayList<>();
    String sql = "SELECT * FROM funcionario";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Funcionario f = new Funcionario(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getInt("id_funcionario"),
                rs.getString("cargo"),
                rs.getDouble("salario"),
                rs.getString("login"),
                rs.getString("senha")
            );
            lista.add(f);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }
    public Funcionario buscarPorCpf(String cpf) {
    String sql = "SELECT * FROM funcionario WHERE cpf = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Funcionario(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getInt("id_funcionario"),
                rs.getString("cargo"),
                rs.getDouble("salario"),
                rs.getString("login"),
                rs.getString("senha")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // Não encontrado
    }
    public boolean adicionarFuncionario(Funcionario funcionario) {
    String sql = "INSERT INTO funcionario (cpf, nome, email, telefone, id_funcionario, cargo, salario, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, funcionario.getCpf());
        stmt.setString(2, funcionario.getNome());
        stmt.setString(3, funcionario.getEmail());
        stmt.setString(4, funcionario.getTelefone());
        stmt.setInt(5, funcionario.getIdFuncionario());
        stmt.setString(6, funcionario.getCargo());
        stmt.setDouble(7, funcionario.getSalario());
        stmt.setString(8, funcionario.getLogin());
        stmt.setString(9, funcionario.getSenha());

        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    public boolean removerFuncionarioPorCpf(String cpf) {
    String sql = "DELETE FROM funcionario WHERE cpf = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cpf);
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
}
