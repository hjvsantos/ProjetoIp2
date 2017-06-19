package aplicacao;
import hope.doacao.RepositorioDoacao;
import hope.doacao.IRepositorioDoacao;
import hope.doacao.Doacao;
import hope.doador.Doador;
import hope.doador.IRepositorioDoador;
import hope.doador.RepositorioDoador;
import hope.estoque.Estoque;
import hope.estoque.IRepositorioEstoque;
import hope.estoque.RepositorioEstoque;
import hope.instituicao.IRepositorioInstituicao;
import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;

public class Fachada {
	
	IRepositorioDoador repDoador = new RepositorioDoador(null, 100);
	IRepositorioInstituicao repInstituicao = new RepositorioInstituicao(null, 100);
	IRepositorioDoacao repDoacao = new RepositorioDoacao (null, 100);
	IRepositorioEstoque repEstoque = new RepositorioEstoque(null, 100);
	
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
	
	//Metodos da Classe Estoque
	
	public boolean inserir(Estoque estoque){
		return repEstoque.inserir(estoque);
	}
	
	public boolean atualizar(Estoque estoque){
		return repEstoque.atualizar(estoque);
	}
	
	public Estoque buscarEstoque(int codigo){
		return repEstoque.buscarEstoque(codigo);
	}
	
	public boolean remover(int codigo){
		return repEstoque.remover(codigo);
	}
	
	public String listarEstoque(){
		return repEstoque.listarEstoque();
	}

}