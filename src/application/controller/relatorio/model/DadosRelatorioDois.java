package application.controller.relatorio.model;

public class DadosRelatorioDois {
	int mes;
	int ano;
	String nomeEmbarcacao;
	int totalViagens;
	float totalCapturado;
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
	public String getNomeEmbarcacao() {
		return nomeEmbarcacao;
	}
	public void setNomeEmbarcacao(String nomeEmbarcacao) {
		this.nomeEmbarcacao = nomeEmbarcacao;
	}
	public int getTotalViagens() {
		return totalViagens;
	}
	public void setTotalViagens(int totalViagens) {
		this.totalViagens = totalViagens;
	}
	public float getTotalCapturado() {
		return totalCapturado;
	}
	public void setTotalCapturado(float totalCapturado) {
		this.totalCapturado = totalCapturado;
	}
	public DadosRelatorioDois(int mes, int ano, String nomeEmbarcacao, int totalViagens, float totalCapturado) {
		this.mes = mes;
		this.ano = ano;
		this.nomeEmbarcacao = nomeEmbarcacao;
		this.totalViagens = totalViagens;
		this.totalCapturado = totalCapturado;
	}
	
	public DadosRelatorioDois() {
	}
	
}
