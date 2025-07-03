import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;

public class AcompanharInstalacaoController {

    @FXML private Label statusLabel;
    @FXML private Label enderecoLabel;
    @FXML private Label responsavelLabel;
    @FXML private Label dataInicioLabel;
    @FXML private ProgressBar progressBar;

    private Cliente clienteLogado;
    // Pega a instância única do DAO para buscar os dados corretos
    private InstalacaoDAO instalacaoDAO = InstalacaoDAO.getInstance();

    // Método para receber dados do Dashboard
    public void initData(Cliente cliente) {
        this.clienteLogado = cliente;
        carregarDadosInstalacao();
    }

    private void carregarDadosInstalacao() {
        if (clienteLogado == null) {
            statusLabel.setText("Erro: Cliente não identificado.");
            return;
        }

        List<Instalacao> instalacoesDoCliente = instalacaoDAO.buscarPorCliente(clienteLogado);

        if (!instalacoesDoCliente.isEmpty()) {
            
            Instalacao instalacao = instalacoesDoCliente.get(0); 

            statusLabel.setText(instalacao.getStatus().toString());
            enderecoLabel.setText(instalacao.getEndereco());
            
            if (instalacao.getFuncionarioResponsavel() != null) {
                responsavelLabel.setText(instalacao.getFuncionarioResponsavel().getNome());
            } else {
                responsavelLabel.setText("Ainda não definido");
            }

            if (instalacao.getDataInicio() != null) {
                dataInicioLabel.setText(instalacao.getDataInicio().toString());
            } else {
                dataInicioLabel.setText("-");
            }
            
            atualizarBarraDeProgresso(instalacao.getStatus());

        } else {
            // Caso o cliente realmente não tenha nenhuma instalação
            statusLabel.setText("Nenhuma instalação em andamento.");
            enderecoLabel.setText("-");
            responsavelLabel.setText("-");
            dataInicioLabel.setText("-");
            progressBar.setProgress(0.0);
        }
    }
    private void atualizarBarraDeProgresso(StatusInstalacao status) {
        if (status == null) {
            progressBar.setProgress(0.0);
            return;
        }
        switch (status) {
            case AGUARDANDO_APROVACAO:
                progressBar.setProgress(0.10);
                break;
            case COMPRA_DE_MATERIAIS:
                progressBar.setProgress(0.40);
                break;
            case INSTALACAO_EM_ANDAMENTO:
                progressBar.setProgress(0.75);
                break;
            case INSTALACAO_CONCLUIDA:
                progressBar.setProgress(1.0);
                break;
            default:
                progressBar.setProgress(0.0);
                break;
        }
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
    private void atualizarBarraDeProgresso(String status) {
    double progresso;
    switch (status) {
        case "Pendente":
            progresso = 0.0;
            break;
        case "Em Andamento":
            progresso = 0.5;
            break;
        case "Concluído":
            progresso = 1.0;
            break;
        default:
            progresso = 0.0;
    }
    progressBar.setProgress(progresso); // progressoBar é seu ProgressBar do FXML
    }

}