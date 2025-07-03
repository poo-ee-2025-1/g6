import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class InstalacaoDAO {
    private static InstalacaoDAO instance;
    public boolean inserir(Instalacao instalacao) {
        String sql = "INSERT INTO instalacao (cpf_cliente, id_orcamento, cpf_funcionario, endereco, data_inicio, data_conclusao, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instalacao.getCpfCliente());
            stmt.setInt(2, instalacao.getIdOrcamento());
            stmt.setString(3, instalacao.getCpfFuncionario());
            stmt.setString(4, instalacao.getEndereco());
            stmt.setDate(5, Date.valueOf(instalacao.getDataInicio()));

            if (instalacao.getDataConclusao() != null) {
                stmt.setDate(6, Date.valueOf(instalacao.getDataConclusao()));
            } else {
                stmt.setNull(6, java.sql.Types.DATE);
            }

            stmt.setString(7, instalacao.getStatus().name());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private InstalacaoDAO() {}
    public static InstalacaoDAO getInstance() {
        if (instance == null) {
            instance = new InstalacaoDAO();
        }
        return instance;
    }
    public List<Instalacao> listarInstalacoes() {
    List<Instalacao> lista = new ArrayList<>();
    String sql = "SELECT * FROM instalacao";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Instalacao i = new Instalacao();

            i.setId(rs.getInt("id"));

            Cliente cliente = new Cliente();
            cliente.setCpf(rs.getString("cpf_cliente"));
            i.setCliente(cliente);

            Orcamento orcamento = new Orcamento();
            orcamento.setId(rs.getInt("id_orcamento"));
            i.setOrcamento(orcamento);

            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(rs.getString("cpf_funcionario"));
            i.setFuncionarioResponsavel(funcionario);

            i.setEndereco(rs.getString("endereco"));
            i.setDataInicio(rs.getDate("data_inicio").toLocalDate());

            Date dataConclusao = rs.getDate("data_conclusao");
            if (dataConclusao != null) {
                i.setDataConclusao(dataConclusao.toLocalDate());
            }

            i.setStatus(StatusInstalacao.valueOf(rs.getString("status")));

            lista.add(i);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
    }
    public List<Instalacao> buscarPorCliente(Cliente cliente) {
    List<Instalacao> lista = new ArrayList<>();
    String sql = "SELECT * FROM instalacao WHERE cpf_cliente = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getCpf());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Instalacao i = new Instalacao();

            i.setId(rs.getInt("id"));

            i.setCliente(cliente); // já recebido como parâmetro

            Orcamento orcamento = new Orcamento();
            orcamento.setId(rs.getInt("id_orcamento"));
            i.setOrcamento(orcamento);

            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(rs.getString("cpf_funcionario"));
            i.setFuncionarioResponsavel(funcionario);

            i.setEndereco(rs.getString("endereco"));
            i.setDataInicio(rs.getDate("data_inicio").toLocalDate());

            Date dataConclusao = rs.getDate("data_conclusao");
            if (dataConclusao != null) {
                i.setDataConclusao(dataConclusao.toLocalDate());
            }

            i.setStatus(StatusInstalacao.valueOf(rs.getString("status")));


            lista.add(i);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }
    public List<Instalacao> buscarPorResponsavel(Funcionario funcionario) {
    List<Instalacao> lista = new ArrayList<>();
    String sql = "SELECT * FROM instalacao WHERE cpf_funcionario = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, funcionario.getCpf());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Instalacao i = new Instalacao();
            i.setId(rs.getInt("id"));
            i.setCpfCliente(rs.getString("cpf_cliente"));
            i.setEndereco(rs.getString("endereco"));
            i.setDataInicio(rs.getDate("data_inicio").toLocalDate());

            Date dataConclusao = rs.getDate("data_conclusao");
            if (dataConclusao != null) {
                i.setDataConclusao(dataConclusao.toLocalDate());
            }

            i.setStatus(StatusInstalacao.valueOf(rs.getString("status")));


            // Setando relacionamento básico
            i.setFuncionarioResponsavel(funcionario);

            Orcamento orcamento = new Orcamento();
            orcamento.setId(rs.getInt("id_orcamento"));
            i.setOrcamento(orcamento);

            lista.add(i);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
