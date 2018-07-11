package application.model.banco;

public class Embarcacao {
	String nome;
	int id;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Embarcacao(String nome, int id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	 
        @Override
        public String toString(){
            return nome;
        }
	
}
