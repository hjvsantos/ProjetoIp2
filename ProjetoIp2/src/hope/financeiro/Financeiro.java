package hope.financeiro;

public class Financeiro {
	
	private double contaOrigem;
	private double contaDestino;
	private int valor;
	private int codOperacao;
	private String codDoador;
	private String codReceptor;
	
	public Financeiro(double contaOrigem, double contaDestino, int valor, int codOperacao){
		
	}
	
	public Financeiro(){
		
	}
	
	public Financeiro(double contaOrigem, double contaDestino, int valor, int codOperacao, String codDoador,
			String codReceptor) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.codOperacao = codOperacao;
		this.codDoador = codDoador;
		this.codReceptor = codReceptor;
	}

	public double getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(double contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public double getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(double contaDestino) {
		this.contaDestino = contaDestino;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(int codOperacao) {
		this.codOperacao = codOperacao;
	}

	public String getCodDoador() {
		return codDoador;
	}

	public void setCodDoador(String codDoador) {
		this.codDoador = codDoador;
	}

	public String getCodReceptor() {
		return codReceptor;
	}

	public void setCodReceptor(String codReceptor) {
		this.codReceptor = codReceptor;
	}

	public String toString() {
		return "Financeiro [contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + ", valor=" + valor
				+ ", codOperacao=" + codOperacao + ", codDoador=" + codDoador + ", codReceptor=" + codReceptor + "]";
	}
	
}
