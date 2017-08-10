package aplicacao;
import java.util.ArrayList;

import hope.doacao.RepositorioDoacao;
import hope.doacao.IRepositorioDoacao;
import hope.administrador.ControladorAdm;
import hope.doacao.ControladorDoacao;
import hope.doacao.Doacao;
import hope.doador.ControladorDoadorEmpresa;
import hope.doador.ControladorDoadorPessoa;
import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;
import hope.doador.IRepositorioDoadorEmpresa;
import hope.doador.IRepositorioDoadorPessoa;
import hope.doador.RepositorioDoadorEmpresa;
import hope.doador.RepositorioDoadorPessoa;
import hope.excecao.ErroDeNegocioExcecao;
import hope.financeiro.ControladorFinanceiro;
import hope.financeiro.Financeiro;
import hope.financeiro.IRepositorioFinanceiro;
import hope.financeiro.RepositorioFinanceiro;
import hope.instituicao.ControladorInstituicao;
import hope.instituicao.IRepositorioInstituicao;
import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;
import hope.produto.Alimento;
import hope.produto.ControladorAlimento;
import hope.produto.ControladorDiversos;
import hope.produto.ControladorHigiene;
import hope.produto.ControladorVestimenta;
import hope.produto.Diversos;
import hope.produto.Higiene;
import hope.produto.IRepositorioAlimento;
import hope.produto.IRepositorioDiversos;
import hope.produto.IRepositorioHigiene;
import hope.produto.IRepositorioVestimenta;
import hope.produto.RepositorioAlimento;
import hope.produto.RepositorioDiversos;
import hope.produto.RepositorioHigiene;
import hope.produto.RepositorioVestimenta;
import hope.produto.Vestimenta;

public class Fachada {
	
	private static Fachada instance;
	private ControladorAdm administrador;
	private ControladorDoadorEmpresa doadorEmpresa;
	private ControladorDoadorPessoa doadorPessoa;
	private ControladorInstituicao instituicao;
	private ControladorDoacao doacao;
	private ControladorAlimento alimento;
	private ControladorDiversos diversos;
	private ControladorHigiene higiene;
	private ControladorVestimenta vestimenta;
	private ControladorFinanceiro financeiro;
	
	private Fachada(){
		this.administrador = ControladorAdm.getInstance();
		this.doadorEmpresa = ControladorDoadorEmpresa.getInstance();
		this.doadorPessoa = ControladorDoadorPessoa.getInstance();
		this.instituicao = ControladorInstituicao.getInstance();
		this.doacao = ControladorDoacao.getInstance();
		this.alimento = ControladorAlimento.getInstance();
		this.diversos = ControladorDiversos.getInstance();
		this.higiene = ControladorHigiene.getInstance();
		this.vestimenta = ControladorVestimenta.getInstance();
		this.financeiro = ControladorFinanceiro.getInstance();
	}
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	//Metodos da classe DoadorPessoa:
	public void cadastrarDoador(DoadorPessoa doador) throws ErroDeNegocioExcecao{
		this.doadorPessoa.cadastrarDoador(doador);
	}
	
	public DoadorPessoa buscarDoadorPessoa(int codigo) throws ErroDeNegocioExcecao {
		return doadorPessoa.buscarDoadorPessoa(codigo);
	}
	
	public void atualizarDoadorPessoa(DoadorPessoa novoDoador) throws ErroDeNegocioExcecao{
		this.doadorPessoa.atualizarDoadorPessoa(novoDoador);
	}
	
	public void removerD(int codigo) throws ErroDeNegocioExcecao{
		this.doadorPessoa.removerD(codigo);
	}
	
	/*
	public ArrayList<DoadorPessoa> listarDoadoresPessoa(){
		return doadorPessoa.listar();
		TODO falta fazer esse método no controlador! Conferir se tem no repositorio tb
	}
	*/
	
	//Metodos da Classe DoadorEmpresa
	
	public boolean cadastrarDoadorEmpresa(DoadorEmpresa doadorEmpresa){
		return repDoadorE.cadastrarDoadorEmpresa(doadorEmpresa);
	}
	
	public DoadorEmpresa buscarDoadorEmpresa(int codigo){
		return repDoadorE.buscarDoadorEmpresa(codigo);
	}
	
	public boolean atualizarDoadorEmpresa(DoadorEmpresa novoDoador){
		return repDoadorE.atualizarDoadorEmpresa(novoDoador); //TO DO
	}
	
	public boolean removerDoadorEmpresa(int codigo){
		return repDoadorE.removerDoadorEmpresa(codigo);
	}
	
	public ArrayList<DoadorEmpresa> listarDoadoresE(){
		return repDoadorE.listar();
	}
	
	
	
	//Metodos da classe Instituicao
	public void cadastrarI(Instituicao insti) throws ErroDeNegocioExcecao{
		this.instituicao.cadastrarI(insti);
	}
	
