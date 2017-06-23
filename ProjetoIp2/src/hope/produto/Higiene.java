package hope.produto;

public class Higiene extends Produto {
	private String descricao;

	public Higiene(String tipo, int quantidade, String nome, int codigo,
			String descricao) {
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
