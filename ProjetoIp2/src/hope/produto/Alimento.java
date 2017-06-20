package hope.produto;

public class Alimento extends Produto{
	
	int validade;

	public Alimento(String tipo, int quantidade, String nome, int codigo,
			int validade) {
		super(tipo, quantidade, nome, codigo);
		this.validade = validade;
	}

	public int getValidade() {
		return validade;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}
	
	
	
}