	public Instituicao buscarI(int codInstituicao) throws ErroDeNegocioExcecao{
		return instituicao.buscarI(codInstituicao);
	}
	
	public void removerI(int codInstituicao) throws ErroDeNegocioExcecao{
		this.instituicao.removerI(codInstituicao);
	}
	
	public void atualizarInstituicao(Instituicao novaInsti) throws ErroDeNegocioExcecao{
		this.instituicao.atualizarInstituicao(novaInsti);
	}
	
	public ArrayList<Instituicao> listarInstituicoes() throws ErroDeNegocioExcecao{
		return instituicao.listarInstituicoes();
	}
	
	

	 //Metodos da Classe Doação 
	
	public boolean cadastrarDoacao(Doacao doacao) {
		return repDoacao.cadastrarDoacao(doacao);
	}

	public Doacao buscarDoacao(int codigoDoacao) {
		return repDoacao.buscarDoacao(codigoDoacao);
	}

	public boolean removerDoacao(int codigoDoacao) {
		return repDoacao.removerDoacao(codigoDoacao);
	}

	public ArrayList<Doacao> listarDoacoes() {
		return repDoacao.listarDoacoes();
	}
	
	//Metodos da Classe Alimento
	
	public boolean cadastrarA(Alimento alimento){
		return repAlimento.cadastrarA(alimento);
	}
	
	public Alimento buscarAlimento(int codProduto){
		return repAlimento.buscarAlimento(codProduto);
	}
	
	public boolean removerAlimento(int codProduto){
		return repAlimento.removerAlimento(codProduto);
	}
	
	public ArrayList<Alimento> listarAlimentos(){
		return repAlimento.listarAlimentos();
	}
	
	//Metodos da Classe Diversos
	
	public void cadastrarD(Diversos div) throws ErroDeNegocioExcecao{
		this.diversos.cadastrarD(div);
	}
	
	public void atualizarDiversos(Diversos div) throws ErroDeNegocioExcecao{
		this.diversos.atualizarDiversos(div);
	}
	
	public Diversos buscarD(int codProduto) throws ErroDeNegocioExcecao{
		return diversos.buscarD(codProduto);
	}
	
	public void removerDiversos(int codProduto) throws ErroDeNegocioExcecao{
		this.diversos.removerDiversos(codProduto);
	}
	
	public ArrayList<Diversos> listarDiversos() throws ErroDeNegocioExcecao{
		return diversos.listarDiversos();
	}
	
	//Metodos da Classe Higiene
	
	public void cadastrarH(Higiene higiene) throws ErroDeNegocioExcecao{
		this.higiene.cadastrarH(higiene);
	}
	
	public void atualizarHigiene(Higiene higiene) throws ErroDeNegocioExcecao{
		this.higiene.atualizarHigiene(higiene);
	}
	
	public Higiene buscarH(int codProduto) throws ErroDeNegocioExcecao{
		return higiene.buscarH(codProduto);
	}
	
	public void removerH(int codProduto) throws ErroDeNegocioExcecao{
		this.higiene.removerH(codProduto);
	}
	
	public ArrayList<Higiene> listarHigiene() throws ErroDeNegocioExcecao{
		return higiene.listarHigiene();
	}
	
	//Metodos da Classe Vestimenta
	
	public void cadastrarV(Vestimenta vestimenta) throws ErroDeNegocioExcecao{
		this.vestimenta.cadastrarV(vestimenta);
	}
	
	public void atualizarV(Vestimenta vestimenta) throws ErroDeNegocioExcecao{
		this.vestimenta.atualizarV(vestimenta);
	}
	
	public Vestimenta buscarV(int codProduto) throws ErroDeNegocioExcecao{
		return vestimenta.buscarV(codProduto);
	}
	
	public void removerV(int codProduto) throws ErroDeNegocioExcecao{
		this.vestimenta.removerV(codProduto);
	}
	
	public ArrayList<Vestimenta> listarRoupas() throws ErroDeNegocioExcecao{
		return vestimenta.listarRoupas();
	}
	
	//Metodos da Classe Financeiro
	
	public void cadastrar(Financeiro doacaoDinheiro) throws ErroDeNegocioExcecao{
		this.financeiro.cadastrar(doacaoDinheiro);
	}
	
	public void atualizarF(Financeiro novaDoacao) throws ErroDeNegocioExcecao{
		this.financeiro.atualizarF(novaDoacao);
	}
	
	public Financeiro buscarDoacaoFinanceira(int codOperacao) throws ErroDeNegocioExcecao{
		return financeiro.buscarDoacaoFinanceira(codOperacao);
	}
	
	public void removerDoacaoFinanceira(int codOperacao) throws ErroDeNegocioExcecao{
		this.financeiro.removerDoacaoFinanceira(codOperacao);
	}
	
	public ArrayList<Financeiro> listarDoacoesFinanceiras() throws ErroDeNegocioExcecao{
		return financeiro.listarDoacoesFinanceiras();
	}
	
}