package controller;

import java.sql.SQLException;
import application.App;
import dao.EstudanteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Estudante;
import utils.Constraints;

public class ExcluiEstudanteController {

    private Estudante estudante;

    /**
     * Objeto DAO para manipulação dos dados
     */
    private EstudanteDAO estudanteDAO;

    @FXML
    private Button btnCon;

    @FXML
    private Button btnCan;

    @FXML
    private TextField tfdNome;

    @FXML
    public void initialize() {
        inicializaNodes();
    }

    /**
     * Event handler para button btnConOnAction (Confirmar)
     */
    @FXML
    private void btnConOnAction(ActionEvent event) {
        if (!(tfdNome.getText().isEmpty())) {
            estudante = new Estudante();
            estudante.setNome(tfdNome.getText());

            estudanteDAO = new EstudanteDAO();
            try {
                estudanteDAO.excluir(estudante);
                Alert alert;
                alert = new Alert(AlertType.INFORMATION, "Você clicou no botão Confirmar", ButtonType.OK);
                alert.setTitle("Estudante excluído com sucesso!");
                alert.setHeaderText("Informação");
                alert.show();
                BorderPane border = App.getRoot();
                border.setCenter(null);
            } catch (SQLException e1) {
                Alert alert;
                alert = new Alert(AlertType.INFORMATION, "Ocorreu um problema", ButtonType.OK);
                alert.setTitle("Estudante não foi excluído com sucesso!");
                alert.setHeaderText("Informação");
                alert.show();
                e1.printStackTrace();
                BorderPane border = App.getRoot();
                border.setCenter(null);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Um ou mais campos não foram preenchidos!");
            alert.showAndWait();
        }

    }

    /**
     * Event handler para button btnCanOnAction (Cancelar)
     */
    @FXML
    private void btnCanOnAction(ActionEvent event) {
        Alert alert;
        alert = new Alert(AlertType.INFORMATION, "Você clicou no botão Cancelar", ButtonType.OK);
        alert.setTitle("Estudante não foi excluído com sucesso!");
        alert.setHeaderText("Informação");
        alert.show();
        // Retornar à tela principal após clicar no botão Cancelar
        BorderPane border = App.getRoot();
        border.setCenter(null);
    }

    private void inicializaNodes() {
        // Aplica restrição de tamanho máximo de 60 caracteres para o textField txfNome
        Constraints.setTextFieldMaxLength(tfdNome, 60);
    }
}
