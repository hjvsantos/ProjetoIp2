package classesBasicas;

public class DoadorEmpresa extends Doador{
	
	public int anoFundacao;
	public String cnpj;
	
	public DoadorEmpresa(String nome, int anoFundacao, String cnpj, String cidade, String estado, double numeroCartao,
			double codigoCartao){
		
		super(nome, cidade,estado, numeroCartao, codigoCartao);
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
