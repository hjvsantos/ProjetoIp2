package hope.doacao;

import java.util.Arrays;

import hope.categoria.Categoria;
import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;
import hope.instituicao.Instituicao;
import hope.produto.Produto;

public class Doacao {
    private String codInstituicao;
    private Categoria categoria;
    // Esses dois atributos embaixo, n seria melhor por cada um na sua respectiva classe n?
    private DoadorEmpresa empresadoadora;
    private DoadorPessoa doador;
	private int quantidade;
	//Produto[] produto;
	private double doacaoDinheiro;
	private int codigo;
	
	public Doacao(Categoria caregoria, String codInstituicao, DoadorEmpresa empresadoadora,
			DoadorPessoa doador, int quantidade,
			double doacaoDinheiro, int codigo) {
		
		this.codInstituicao = codInstituicao;
		this.empresadoadora = empresadoadora;
		this.doador = doador;
		this.codigo = codigo;
		this.quantidade = quantidade;
		//this.produto = new Produto[100];
		this.doacaoDinheiro = doacaoDinheiro;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCodInstituicao() {
		return codInstituicao;
	}

	public void setCodInstituicao(String codInstituicao) {
		this.codInstituicao = codInstituicao;
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


	/*public Produto[] getProduto() {
		return produto;
	}

	public void setProduto(Produto[] produto) {
		this.produto = produto;
	}*/

	public double getDoacaoDinheiro() {
		return doacaoDinheiro;
	}

	public void setDoacaoDinheiro(double doacaoDinheiro) {
		this.doacaoDinheiro = doacaoDinheiro;
	}

	@Override
	public String toString() {
		return "Doacao [beneficiado=" + codInstituicao + ", empresadoadora="
				+ empresadoadora + ", doador=" + doador + ", quantidade="
				+ quantidade + ", doacaoDinheiro=" + doacaoDinheiro + ", codigo=" + codigo
				+ "]";
	}
	
}