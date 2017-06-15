package hope.doacao;

import java.util.Arrays;

import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;
import hope.instituicao.Instituicao;
import hope.produto.Produto;

public class Doacao {
    Instituicao beneficiado;
    DoadorEmpresa empresadoadora;
    DoadorPessoa doador;
	int quantidade;
	Produto[] produto;
	int doacaoDinheiro;
	int codigo;
	
	public Doacao(Instituicao beneficiado, DoadorEmpresa empresadoadora,
			DoadorPessoa doador, int quantidade, Produto produto,
			int doacaoDinheiro, int codigo) {
		
		this.beneficiado = beneficiado;
		this.empresadoadora = empresadoadora;
		this.doador = doador;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.produto = new Produto[100];
		this.doacaoDinheiro = doacaoDinheiro;
	}
	
	

	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	public Produto[] getProduto() {
		return produto;
	}

	public void setProduto(Produto[] produto) {
		this.produto = produto;
	}

	public int getDoacaoDinheiro() {
		return doacaoDinheiro;
	}

	public void setDoacaoDinheiro(int doacaoDinheiro) {
		this.doacaoDinheiro = doacaoDinheiro;
	}



	@Override
	public String toString() {
		return "Doacao [beneficiado=" + beneficiado + ", empresadoadora="
				+ empresadoadora + ", doador=" + doador + ", quantidade="
				+ quantidade + ", produto=" + Arrays.toString(produto)
				+ ", doacaoDinheiro=" + doacaoDinheiro + ", codigo=" + codigo
				+ "]";
	}

	
		
	
	
}
