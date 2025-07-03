import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {
    private static ManutencaoDAO instance;
    private ManutencaoDAO() {}
    public static ManutencaoDAO getInstance() {
        if (instance == null) {
            instance = new ManutencaoDAO();
        }
        return instance;
    }
    public boolean adicionarManutencao(Manutencao m) {
        String sql = "INSERT INTO manutencao (cpf_cliente, descricao, data_solicitacao, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getCliente().getCpf());
            stmt.setString(2, m.getDescricao());
            stmt.setDate(3, java.sql.Date.valueOf(m.getDataSolicitacao()));
            stmt.setString(4, m.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Manutencao> buscarPorCliente(Cliente cliente) {
        List<Manutencao> lista = new ArrayList<>();
        String sql = "SELECT * FROM manutencao WHERE cpf_cliente = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCpf());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Manutencao m = new Manutencao();
                m.setId(rs.getInt("id"));
                Cliente c = new Cliente();
                c.setCpf(rs.getString("cpf_cliente"));
                m.setCliente(c);
                m.setDescricao(rs.getString("descricao"));
                m.setDataSolicitacao(rs.getDate("data_solicitacao").toLocalDate());
                m.setStatus(rs.getString("status"));
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public List<Manutencao> buscarPorResponsavel(Funcionario funcionario) {
    List<Manutencao> lista = new ArrayList<>();
    String sql = "SELECT * FROM manutencao WHERE cpf_responsavel = ?"; // ajuste o nome da coluna conforme seu BD

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, funcionario.getCpf());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Manutencao manutencao = new Manutencao();
            manutencao.setId(rs.getInt("id"));
            manutencao.setCpfCliente(rs.getString("cpf_cliente"));
            manutencao.setDescricao(rs.getString("descricao"));
            manutencao.setDataSolicitacao(rs.getDate("data_solicitacao").toLocalDate());
            manutencao.setStatus(rs.getString("status"));
            // caso tenha um campo para responsável, associe aqui se quiser
            lista.add(manutencao);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
    }
    public List<Manutencao> listarManutencoes() {
    List<Manutencao> lista = new ArrayList<>();
    String sql = "SELECT * FROM manutencao";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Manutencao m = new Manutencao();
            m.setId(rs.getInt("id"));
            m.setCpfCliente(rs.getString("cpf_cliente"));
            m.setDescricao(rs.getString("descricao"));
            m.setDataSolicitacao(rs.getDate("data_solicitacao").toLocalDate());
            m.setStatus(rs.getString("status"));

            // Se você já implementou campo de responsável (opcional)
            try {
                String cpfResponsavel = rs.getString("cpf_responsavel");
                if (cpfResponsavel != null) {
                    FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
                    Funcionario f = funcionarioDAO.buscarPorCpf(cpfResponsavel); // você pode implementar esse método se quiser
                    if (f != null) m.setResponsavel(f);
                }
            } catch (SQLException e) {
                // Campo não existe, tudo bem ignorar
            }

            lista.add(m);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }

}
