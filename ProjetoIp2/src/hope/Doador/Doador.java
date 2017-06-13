package hope.Doador;
//testando o git
public class Doador {

	public String nome;
	public String cidade;
	public String estado;
	private double numeroCartao;
	private double codigoCartao;
	
	public Doador(String nome, String cidade, String estado, double numeroCartao, double codigoCartao) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroCartao = numeroCartao;
		this.codigoCartao = codigoCartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(double numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public double getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(double codigoCartao) {
		this.codigoCartao = codigoCartao;
	}

	public String toString() {
		return "Doador [nome=" + nome + ", cidade=" + cidade + ", estado=" + estado + ", numeroCartao=" + numeroCartao
				+ ", codigoCartao=" + codigoCartao + "]";
	}
	
}
