package application.view.sub;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import application.controller.DatabaseHandler;
import application.model.banco.Embarcacao;
import application.model.banco.Especie;
import application.model.banco.Porto;
import application.model.banco.Viagem;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaAdicionarController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private DatePicker datePickerSaida;

	@FXML
	private DatePicker datePickerChegada;

	@FXML
	private ChoiceBox<Embarcacao> choseEmbarcacao;

	@FXML
	private ChoiceBox<Porto> choseSaida;

	@FXML
	private ChoiceBox<Porto> choseChegada;

	@FXML
	private Text mensagem;

	@FXML
	private TableColumn<Especie, Float> columnQuantidade;

	@FXML
	private TableColumn<Especie, String> columnEspecie;

	@FXML
	private Button buttonAdicionar;

	@FXML
	private ChoiceBox<Especie> choseEspecie;

	@FXML
	private TextField textQuantidade;

	List<Especie> listaEspecies;
	@FXML
	void adicionar(ActionEvent event) {
		mensagem.setText("");

		Embarcacao embarcacao = choseEmbarcacao.getSelectionModel().getSelectedItem();
		Porto saida = choseSaida.getSelectionModel().getSelectedItem();
		Porto chegada = choseChegada.getSelectionModel().getSelectedItem();
		LocalDate dataSaida = datePickerChegada.getValue();
		LocalDate dataChegada = datePickerChegada.getValue();

		Viagem viagem = new Viagem(embarcacao, chegada, saida, listaEspecies);

		if (chegada == null) {
			mensagem.setText("Porto de chegada não definido");
		} else if (saida == null) {
			mensagem.setText("Porto de saída não definido");
		} else if (dataSaida == null || dataSaida.equals(null)) {
			mensagem.setText("Data de saída não preenchida");
		} else if (dataChegada == null || dataChegada.equals(null)) {
			mensagem.setText("Data de chegada não preenchida");
		} else if (embarcacao.equals(null)) {
			mensagem.setText("Selecione uma embarcação");
		} else {
			DatabaseHandler dbh = new DatabaseHandler();
			
			
			if (dbh.adicionarEmbarcacao(viagem)) {
			
			Stage stage = (Stage) buttonAdicionar.getScene().getWindow();
			stage.close();
			} else {
				mensagem.setText("Erro interno");
			}
		}
	}

	@FXML
	void initialize() {

		columnEspecie.setCellValueFactory(new PropertyValueFactory<Especie, String>("Especie"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<Especie, Float>("Quantidade"));

		listaEspecies = new ArrayList<Especie>();

		DatabaseHandler dbh = new DatabaseHandler();
		List<Porto> portos = dbh.requisitarPortos();
		List<Especie> especies = dbh.requisitarEspecies();

		choseSaida.getItems().setAll((Collection<? extends Porto>) FXCollections.observableArrayList(portos));
		choseChegada.getItems().setAll((Collection<? extends Porto>) FXCollections.observableArrayList(portos));
		choseEspecie.getItems().setAll((Especie) FXCollections.observableArrayList(especies));
	}

	@FXML
	void adicionarEspecie(ActionEvent event) {
		mensagem.setText("");
		
		Especie especie = choseEspecie.getSelectionModel().getSelectedItem();
		String quantidadeString = textQuantidade.getText();
		
		if (especie == null) {
			mensagem.setText("Selecione uma espécie da lista");
		} else if (quantidadeString == null) {
			mensagem.setText("Digite uma quantidade válida");
		}
		
		// adicionar especie selecionada ao listaEspecies
		// adicionar especie selecionada a tabela
		// (caso já exista, adicionar valor ao anterior)
		// limpar campos
	}
}
