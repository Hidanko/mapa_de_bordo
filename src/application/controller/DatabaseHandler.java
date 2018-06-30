package application.controller;

import java.util.ArrayList;
import java.util.List;

import application.controller.relatorio.model.DadosRelatorioDois;
import application.controller.relatorio.model.DadosRelatorioTres;
import application.controller.relatorio.model.DadosRelatorioUm;
import application.model.EmbarcacaoView;
import application.model.banco.Especie;
import application.model.banco.Porto;
import application.model.banco.Viagem;

public class DatabaseHandler {

	/*
	 * Retornar uma lista de EmbarcacaoView para apresentar na tela principal
	 */
	public List<EmbarcacaoView> requisitarEmbarcacoesView() {
		
		return new ArrayList<EmbarcacaoView>();
	}
	
	/*
	 * Retorna uma lista de Portos para apresentar na lista de adicionar Viagem
	 * O objeto Porto possui o nome e o id
	 */
	public List<Porto> requisitarPortos(){
		
		return new ArrayList<Porto>();
	}
	
	
	/*
	 * Lista de especies para cadastrar viagem
	 * Utilizar o contrutor com ID e NOME
	 * 
	 */
	public List<Especie> requisitarEspecies(){
		
		return new ArrayList<Especie>();
	}
	
	/*
	 * Cadastrar viagem no banco
	 * Retorna TRUE caso seja adicionado com sucesso
	 */
	public boolean adicionarEmbarcacao(Viagem dados) {
		
		return true;
	}
	
	public List<DadosRelatorioUm> gerarRelatorioUm() {
		return new ArrayList<DadosRelatorioUm>();
	}
	
	public List<DadosRelatorioDois> gerarRelatorioDois() {
		return new ArrayList<DadosRelatorioDois>();
	}
	
	public List<DadosRelatorioTres> gerarRelatorioTres() {
		return new ArrayList<DadosRelatorioTres>();
	}
}
