package hope.produto;

public class Produto {
	
	private String tipo;
	private int quantidade;
	private String nome;
	private int codigo;
	
	public Produto(String tipo, int quantidade, String nome, int codigo) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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