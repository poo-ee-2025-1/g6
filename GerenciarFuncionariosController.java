import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.List;

public class GerenciarFuncionariosController {

    // Campos do Formulário
    @FXML private TextField nomeField;
    @FXML private TextField cpfField;
    @FXML private TextField emailField;
    @FXML private TextField telefoneField;
    @FXML private TextField idField;
    @FXML private TextField cargoField;
    @FXML private TextField salarioField;
    @FXML private TextField loginField;
    @FXML private PasswordField senhaField;
    @FXML private Label statusLabel;

    // Componentes da Tabela
    @FXML private TableView<Funcionario> funcionariosTable;
    @FXML private TableColumn<Funcionario, Integer> idColumn;
    @FXML private TableColumn<Funcionario, String> nomeColumn;
    @FXML private TableColumn<Funcionario, String> cargoColumn;
    @FXML private TableColumn<Funcionario, Double> salarioColumn;
    @FXML private TableColumn<Funcionario, Void> acaoColumn;

    private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idFuncionario"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cargoColumn.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        salarioColumn.setCellValueFactory(new PropertyValueFactory<>("salario"));
        
        adicionarBotaoRemover();
        carregarFuncionarios();
    }

    @FXML
    void handleAdicionarFuncionario(ActionEvent event) {
        try {
            Funcionario novo = new Funcionario(
                nomeField.getText(),
                cpfField.getText(),
                emailField.getText(),
                telefoneField.getText(),
                Integer.parseInt(idField.getText()),
                cargoField.getText(),
                Double.parseDouble(salarioField.getText()),
                loginField.getText(),
                senhaField.getText()
            );
            
            funcionarioDAO.adicionarFuncionario(novo);
            carregarFuncionarios(); // Recarrega a tabela com o novo funcionário
            limparFormulario();
            statusLabel.setText("Funcionário adicionado com sucesso!");

        } catch (NumberFormatException e) {
            statusLabel.setText("Erro: ID e Salário devem ser números.");
        }
    }
    
    private void carregarFuncionarios() {
        List<Funcionario> lista = funcionarioDAO.listarFuncionarios();
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(lista);
        funcionariosTable.setItems(funcionarios);
    }
    
    private void limparFormulario() {
        nomeField.clear();
        cpfField.clear();
        emailField.clear();
        telefoneField.clear();
        idField.clear();
        cargoField.clear();
        salarioField.clear();
        loginField.clear();
        senhaField.clear();
    }
    
    private void adicionarBotaoRemover() {
        Callback<TableColumn<Funcionario, Void>, TableCell<Funcionario, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Funcionario, Void> call(final TableColumn<Funcionario, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button("Remover");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Funcionario funcionario = getTableView().getItems().get(getIndex());
                            funcionarioDAO.removerFuncionarioPorCpf(funcionario.getCpf());
                            carregarFuncionarios(); // Recarrega a tabela
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };
        acaoColumn.setCellFactory(cellFactory);
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        Navigation.navigateTo(event, "DashboardGerente.fxml", "Painel Administrativo");
    }
}