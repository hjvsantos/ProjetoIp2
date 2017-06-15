package aplicacao;

import hope.doador.Doador;
import hope.doador.IRepositorioDoador;
import hope.doador.RepositorioDoador;
import hope.instituicao.IRepositorioInstituicao;
import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;

public class Fachada {
	
	IRepositorioDoador repDoador = new RepositorioDoador(null, 100);
	IRepositorioInstituicao repInstituicao = new RepositorioInstituicao(null, 100);
	
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
	

}
