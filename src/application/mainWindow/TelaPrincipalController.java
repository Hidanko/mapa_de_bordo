package application.mainWindow;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TelaPrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> column1;

    @FXML
    private TableView<?> tableMain;

    @FXML
    private TableColumn<?, ?> column4;

    @FXML
    private TableColumn<?, ?> column3;

    @FXML
    private TableColumn<?, ?> column2;

    @FXML
    private Button buttonAdicionar;

    @FXML
    void adicionar(ActionEvent event) {

    	
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(root, 450, 450));
        stage.show();
    }

    @FXML
    void initialize() {

    }
    
    
    private boolean atualizarTabela() {
    	// Requisição no banco
    	
    	
    	return true;
    }
}

