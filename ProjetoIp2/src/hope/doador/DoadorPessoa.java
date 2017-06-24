package hope.doador;

public class DoadorPessoa extends Doador{
	
	public int idade;
	public String cpf;
	public double rg;
	public int codDoador;
	public DoadorPessoa(String nome, int idade, String cpf, double rg, String cidade, String estado, double numeroCartao,
			int codigoCartao, int codDoador, int tipo){
		
		super(nome, cidade,estado, numeroCartao, codigoCartao, tipo,codDoador);
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
		this.codDoador = codDoador;
	}

	public int getCodDoador() {
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
		return "DoadorPessoa [idade=" + idade + ", cpf=" + cpf + ", rg=" + rg + "]";
	}
		
}