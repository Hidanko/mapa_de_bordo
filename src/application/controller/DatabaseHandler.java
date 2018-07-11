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
import application.model.banco.Embarcacao;
import application.model.banco.Especie;
import application.model.banco.Porto;
import application.model.banco.Viagem;
import java.time.ZoneId;
import java.util.Date;

public class DatabaseHandler {
        private static DatabaseHandler INSTANCE;
        private static Connection connection;
        private static final String selectTravels = "SELECT Viagem.id, Embarcacao.nome, Viagem.data_saida, Viagem.data_chegada, \n" +
"sum(Captura.peso) from Viagem inner join Embarcacao on (Viagem.embarcacao_id = Embarcacao.id) \n" +
"inner join Captura on (Captura.viagem_id = Viagem.id) group by Viagem.id, Embarcacao.nome, Viagem.data_saida, Viagem.data_chegada";
        
        public static synchronized DatabaseHandler getInstance() throws ClassNotFoundException {
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
                List<EmbarcacaoView> embarcacao = new ArrayList<EmbarcacaoView>() ;
         
            try {
                command = connection.prepareCall("SELECT Viagem.id, Embarcacao.nome as nome, Viagem.data_saida as data_saida, Viagem.data_chegada as data_chegada, \n" +
"sum(Captura.peso) as Captura from Viagem inner join Embarcacao on (Viagem.embarcacao_id = Embarcacao.id) \n" +
"inner join Captura on (Captura.viagem_id = Viagem.id) group by Viagem.id, Embarcacao.nome, Viagem.data_saida, Viagem.data_chegada");
                
                ResultSet rs = command.executeQuery();
                
                while(rs.next()){ 
                    String nome = rs.getString("nome");
                    Date data_saida = rs.getDate("data_saida");
                    Date data_chegada = rs.getDate("data_chegada");
                    float captura = rs.getFloat("Captura");
                    EmbarcacaoView emb = new EmbarcacaoView(nome, data_saida.toString(), data_chegada.toString(), String.valueOf(captura));
                    embarcacao.add(emb);
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
                
            }
		return embarcacao;
	}
	
	/*
	 * Retorna uma lista de Portos para apresentar na lista de adicionar Viagem
	 * O objeto Porto possui o nome e o id
	 */
	public List<Porto> requisitarPortos(){
		PreparedStatement command;
                List<Porto> porto = new ArrayList<Porto>() ;
         
            try {
                command = connection.prepareCall("SELECT * From Porto");
                
                ResultSet rs = command.executeQuery();
                
                while(rs.next()){ 
                    String nome = rs.getString("nome");
                    int id  = rs.getInt("id");
                    Porto port = new Porto();
                    port.setNome(nome);
                    port.setId(id);
                    porto.add(port);
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
                
            }
		return porto;
	}
	
	
	/*
	 * Lista de especies para cadastrar viagem
	 * Utilizar o contrutor com ID e NOME
	 * 
	 */
	public List<Especie> requisitarEspecies(){
		PreparedStatement command;
                List<Especie> especie = new ArrayList<Especie>() ;
         
            try {
                command = connection.prepareCall("SELECT * From Especie");
                
                ResultSet rs = command.executeQuery();
                
                while(rs.next()){ 
                    String nome = rs.getString("nome");
                    int id  = rs.getInt("id");
                    Especie esp = new Especie(id, nome);
                    especie.add(esp);
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
                
            }
		return especie;
		
	}
	
        public List<Embarcacao> requisitarEmbarcacao(){
		PreparedStatement command;
                List<Embarcacao> embarcacao = new ArrayList<Embarcacao>() ;
         
            try {
                command = connection.prepareCall("SELECT * From Embarcacao");
                
                ResultSet rs = command.executeQuery();
                
                while(rs.next()){ 
                    String nome = rs.getString("nome");
                    int id  = rs.getInt("id");
                    Embarcacao emb = new Embarcacao(nome, id);
                    embarcacao.add(emb);
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
                
            }
		return embarcacao;
		
	}
        
	/*
	 * Cadastrar viagem no banco
	 * Retorna TRUE caso seja adicionado com sucesso
	 */
	public boolean adicionarViagem(Viagem dados) {
		PreparedStatement command;
                try{
                    command = connection.prepareStatement("Insert into Viagem (data_saida, data_chegada, embarcacao_id, porto_saida_id, porto_chegada_id)VALUES (?,?,?,?,?");
                    command.setDate(1, java.sql.Date.valueOf(dados.getData_chegada()));
                    command.setDate(2, java.sql.Date.valueOf(dados.getData_saida()));
                    command.setInt(3, dados.getEmbarcacao().getId());
                    command.setInt(4, dados.getSaida().getId());
                    command.setInt(5, dados.getChegada().getId());
                    boolean ok = command.execute();
                    command.close();
                    return ok;
               
                }catch(SQLException ex){
                    return false;
                }
		
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
