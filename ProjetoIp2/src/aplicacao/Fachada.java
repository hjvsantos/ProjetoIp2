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
	IRepositorioFinanceiro repFinanceiro = new RepositorioFinanceiro();
	
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
	
	public boolean removerI(int codInstituicao){
		return repInstituicao.removerI(codInstituicao);
	}
	
	public boolean atualizarInstituicao(Instituicao novaInsti){
		return repInstituicao.atualizarInstituicao(novaInsti);
	}
	
	public ArrayList<Instituicao> listarInstituicoes(){
		return repInstituicao.listarInstituicoes();
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
	
	public boolean cadastrarD(Diversos div){
		return repDiversos.cadastrarD(div);
	}
	
	public boolean atualizarDiversos(Diversos div){
		return repDiversos.atualizarDiversos(div);
	}
	
	public Diversos buscarDiversos(int codProduto){
		return repDiversos.buscarDiversos(codProduto);
	}
	
	public boolean removerDiversos(int codProduto){
		return repDiversos.removerDiversos(codProduto);
	}
	
	public ArrayList<Diversos> listarDiversos(){
		return repDiversos.listarDiversos();
	}
	
	//Metodos da Classe Higiene
	
	public boolean cadastrarH(Higiene higiene){
		return repHigiene.cadastrarH(higiene);
	}
	
	public boolean atualizarHigiene(Higiene higiene){
		return repHigiene.atualizarHigiene(higiene);
	}
	
	public Higiene buscarHigiene(int codProduto){
		return repHigiene.buscarHigiene(codProduto);
	}
	
	public boolean removerHigiene(int codProduto){
		return repHigiene.removerHigiene(codProduto);
	}
	
	public ArrayList<Higiene> listarHigiene(){
		return repHigiene.listarHigiene();
	}
	
	//Metodos da Classe Vestimenta
	
	public boolean cadastrarV(Vestimenta roupa){
		return repVestimenta.cadastrarV(roupa);
	}
	
	public boolean atualizarV(Vestimenta roupa){
		return repVestimenta.atualizarV(roupa);
	}
	
	public Vestimenta buscarV(int codProduto){
		return repVestimenta.buscarV(codProduto);
	}
	
	public boolean removerV(int codProduto){
		return repVestimenta.removerV(codProduto);
	}
	
	public ArrayList<Vestimenta> listar(){
		return repVestimenta.listar();
	}
	
	//Metodos da Classe Financeiro
	
	public boolean cadastrar(Financeiro doacaoDinheiro){
		return repFinanceiro.cadastrar(doacaoDinheiro);
	}
	
	public boolean atualizarF(Financeiro novaDoacao){
		return repFinanceiro.atualizarF(novaDoacao);
	}
	
	public Financeiro buscarDoacaoFinanceira(int codOperacao){
		return repFinanceiro.buscarDoacaoFinanceira(codOperacao);
	}
	
	public boolean removerDoacaoDinheiro(int codOperacao){
		return repFinanceiro.removerDoacaoDinheiro(codOperacao);
	}
	
	public ArrayList<Financeiro> listarDoacoesFinanceiras(){
		return repFinanceiro.listarDoacoesFinanceiras();
	}

}