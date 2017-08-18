package hope.administrador;

import java.io.Serializable;

public class Adm implements Serializable{

	private String nome;
	private String cpf;
	private String senha;
	private String cidade;
	private String estado;

	public Adm(String nome, String cpf, String senha, String cidade,
			String estado) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Adm() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	@Override
	public String toString() {
		return "Adm [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	
		
}
