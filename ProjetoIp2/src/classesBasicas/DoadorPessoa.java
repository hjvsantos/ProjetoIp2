package classesBasicas;

public class DoadorPessoa {
	
	public String nome;
	public int idade;
	public String cpf;
	public double rg;
	public String cidade;
	public String estado;
	private double numeroCartao;
	private double codigoCartao;

	public DoadorPessoa(String nome, int idade, String cpf, double rg,
			String cidade, String estado, double numeroCartao,
			double codigoCartao) {
		
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getRg() {
		return rg;
	}

	public void setRg(double rg) {
		this.rg = rg;
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
