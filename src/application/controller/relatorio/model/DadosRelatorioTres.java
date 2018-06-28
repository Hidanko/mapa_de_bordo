package application.controller.relatorio.model;

public class DadosRelatorioTres {
	private int mes;
	private int ano;
	private String nome;
	private float capturado;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getCapturado() {
		return capturado;
	}
	public void setCapturado(float capturado) {
		this.capturado = capturado;
	}
	public DadosRelatorioTres(int mes, int ano, String nome, float capturado) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.nome = nome;
		this.capturado = capturado;
	}
	
	public DadosRelatorioTres() {
	}
}
