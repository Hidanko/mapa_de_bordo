package application.model;

public class EspecieView {
	String nome;
	float quantidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public EspecieView(String nome, float quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

}
