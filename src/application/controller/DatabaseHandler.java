package application.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.controller.relatorio.model.DadosRelatorioDois;
import application.controller.relatorio.model.DadosRelatorioTres;
import application.controller.relatorio.model.DadosRelatorioUm;
import application.model.EmbarcacaoView;
import application.model.banco.Especie;
import application.model.banco.Porto;
import application.model.banco.Viagem;

public class DatabaseHandler {
        private DatabaseHandler INSTANCE;
        private static Connection connection;
        private static final String selectTravels = "SELECT Viagem.id, Embarcacao.nome, Viagem.data_saida, Viagem.data_chegada, \n" +
"sum(Captura.peso) from Viagem inner join Embarcacao on (Viagem.embarcacao_id = Embarcacao.id) \n" +
"inner join Captura on (Captura.viagem_id = Viagem.id) group by Viagem.id, Embarcacao.nome, Viagem.data_saida, Viagem.data_chegada";
        
        public synchronized DatabaseHandler getInstance() throws ClassNotFoundException {
            if (INSTANCE == null) {
                INSTANCE = new DatabaseHandler();
                Conectar con = new Conectar();
                connection = con.Conectar();
            }
            return INSTANCE;
        }
	/*
	 * Retornar uma lista de EmbarcacaoView para apresentar na tela principal
	 */
	public List<EmbarcacaoView> requisitarEmbarcacoesView() {
		PreparedStatement command;
         
            try {
                command = connection.prepareStatement("SELECT Viagem.id, Embarcacao.nome, Viagem.data_saida, Viagem.data_chegada, \n" +
"sum(Captura.peso) from Viagem inner join Embarcacao on (Viagem.embarcacao_id = Embarcacao.id) \n" +
"inner join Captura on (Captura.viagem_id = Viagem.id) group by Viagem.id, Embarcacao.nome, Viagem.data_saida, Viagem.data_chegada");
                System.out.println("erro");
               ResultSet rs = command.executeQuery();
                System.out.println(rs.getString("teste"));
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
                
            }
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
