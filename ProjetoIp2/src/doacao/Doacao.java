package hope.Doacao;

import hope.Doador.DoadorEmpresa;
import hope.Doador.DoadorPessoa;
import hope.instituicao.Instituicao;
import hope.produtos.Produtos;

public class Doacao {
    Instituicao beneficiado;
    DoadorEmpresa empresadoadora;
    DoadorPessoa doador;
	int quantidade;
	Produtos produto;
	int doacaoDinheiro;
	
	public Doacao(Instituicao beneficiado, DoadorEmpresa empresadoadora,
			DoadorPessoa doador, int quantidade, Produtos produto,
			int doacaoDinheiro) {
		
		this.beneficiado = beneficiado;
		this.empresadoadora = empresadoadora;
		this.doador = doador;
		this.quantidade = quantidade;
		this.produto = produto;
		this.doacaoDinheiro = doacaoDinheiro;
	}

	public Instituicao getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(Instituicao beneficiado) {
		this.beneficiado = beneficiado;
	}

	public DoadorEmpresa getEmpresadoadora() {
		return empresadoadora;
	}

	public void setEmpresadoadora(DoadorEmpresa empresadoadora) {
		this.empresadoadora = empresadoadora;
	}

	public DoadorPessoa getDoador() {
		return doador;
	}

	public void setDoador(DoadorPessoa doador) {
		this.doador = doador;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public int getDoacaoDinheiro() {
		return doacaoDinheiro;
	}

	public void setDoacaoDinheiro(int doacaoDinheiro) {
		this.doacaoDinheiro = doacaoDinheiro;
	}

	public String toString() {
		return "Doacao [beneficiado=" + beneficiado + ", empresadoadora=" + empresadoadora + ", doador=" + doador
				+ ", quantidade=" + quantidade + ", produto=" + produto + ", doacaoDinheiro=" + doacaoDinheiro + "]";
	}
	
	
	
	
	
}
