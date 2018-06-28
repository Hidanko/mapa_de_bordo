package application.controller.relatorio.model;

public class DadosRelatorioUm {
	int mes;
	int ano;
	int númeroViagens;
	int embarcaçõesQueOperaram;
	double totalCapturado;
	
	public DadosRelatorioUm() {
	}

	public DadosRelatorioUm(int mes, int ano, int númeroViagens, int embarcaçõesQueOperaram, double totalCapturado) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.númeroViagens = númeroViagens;
		this.embarcaçõesQueOperaram = embarcaçõesQueOperaram;
		this.totalCapturado = totalCapturado;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNúmeroViagens() {
		return númeroViagens;
	}

	public void setNúmeroViagens(int númeroViagens) {
		this.númeroViagens = númeroViagens;
	}

	public int getEmbarcaçõesQueOperaram() {
		return embarcaçõesQueOperaram;
	}

	public void setEmbarcaçõesQueOperaram(int embarcaçõesQueOperaram) {
		this.embarcaçõesQueOperaram = embarcaçõesQueOperaram;
	}

	public double getTotalCapturado() {
		return totalCapturado;
	}

	public void setTotalCapturado(double totalCapturado) {
		this.totalCapturado = totalCapturado;
	}


	
	
}
