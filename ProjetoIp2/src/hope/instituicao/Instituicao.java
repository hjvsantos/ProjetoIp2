package hope.instituicao;

import java.io.Serializable;


public class Instituicao implements Serializable {

	private String nome;
	private String cnpj;
	private String cidade;
	private String estado;
	private String numeroConta;
	private int codInstituicao;
	private String senha;
	
	public Instituicao(String nome, String cnpj, String cidade, String estado,
			String numeroConta, int codInstituicao, String senha) {
		
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setNumeroConta(numeroConta);
		this.setCodInstituicao(codInstituicao);
		this.setSenha(senha);
	}
	
	
	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
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
				+ "\n Senha =" + senha
				+ "\n Código ="+ codInstituicao;
	}	
		
	
}