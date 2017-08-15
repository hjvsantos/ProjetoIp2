package hope.doador;

import java.util.Arrays;

public class DoadorPessoa extends Doador{
	
	public int idade;
	public String cpf;
	public double rg;
	public String codDoador;
	public DoadorPessoa(String nome, int idade, String cpf, double rg, String cidade, String estado, String numeroCartao,
			String cod_cartao, String codDoador,String bandeira, String validade, String senha){
		
		super(nome, cidade,estado, numeroCartao, cod_cartao,codDoador,bandeira,validade,senha);
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
		this.codDoador = codDoador;
	}

	public String getCodDoador() {
		return codDoador;
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

	public String toString() {
		return "DoadorPessoa [idade=" + idade + ", cpf=" + cpf + ", rg=" + rg + ", codigo=" + codDoador + "]";
	}
		
}