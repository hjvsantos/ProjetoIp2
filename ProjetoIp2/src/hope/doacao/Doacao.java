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
	private String tipoDoacao;
	private String observacao;
	
	public Doacao(Categoria categoria){
		this.categoria = categoria;
	}
	
	public Doacao(String tipo, int quantidade, String obs ) {
		this.tipoDoacao = tipo;
		this.quantidade = quantidade;
		this.observacao = obs;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(String tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

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

	public String getNomeDoador() {
		return nomeDoador;
	}

	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValorDoacao() {
		return valorDoacao;
	}

	public void setValorDoacao(String valorDoacao) {
		this.valorDoacao = valorDoacao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(String codigoCartao) {
		this.codigoCartao = codigoCartao;
	}

	public void setInstituicao(String instituicao) {
		Instituicao = instituicao;
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

	public void setCodInstituicao(String Instituicao) {
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