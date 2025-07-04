import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MeusOrcamentosController {

    @FXML private TableView<Orcamento> orcamentosTable;
    @FXML private TableColumn<Orcamento, LocalDate> dataColumn;
    @FXML private TableColumn<Orcamento, Double> valorColumn;
    @FXML private TableColumn<Orcamento, Double> energiaColumn;
    
    // **** CORREÇÃO AQUI ****
    // A coluna de status agora espera um Texto (String), não um booleano.
    @FXML private TableColumn<Orcamento, String> statusColumn;

    private Cliente clienteLogado;
    private OrcamentoDAO orcamentoDAO = OrcamentoDAO.getInstance();

    @FXML
    public void initialize() {
        // Configuração das colunas de dados
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
        valorColumn.setCellValueFactory(new PropertyValueFactory<>("valorEstimado"));
        energiaColumn.setCellValueFactory(new PropertyValueFactory<>("energiaGerada"));
        
        // **** CORREÇÃO PRINCIPAL AQUI ****
        // A coluna de status agora está vinculada diretamente ao atributo "status" (String) da classe Orcamento.
        // Não precisamos mais de uma lógica customizada para exibir o texto, a tabela fará isso automaticamente.
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    
    public void initData(Cliente cliente) {
        this.clienteLogado = cliente;
        carregarOrcamentos();
    }

    private void carregarOrcamentos() {
        if (clienteLogado == null) return;
        
        // Busca os orçamentos na lista central do DAO, filtrando pelo cliente logado
        List<Orcamento> listaDeOrcamentos = orcamentoDAO.buscarPorCliente(clienteLogado);
        
        ObservableList<Orcamento> orcamentosObservaveis = FXCollections.observableArrayList(listaDeOrcamentos);
        orcamentosTable.setItems(orcamentosObservaveis);
    }
    
    @FXML
    void handleVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardCliente.fxml"));
            Parent root = loader.load();
            DashboardClienteController controller = loader.getController();
            controller.initData(clienteLogado);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Painel do Cliente");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}