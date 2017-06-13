package hope.instituicao;

import hope.produtos.Produtos;

public class Instituicao {

	public String nome;
	public String cnpj;
	public String cidade;
	public String estado;
	private double numeroConta;
	public Produtos donativos;
	
	public Instituicao(String nome, String cnpj, String cidade, String estado,
			double numeroConta, Produtos donativos) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroConta = numeroConta;
		this.donativos = donativos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public double getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(double numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Produtos getDonativos() {
		return donativos;
	}

	public void setDonativos(Produtos donativos) {
		this.donativos = donativos;
	}
	
	public String toString() {
		return "Instituicao [nome=" + nome + ", cnpj=" + cnpj + ", cidade=" + cidade + ", estado=" + estado
				+ ", numeroConta=" + numeroConta + ", donativos=" + donativos + "]";
	}	
		
	
}
