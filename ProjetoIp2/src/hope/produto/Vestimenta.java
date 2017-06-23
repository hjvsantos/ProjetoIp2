package hope.produto;

public class Vestimenta extends Produto {

	 private String tamanho;
	 private String cor;
	 private String genero;
	 
	public Vestimenta(String tipo, int quantidade, String nome, int codigoProduto, String tamanho, String cor, String genero) {
		super(tipo, quantidade, nome, codigoProduto);
		this.tamanho = tamanho;
		this.cor = cor;
		this.genero = genero;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	 
	
}
