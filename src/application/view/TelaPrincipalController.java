package application.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.controller.DatabaseHandler;
import application.model.EmbarcacaoView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaPrincipalController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<EmbarcacaoView, String> column1;

	@FXML
	private TableView<EmbarcacaoView> tableMain;

	@FXML
	private TableColumn<EmbarcacaoView, String> column4;

	@FXML
	private TableColumn<EmbarcacaoView, String> column3;

	@FXML
	private TableColumn<EmbarcacaoView, String> column2;

	@FXML
	private Button buttonAdicionar;
	@FXML
	private Text mensagem;
	
    @FXML
    void gerarRelatorioUm(ActionEvent event) {

    }

    @FXML
    void gerarRelatorioDois(ActionEvent event) {

    }

    @FXML
    void gerarRelatorioTres(ActionEvent event) {

    }

	@FXML
	void adicionar(ActionEvent event) {

		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("sub/TelaAdicionar.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.setTitle("Adicionar");
		stage.setScene(new Scene(root));
		stage.show();

	}

	@FXML
	void initialize() throws ClassNotFoundException {
		column1.setCellValueFactory(new PropertyValueFactory<EmbarcacaoView, String>("nome"));
		column2.setCellValueFactory(new PropertyValueFactory<EmbarcacaoView, String>("dataSaida"));
		column3.setCellValueFactory(new PropertyValueFactory<EmbarcacaoView, String>("dataChegada"));
		column4.setCellValueFactory(new PropertyValueFactory<EmbarcacaoView, String>("carregamento"));

		if (atualizarTabela()) {
			mensagem.setText("Serviço online");
			// Opcional
			// mensagem.setStyle("ALTERAR COR USANDO CSS");
		} else {
			mensagem.setText("Sem conexão");
			// Opcional
			// mensagem.setStyle("ALTERAR COR USANDO CSS");
		}
	}

	/*
	 * Método para ser invocado sempre que for atualizar a tabela Retornar FALSE
	 * caso ocorra algum erro
	 */
	private boolean atualizarTabela() throws ClassNotFoundException {
		DatabaseHandler dbh = DatabaseHandler.getInstance();
                
		List<EmbarcacaoView> embarcacoes = dbh.requisitarEmbarcacoesView();

		ObservableList<EmbarcacaoView> data = FXCollections.observableArrayList(embarcacoes);

		tableMain.getItems().setAll(data);

		return true;
	}
}
