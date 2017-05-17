package classesBasicas;

public class Produtos {
	
	public String codigo;
	public String tipo;
	public int quantidade;
	public int validade;
	
	public Produtos(String codigo, String tipo, int quantidade, int validade) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.validade = validade;
		this.codigo = codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
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
		return "Produtos [codigo = " + codigo + "tipo=" + tipo + ", quantidade=" + quantidade + ", validade=" + validade + "]";
	}
	
	
}
