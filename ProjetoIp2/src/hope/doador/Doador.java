package hope.doador;

public class Doador {

	public String nome;
	public String cidade;
	public String estado;
	private double numeroCartao;
	private double codigoCartao;
	private int codigoDoador;
	private String bandeira;
	private String validade;
	private String senha;
	
	public Doador(String nome, String cidade, String estado, double numeroCartao, double codigoCartao, int codigoDoador, String bandeira, String validade, String senha) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroCartao = numeroCartao;
		this.codigoCartao = codigoCartao;
		this.codigoDoador = codigoDoador;
		this.bandeira = bandeira;
		this.validade = validade;
		this.senha = senha;
	}
	
	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCodigoDoador() {
	return codigoDoador;
	}

	/*public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}*/

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
				+ codigoCartao + ", bandeira= " + bandeira + ", validade=" + validade + ", senha=" + senha + "]";
	}

	
	
}
