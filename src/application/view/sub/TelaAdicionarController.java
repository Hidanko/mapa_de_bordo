package application.view.sub;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.controller.DatabaseHandler;
import application.model.banco.Embarcacao;
import application.model.banco.Especie;
import application.model.banco.Porto;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

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
	private ChoiceBox<Embarcacao> choseSaida;

	@FXML
	private ChoiceBox<Embarcacao> choseChegada;

	@FXML
	void initialize() {
		DatabaseHandler dbh = new DatabaseHandler();
		List<Porto> portos = dbh.requisitarPortos();
		List<Especie> especies = dbh.requisitarEspecies();
		
		
	}
}
