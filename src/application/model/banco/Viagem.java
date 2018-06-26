package application.model.banco;

import java.util.List;

public class Viagem {
	Embarcacao embarcacao;
	Porto chegada;
	Porto saida;
	List<Especie> especies;

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}

	public Porto getChegada() {
		return chegada;
	}

	public void setChegada(Porto chegada) {
		this.chegada = chegada;
	}

	public Porto getSaida() {
		return saida;
	}

	public void setSaida(Porto saida) {
		this.saida = saida;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	public Viagem(Embarcacao embarcacao, Porto chegada, Porto saida, List<Especie> especies) {
		this.embarcacao = embarcacao;
		this.chegada = chegada;
		this.saida = saida;
		this.especies = especies;
	}

}
