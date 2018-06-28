package application.controller.relatorio.model;

public class DadosRelatorioUm {
	int mes;
	int ano;
	int n�meroViagens;
	int embarca��esQueOperaram;
	double totalCapturado;
	
	public DadosRelatorioUm() {
	}

	public DadosRelatorioUm(int mes, int ano, int n�meroViagens, int embarca��esQueOperaram, double totalCapturado) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.n�meroViagens = n�meroViagens;
		this.embarca��esQueOperaram = embarca��esQueOperaram;
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

	public int getN�meroViagens() {
		return n�meroViagens;
	}

	public void setN�meroViagens(int n�meroViagens) {
		this.n�meroViagens = n�meroViagens;
	}

	public int getEmbarca��esQueOperaram() {
		return embarca��esQueOperaram;
	}

	public void setEmbarca��esQueOperaram(int embarca��esQueOperaram) {
		this.embarca��esQueOperaram = embarca��esQueOperaram;
	}

	public double getTotalCapturado() {
		return totalCapturado;
	}

	public void setTotalCapturado(double totalCapturado) {
		this.totalCapturado = totalCapturado;
	}


	
	
}
