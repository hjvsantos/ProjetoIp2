package hope.doacao;

import java.util.Arrays;

import hope.categoria.Categoria;
import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;
import hope.instituicao.Instituicao;
import hope.produto.Produto;

public class Doacao {
	private String nomeDoador;
    private String Instituicao;
    private Categoria categoria;
    private DoadorEmpresa empresadoadora;
    private DoadorPessoa doador;
    private String cidade;
    private String estado;
	private int quantidade;
	private double doacaoDinheiro;
	private int codigo;
	private String valorDoacao;
	private String numeroCartao;
	private String codigoCartao;
	
	public Doacao(Categoria categoria){
		this.categoria = categoria;
	}
	
	/*public Doacao(String Instituicao, ) {
		
	}*/
	
	public Doacao(){
		
	}
	
	public Doacao(String Instituicao, DoadorEmpresa empresadoadora,
			DoadorPessoa doador, int quantidade,
			double doacaoDinheiro, int codigo) {
		
		this.Instituicao = Instituicao;
		this.empresadoadora = empresadoadora;
		this.doador = doador;
		this.codigo = codigo;
		this.quantidade = quantidade;
		//this.produto = new Produto[100];
		this.doacaoDinheiro = doacaoDinheiro;
	}
	
	public Doacao(String nome, String instituicao, Categoria categoria, String valor, String cidade, String estado,
			String numCard, String codCard) {
		this.nomeDoador = nome;
		this.Instituicao = instituicao;
		this.categoria = categoria;
		this.valorDoacao =  valor;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroCartao = numCard;
		this.codigoCartao = codCard;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getInstituicao() {
		return Instituicao;
	}

	public void setCodInstituicao(String codInstituicao) {
		this.Instituicao = Instituicao;
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
		return "Doacao [beneficiado=" + Instituicao + ", empresadoadora="
				+ empresadoadora + ", doador=" + doador + ", quantidade="
				+ quantidade + ", doacaoDinheiro=" + doacaoDinheiro + ", codigo=" + codigo
				+ "]";
	}
	
}