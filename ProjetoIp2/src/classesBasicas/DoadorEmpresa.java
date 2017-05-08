package classesBasicas;

public class DoadorEmpresa {
	
	public String nome;
	public int anoFundacao;
	public String cnpj;
	public String cidade;
	public String estado;
	private double numeroCartao;
	private double codigoCartao;
	
	public DoadorEmpresa(String nome, int anoFundacao, String cnpj,
			String cidade, String estado, double numeroCartao,
			double codigoCartao) {
		
		this.nome = nome;
		this.anoFundacao = anoFundacao;
		this.cnpj = cnpj;
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

	public int getAnoFundacao() {
		return anoFundacao;
	}

	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
		
	
}
