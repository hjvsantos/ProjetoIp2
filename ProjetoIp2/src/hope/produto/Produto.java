package hope.produto;

import java.io.Serializable;

public class Produto implements Serializable{
	
	private String tipo;
	private int quantidade;
	private String nome;
	private int codigoProduto;
	
	public Produto(String tipo, int quantidade, String nome, int codigoProduto) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.nome = nome;
		this.codigoProduto = codigoProduto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigo) {
		this.codigoProduto = codigo;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString() {
		return "Produtos [tipo=" + tipo + ", quantidade=" + quantidade + "]";
	}
	
	
}