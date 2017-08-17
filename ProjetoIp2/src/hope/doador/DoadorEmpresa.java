package hope.doador;

public class DoadorEmpresa extends Doador{
	
	public int anoFundacao;
	public String cnpj;
	
	public DoadorEmpresa(String nome, int anoFundacao, String cnpj, int codigoDoador, String cidade, String estado, String numeroCartao,
			String codigoCartao, String bandeira, String validade, String senha){
		
		super(nome, cidade,estado, numeroCartao, codigoCartao, codigoDoador,bandeira,validade,senha);
		this.anoFundacao = anoFundacao;
		this.cnpj = cnpj;	
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

	public String toString() {
		return "DoadorEmpresa [anoFundacao=" + anoFundacao + ", cnpj=" + cnpj + "]";
	}	
	
}