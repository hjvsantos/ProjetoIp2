package hope.produto;

public class Produto {
	
	private String tipo;
	private int quantidade;
	private int validade;
	private String nome;
	private int codigo;
	
	public Produto(String tipo, int quantidade, int validade, String nome, int codigo) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.validade = validade;
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
	
	public int getValidade() {
		return validade;
	}
	
	public void setValidade(int validade) {
		this.validade = validade;
	}
	
	public String toString() {
		return "Produtos [tipo=" + tipo + ", quantidade=" + quantidade + ", validade=" + validade + "]";
	}
	
	
}