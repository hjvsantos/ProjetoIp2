package hope.financeiro;

public class Financeiro {
	
	private String contaOrigem;
	private String contaDestino;
	private int valor;
	private String codOperacao;
	private String codDoador;
	private String codReceptor;
	
	public Financeiro(String contaOrigem, String contaDestino, int valor, String codOperacao, String codDoador,
			String codReceptor) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.codOperacao = codOperacao;
		this.codDoador = codDoador;
		this.codReceptor = codReceptor;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(String codOperacao) {
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
