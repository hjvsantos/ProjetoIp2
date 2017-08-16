package aplicacao;

import java.util.ArrayList;

import hope.administrador.Adm;
import hope.administrador.ControladorAdm;
import hope.doacao.ControladorDoacao;
import hope.doacao.Doacao;
import hope.doador.ControladorDoadorEmpresa;
import hope.doador.ControladorDoadorPessoa;
import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;
import hope.doador.controller.LoginController;
import hope.excecao.ErroDeNegocioExcecao;
import hope.financeiro.ControladorFinanceiro;
import hope.financeiro.Financeiro;
import hope.instituicao.ControladorInstituicao;
import hope.instituicao.Instituicao;
import hope.produto.Alimento;
import hope.produto.ControladorAlimento;
import hope.produto.ControladorDiversos;
import hope.produto.ControladorHigiene;
import hope.produto.ControladorVestimenta;
import hope.produto.Diversos;
import hope.produto.Higiene;
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
	private LoginController login;
	
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
	
	//Metodos da classe Administrador
	public void cadastrarAdm(Adm adm) throws ErroDeNegocioExcecao{
		this.administrador.cadastrarAdm(adm);
	}
	
	public void atualizarAdm(Adm adm) throws ErroDeNegocioExcecao{
		this.administrador.atualizarAdm(adm);
	}
	
	public Adm buscarAdm(String cpf) throws ErroDeNegocioExcecao{
		return administrador.buscarAdm(cpf);
	}
	
	public void removerAdm(String cpf) throws ErroDeNegocioExcecao{
		this.administrador.removerAdm(cpf);
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
	
	
	public ArrayList<DoadorPessoa> listarDoadoresPessoa() throws ErroDeNegocioExcecao{
		return doadorPessoa.listarDoadoresP();

	}
	
	//Metodos da Classe DoadorEmpresa
	
	public void cadastrarDoadorEmpresa(DoadorEmpresa doadorEmpresa) throws ErroDeNegocioExcecao{
		this.doadorEmpresa.cadastrarDoadorEmpresa(doadorEmpresa);
	}
	
	public DoadorEmpresa buscarDoadorEmpresa(int codigo) throws ErroDeNegocioExcecao{
		return this.doadorEmpresa.buscarDoadorEmpresa(codigo);
	}
	
	public void atualizarDoadorEmpresa(DoadorEmpresa novoDoador) throws ErroDeNegocioExcecao{
		 this.doadorEmpresa.atualizarDoadorEmpresa(novoDoador);
	}
	
	public void removerDoadorEmpresa(int codigo) throws ErroDeNegocioExcecao{
		this.doadorEmpresa.removerDoadorEmpresa(codigo);
	}
	
	public ArrayList<DoadorEmpresa> listarDoadoresE() throws ErroDeNegocioExcecao{
		return this.doadorEmpresa.listarEempresas();
	}
	
	
	
	//Metodos da classe Instituicao
	public void cadastrarI(Instituicao insti) throws ErroDeNegocioExcecao{
		this.instituicao.cadastrarI(insti);
	}
	
	public Instituicao buscarI(int codInstituicao) throws ErroDeNegocioExcecao{
		return instituicao.buscarI(codInstituicao);
	}
	
	public void removerI(String codInstituicao) throws ErroDeNegocioExcecao{
		this.instituicao.removerI(codInstituicao);
	}
	
	public void atualizarInstituicao(Instituicao novaInsti) throws ErroDeNegocioExcecao{
		this.instituicao.atualizarInstituicao(novaInsti);
	}
	
	public ArrayList<Instituicao> listarInstituicoes() throws ErroDeNegocioExcecao{
		return instituicao.listarInstituicoes();
	}
	
	

	 //Metodos da Classe Doação 
	
	public void cadastrarDoacao(Doacao doacao) throws ErroDeNegocioExcecao {
		this.doacao.cadastrarD(doacao);
	}

	public Doacao buscarDoacao(int codigoDoacao) throws ErroDeNegocioExcecao {
		return this.doacao.buscarD(codigoDoacao);
	}

	public void removerDoacao(int codigoDoacao) throws ErroDeNegocioExcecao {
		this.doacao.removerD(codigoDoacao);
	}

	public ArrayList<Doacao> listarDoacoes() throws ErroDeNegocioExcecao {
		return this.doacao.listarDoacao();
	}
	
	//Metodos da Classe Alimento
	
	public void cadastrarH(Alimento alimento) throws ErroDeNegocioExcecao{
		this.alimento.cadastrarH(alimento);
	}
	
	public Alimento buscarAlimento(int codProduto) throws ErroDeNegocioExcecao{
		return alimento.buscarA(codProduto);
	}
	
	public void removerAlimento(int codProduto) throws ErroDeNegocioExcecao{
		 alimento.removerA(codProduto);
	}
	
	public ArrayList<Alimento> listarAlimentos() throws ErroDeNegocioExcecao {
		return alimento.listarAlimentos();
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
	
	
	public int efetuarLoginAdm(String cpf, String senha) throws ErroDeNegocioExcecao{
		return login.efetuarLoginAdm(cpf, senha); 
	}
	
	public int efetuarLoginUsuarios(int cod, String senha) throws ErroDeNegocioExcecao{
		return login.efetuarLoginUsuarios(cod, senha); 
	}
	
}