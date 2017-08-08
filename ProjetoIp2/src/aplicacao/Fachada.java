package aplicacao;
import java.util.ArrayList;

import hope.doacao.RepositorioDoacao;
import hope.doacao.IRepositorioDoacao;
import hope.doacao.Doacao;
import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;
import hope.doador.IRepositorioDoadorEmpresa;
import hope.doador.IRepositorioDoadorPessoa;
import hope.doador.RepositorioDoadorEmpresa;
import hope.doador.RepositorioDoadorPessoa;
import hope.financeiro.Financeiro;
import hope.financeiro.IRepositorioFinanceiro;
import hope.financeiro.RepositorioFinanceiro;
import hope.instituicao.IRepositorioInstituicao;
import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;
import hope.produto.Alimento;
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
	
	IRepositorioDoadorPessoa repDoadorP = new RepositorioDoadorPessoa();
	IRepositorioDoadorEmpresa repDoadorE = new RepositorioDoadorEmpresa();
	IRepositorioInstituicao repInstituicao = new RepositorioInstituicao();
	IRepositorioDoacao repDoacao = new RepositorioDoacao ();
	IRepositorioAlimento repAlimento = new RepositorioAlimento();
	IRepositorioDiversos repDiversos = new RepositorioDiversos();
	IRepositorioHigiene repHigiene = new RepositorioHigiene();
	IRepositorioVestimenta repVestimenta = new RepositorioVestimenta();
	IRepositorioFinanceiro repFinanceiro = new RepositorioFinanceiro(null, 100);
	
	public static Fachada instance;
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	//Metodos da classe DoadorPessoa:
	public boolean cadastrarDoadorPessoa(DoadorPessoa doadorPessoa){
		return repDoadorP.cadastrarDoadorPessoa(doadorPessoa);
	}
	
	public DoadorPessoa buscarDoadorPessoa(int codigo){
		return repDoadorP.buscarDoadorPessoa(codigo);
	}
	
	public boolean atualizarDoadorPessoa(DoadorPessoa novoDoadorP){
		//return repDoadorP.atualizarDoadorPessoa(novoDoadorP); //TO DO
	}
	
	public boolean removerDoadorPessoa(int codigo){
		return repDoadorP.removerDoadorPessoa(codigo);
	}
	
	public ArrayList<DoadorPessoa> listarDoadoresPessoa(){
		return repDoadorP.listar();
		
	}
	
	//Metodos da Classe DoadorEmpresa
	
	public boolean cadastrarDoadorEmpresa(DoadorEmpresa doadorEmpresa){
		return repDoadorE.cadastrarDoadorEmpresa(doadorEmpresa);
	}
	
	public DoadorEmpresa buscarDoadorEmpresa(int codigo){
		return repDoadorE.buscarDoadorEmpresa(codigo);
	}
	
	public boolean atualizarDoadorEmpresa(DoadorEmpresa novoDoadorE){
		//return repDoadorE.atualizarDoadorEmpresa(novoDoadorE); //TO DO
	}
	
	public boolean removerDoadorEmpresa(int codigo){
		return repDoadorE.removerDoadorEmpresa(codigo);
	}
	
	public ArrayList<DoadorEmpresa> listarDoadoresE(){
		return repDoadorE.listar();
	}
	
	
	
	//Metodos da classe Instituicao
	public boolean cadastrarI(Instituicao insti){
		return repInstituicao.cadastrarI(insti);
	}
	
	public Instituicao buscarI(int codInstituicao){
		return repInstituicao.buscarI(codInstituicao);
	}
	
	public boolean removerInstituicao(int codInstituicao){
		return repInstituicao.removerI(codInstituicao);
	}
	
	public boolean atualizarInstituicao(Instituicao novaInsti){
		return repInstituicao.atualizarInstituicao(novaInsti);
	}
	
	public ArrayList<Instituicao> listarInstituicoes(){
		return repInstituicao.listar();
	}
	
	

	 //Metodos da Classe Doação 
	
	public boolean cadastrarDoacao(Doacao doacao) {
		return repDoacao.cadastrarDoacao(doacao);
	}

	public Doacao buscarDoacao(int codigoDoacao) {
		return repDoacao.buscarDoacao(codigoDoacao);
	}

	public boolean atualizarDoacao(Doacao novaDoacao) {
		return repDoacao.atualizarDoacao(novaDoacao);
	}

	public boolean removerDoacao(int codigoDoacao) {
		return repDoacao.removerDoacao(codigoDoacao);
	}

	public String listarDoacoes() {
		return repDoacao.listarDoacoes();
	}
	
	//Metodos da Classe Alimento
	
	public boolean cadastrar(Alimento alimento){
		return repAlimento.cadastrar(alimento);
	}
	
	public boolean atualizarAlimento(Alimento alimento){
		return repAlimento.atualizarAlimento(alimento);
	}
	
	public Alimento buscarAlimento(int codigo){
		return repAlimento.buscarAlimento(codigo);
	}
	
	public boolean removerAlimento(int codigo){
		return repAlimento.removerAlimento(codigo);
	}
	
	public String listarAlimentos(){
		return repAlimento.listarAlimentos();
	}
	
	//Metodos da Classe Diversos
	
	public boolean cadastrarDiv(Diversos div){
		return repDiversos.cadastrarDiv(div);
	}
	
	public boolean atualizarDiv(Diversos div){
		return repDiversos.atualizarDiv(div);
	}
	
	public Diversos buscarDiv(int codigo){
		return repDiversos.buscarDiv(codigo);
	}
	
	public boolean removerDiv(int codigo){
		return repDiversos.removerDiv(codigo);
	}
	
	public String listarDiv(){
		return repDiversos.listarDiv();
	}
	
	//Metodos da Classe Higiene
	
	public boolean cadastrar(Higiene higiene){
		return repHigiene.cadastrar(higiene);
	}
	
	public boolean atualizarHigiene(Higiene higiene){
		return repHigiene.atualizarHigiene(higiene);
	}
	
	public Higiene buscarHig(int codigo){
		return repHigiene.buscarHig(codigo);
	}
	
	public boolean removerHigiene(int codigo){
		return repHigiene.removerHigiene(codigo);
	}
	
	public String listarHigiene(){
		return repHigiene.listarHigiene();
	}
	
	//Metodos da Classe Vestimenta
	
	public boolean cadastrar(Vestimenta roupa){
		return repVestimenta.cadastrar(roupa);
	}
	
	public boolean atualizar(Vestimenta roupa){
		return repVestimenta.atualizar(roupa);
	}
	
	public Vestimenta buscarVest(int codigo){
		return repVestimenta.buscarVest(codigo);
	}
	
	public boolean remover(int codigo){
		return repVestimenta.remover(codigo);
	}
	
	public boolean consultarExistenciaV(int codigo){
		return repVestimenta.consultarExistenciaV(codigo);
	}
	
	public int retornarPosicaoV(int codigo){
		return repVestimenta.retornarPosicaoV(codigo);
	}
	
	public String listar(){
		return repVestimenta.listar();
	}
	
	//Metodos da Classe Financeiro
	
	public boolean cadastrar(Financeiro doacaoDinheiro){
		return repFinanceiro.cadastrar(doacaoDinheiro);
	}
	
	public boolean atualizar(Financeiro doacaoDinheiro){
		return repFinanceiro.atualizar(doacaoDinheiro);
	}
	
	public Financeiro buscarDoadorDinhehiro(String codDoador){
		return repFinanceiro.buscarDoadorDinhehiro(codDoador);
	}
	
	public boolean removerDoacaoDinheiro(int codOperacao){
		return repFinanceiro.removerDoacaoDinheiro(codOperacao);
	}
	
	public boolean consultarExistenciaF(int codOperacao){
		return repFinanceiro.consultarExistenciaF(codOperacao);
	}
	
	public int retornarPosicaoF(int cod){
		return repFinanceiro.retornarPosicaoF(cod);
	}
	
	public String listarDoadoresFinanceiros(){
		return repFinanceiro.listarDoacoesFinanceiras();
	}

}