package hope.instituicao;

import java.io.Serializable;


public class Instituicao implements Serializable {

	private String nome;
	private String cnpj;
	private String cidade;
	private String estado;
	private double numeroConta;
	private int codInstituicao;
	
	public Instituicao(String nome, String cnpj, String cidade, String estado,
			double numeroConta, int codInstituicao) {
		
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setNumeroConta(numeroConta);
		this.setCodInstituicao(codInstituicao);
	}
	
	public Instituicao(){
		
	}

	public int getCodInstituicao() {
		return codInstituicao;
	}

	public void setCodInstituicao(int codInstituicao) {
		this.codInstituicao = codInstituicao;
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


	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		if(((Instituicao) obj).getCodInstituicao() == (this.codInstituicao)){
			igual = true;
		}
		return igual;
	}

	public String toString() {
		return "Instituicao" + "\n Nome =" + nome 
				+ "\n CNPJ =" + cnpj 
				+ "\n Cidade =" + cidade 
				+ "\n Estado =" + estado
				+ "\n Número da conta =" + numeroConta 
				+ "\n Código ="+ codInstituicao;
	}	
		
	
}