package aplicacao;
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
	
	IRepositorioDoadorPessoa repDoadorP = new RepositorioDoadorPessoa(null, 100);
	IRepositorioDoadorEmpresa repDoadorE = new RepositorioDoadorEmpresa(null, 100);
	IRepositorioInstituicao repInstituicao = new RepositorioInstituicao(null, 100);
	IRepositorioDoacao repDoacao = new RepositorioDoacao (null, 100);
	IRepositorioAlimento repAlimento = new RepositorioAlimento(null, 100);
	IRepositorioDiversos repDiversos = new RepositorioDiversos(100, null);
	IRepositorioHigiene repHigiene = new RepositorioHigiene(null, 100);
	IRepositorioVestimenta repVestimenta = new RepositorioVestimenta(null, 100);
	IRepositorioFinanceiro repFinanceiro = new RepositorioFinanceiro(null, 100);
	
	public static Fachada instance;
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	//Metodos da classe DoadorPessoa:
	public boolean cadastrarP(DoadorPessoa doadorPessoa){
		return repDoadorP.cadastrarP(doadorPessoa);
	}
	
	public DoadorPessoa buscarP(String cpf){
		return repDoadorP.buscarP(cpf);
	}
	
	public boolean atualizarDoadorP(DoadorPessoa novoDoadorP){
		return repDoadorP.atualizarDoadorP(novoDoadorP);
	}
	
	public boolean removerDoadorP(String cpf){
		return repDoadorP.removerDoadorP(cpf);
	}
	
	public String listarDoadoresP(){
		return repDoadorP.listarDoadoresP();
		
	}
	
	//Metodos da Classe DoadorEmpresa
	
	public boolean cadastrarE(DoadorEmpresa doadorEmpresa){
		return repDoadorE.cadastrarE(doadorEmpresa);
	}
	
	public DoadorEmpresa buscarE(String cnpj){
		return repDoadorE.buscarE(cnpj);
	}
	
	public boolean atualizarDoadorE(DoadorEmpresa novoDoadorE){
		return repDoadorE.atualizarDoadorE(novoDoadorE);
	}
	
	public boolean removerDoadorE(String cnpj){
		return repDoadorE.removerDoadorE(cnpj);
	}
	
	public String listarDoadoresE(){
		return repDoadorE.listarDoadoresE();
	}
	
	
	
	//Metodos da classe Instituicao
	public boolean cadastrarI(Instituicao insti){
		return repInstituicao.cadastrarI(insti);
	}
	
	public Instituicao buscarI(String cnpj){
		return repInstituicao.buscarI(cnpj);
	}
	
	public boolean removerInstituicao(String cnpj){
		return repInstituicao.removerInstituicao(cnpj);
	}
	
	public boolean atualizarInstituicao(Instituicao novaInsti){
		return repInstituicao.atualizarInstituicao(novaInsti);
	}
	
	public String listarInstituicoes(){
		return repInstituicao.listarInstituicoes();
	}
	
	public boolean consultarExistencia(int codInstituicao){
		return repInstituicao.consultarExistencia(codInstituicao);
	}
	
	public int retornarPosicao(int cod){
		return repInstituicao.retornarPosicao(cod);
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