package application.model;

public class EmbarcacaoView {
	String nome;
	String dataSaida;
	String dataChegada;
	String carregamento;
	
	public EmbarcacaoView() {
	}
	
	public EmbarcacaoView(String nome, String dataSaida, String dataChegada, String carregamento) {
		super();
		this.nome = nome;
		this.dataSaida = dataSaida;
		this.dataChegada = dataChegada;
		this.carregamento = carregamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}
	public String getCarregamento() {
		return carregamento;
	}
	public void setCarregamento(String carregamento) {
		this.carregamento = carregamento;
	}
	
	
}
