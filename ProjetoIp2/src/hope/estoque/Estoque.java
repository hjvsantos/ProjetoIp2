package hope.estoque;

import hope.categoria.Categoria;

public class Estoque {

	private Categoria categoria;
	private String tipoProduto;
	private boolean disponivel;
	private int quantidade;
	private int codigo;
	
	public Estoque (Categoria categoria, String tipoProduto, boolean disponivel, int quantidade, int codigo) {
		this.categoria = categoria;
		this.tipoProduto = tipoProduto;
		this.disponivel = disponivel;
		this.quantidade = quantidade;
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return "Estoque [categoria=" + categoria + ", tipoProduto=" + tipoProduto + ", disponivel=" + disponivel
				+ ", quantidade=" + quantidade + "]";
	}
	
}
	