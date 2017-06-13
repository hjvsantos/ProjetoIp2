package hope.doador;

public class Doador {

	public String nome;
	public String cidade;
	public String estado;
	private double numeroCartao;
	private double codigoCartao;
	private int type;
	private int codigoDoador;
	
	public Doador(String nome, String cidade, String estado, double numeroCartao, double codigoCartao, int type, int codigoDoador) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroCartao = numeroCartao;
		this.codigoCartao = codigoCartao;
		this.type = type;
		this.codigoDoador = codigoDoador;
	}
	
	
	
	public int getCodigoDoador() {
		return codigoDoador;
	}



	public void setCodigoDoador(int codigoDoador) {
		this.codigoDoador = codigoDoador;
	}



	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Doador [nome=" + nome + ", cidade=" + cidade + ", estado="
				+ estado + ", numeroCartao=" + numeroCartao + ", codigoCartao="
				+ codigoCartao + ", type=" + type + "]";
	}

	
	
}
