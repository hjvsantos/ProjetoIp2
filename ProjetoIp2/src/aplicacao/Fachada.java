package aplicacao;
import hope.doacao.RepositorioDoacao;
import hope.doacao.IRepositorioDoacao;
import hope.doacao.Doacao;
import hope.doador.Doador;
import hope.doador.IRepositorioDoador;
import hope.doador.RepositorioDoador;
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
	
	IRepositorioDoador repDoador = new RepositorioDoador(null, 100);
	IRepositorioInstituicao repInstituicao = new RepositorioInstituicao(null, 100);
	IRepositorioDoacao repDoacao = new RepositorioDoacao (null, 100);
	IRepositorioAlimento repAlimento = new RepositorioAlimento(null, 100);
	IRepositorioDiversos repDiversos = new RepositorioDiversos(100, null);
	IRepositorioHigiene repHigiene = new RepositorioHigiene(null, 100);
	IRepositorioVestimenta repVestimenta = new RepositorioVestimenta(null, 100);
	
	
	public static Fachada instance;
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	//Metodos da classe Doador:
	public boolean cadastrar(Doador doador){
		return repDoador.cadastrar(doador);
	}
	
	public Doador buscar(int codigoDoador){
		return repDoador.buscar(codigoDoador);
	}
	
	public boolean atualizarDoador(Doador novoDoador){
		return repDoador.atualizarDoador(novoDoador);
	}
	
	public boolean removerDoador(int codigoDoador){
		return repDoador.removerDoador(codigoDoador);
	}
	
	public String listarDoadores(){
		return repDoador.listarDoadores();
	}
	
	//Metodos da classe Instituicao
	public boolean cadastrar(Instituicao insti){
		return repInstituicao.cadastrar(insti);
	}
	
	public Instituicao buscar(String cnpj){
		return repInstituicao.buscar(cnpj);
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

}