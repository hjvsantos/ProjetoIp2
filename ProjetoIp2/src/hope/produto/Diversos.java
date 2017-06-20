package hope.produto;

public class Diversos extends Produto{

	private String descricao;

	public Diversos(String tipo, int quantidade, String nome, int codigo, String descricao) {
		super(tipo, quantidade, nome, codigo);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
