package hope.produtos;
//testando o git
public class Produtos {
	
	public String tipo;
	public int quantidade;
	public int validade;
	
	public Produtos(String tipo, int quantidade, int validade) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.validade = validade;
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
