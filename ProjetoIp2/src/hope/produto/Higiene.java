package hope.produto;

public class Higiene extends Produto {
	private String descricao;
	private boolean itemLimpPessoal;
	private boolean itemLimpGeral;

	public Higiene(String tipo, int quantidade, String nome, int codigo,
			String descricao, boolean itemLimpPessoal, boolean itemLimpGeral) {
		super(tipo, quantidade, nome, codigo);
		this.descricao = descricao;
		this.itemLimpPessoal = itemLimpPessoal;
		this.itemLimpGeral = itemLimpGeral;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isItemLimpPessoal() {
		return itemLimpPessoal;
	}

	public void setItemLimpPessoal(boolean itemLimpPessoal) {
		this.itemLimpPessoal = itemLimpPessoal;
	}

	public boolean isItemLimpGeral() {
		return itemLimpGeral;
	}

	public void setItemLimpGeral(boolean itemLimpGeral) {
		this.itemLimpGeral = itemLimpGeral;
	}
	
}
