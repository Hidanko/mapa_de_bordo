package application.model.banco;

public class Especie {
	int id;
	String nome;
	float peso;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Especie(int id, String nome, float peso) {
		super();
		this.id = id;
		this.nome = nome;
		this.peso = peso;
	}
	
	/*
	 * Construtor da requisição de banco
	 */
	public Especie(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	
	
}
