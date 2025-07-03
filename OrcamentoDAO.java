import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class OrcamentoDAO {
    private static OrcamentoDAO instance;
    public boolean inserir(Orcamento orc) {
        String sql = "INSERT INTO orcamento (cpf_cliente, cpf_funcionario, valor_estimado, energia_gerada, local_instalacao, data_criacao, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, orc.getCpfCliente());
            stmt.setString(2, orc.getCpfFuncionario());
            stmt.setDouble(3, orc.getValorEstimado());
            stmt.setDouble(4, orc.getEnergiaGerada());
            stmt.setString(5, orc.getLocalInstalacao());
            stmt.setDate(6, Date.valueOf(orc.getDataCriacao()));
            stmt.setString(7, orc.getStatus());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizarStatus(int id, String novoStatus) {
        String sql = "UPDATE orcamento SET status = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);

            int linhasAtualizadas = stmt.executeUpdate();
            return linhasAtualizadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private OrcamentoDAO() {}
    public static OrcamentoDAO getInstance() {
        if (instance == null) {
            instance = new OrcamentoDAO();
        }
        return instance;
    }
    public boolean adicionarOrcamento(Orcamento o) {
    String sql = "INSERT INTO orcamento (cpf_cliente, cpf_funcionario, valor_estimado, energia_gerada, local_instalacao, data_criacao, aprovado) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, o.getCliente().getCpf());
        stmt.setString(2, o.getFuncionarioResponsavel().getCpf());
        stmt.setDouble(3, o.getValorEstimado());
        stmt.setDouble(4, o.getEnergiaGerada());
        stmt.setString(5, o.getLocalInstalacao());
        stmt.setDate(6, java.sql.Date.valueOf(o.getDataCriacao()));
        stmt.setBoolean(7, o.isAprovado()); // converte status

        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    public List<Orcamento> listarOrcamentos() {
    List<Orcamento> lista = new ArrayList<>();
    String sql = "SELECT * FROM orcamento";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Orcamento o = new Orcamento();

            o.setId(rs.getInt("id"));

            Cliente cliente = new Cliente();
            cliente.setCpf(rs.getString("cpf_cliente"));
            o.setCliente(cliente);

            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(rs.getString("cpf_funcionario"));
            o.setFuncionarioResponsavel(funcionario);

            o.setValorEstimado(rs.getDouble("valor_estimado"));
            o.setEnergiaGerada(rs.getDouble("energia_gerada"));
            o.setLocalInstalacao(rs.getString("local_instalacao"));
            o.setDataCriacao(rs.getDate("data_criacao").toLocalDate());

            boolean aprovado = rs.getBoolean("aprovado");
            o.setStatus(aprovado ? "Aprovado" : "Pendente");

            lista.add(o);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }
    public List<Orcamento> buscarPorCliente(Cliente cliente) {
    List<Orcamento> lista = new ArrayList<>();
    String sql = "SELECT * FROM orcamento WHERE cpf_cliente = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getCpf());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Orcamento orcamento = new Orcamento();

            orcamento.setId(rs.getInt("id"));
            orcamento.setCliente(cliente); // já temos o cliente
            orcamento.setValorEstimado(rs.getDouble("valor_estimado"));
            orcamento.setEnergiaGerada(rs.getDouble("energia_gerada"));
            orcamento.setLocalInstalacao(rs.getString("local_instalacao"));
            orcamento.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
            orcamento.setStatus(rs.getString("aprovado").equals("t") ? "Aprovado" : "Pendente");

            // Funcionario pode ser nulo no momento da criação
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(rs.getString("cpf_funcionario"));
            orcamento.setFuncionarioResponsavel(funcionario);

            lista.add(orcamento);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
