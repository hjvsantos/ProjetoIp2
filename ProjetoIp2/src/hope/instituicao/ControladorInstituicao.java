package hope.instituicao;

import hope.excecao.*;

import java.util.ArrayList;

public class ControladorInstituicao {

	private RepositorioInstituicao repositorioInsti;
	private static ControladorInstituicao instance;
	
	public ControladorInstituicao() {
		this.repositorioInsti = RepositorioInstituicao.getInstance();
	}
	
	public static ControladorInstituicao getInstance(){
		if(instance == null){
			instance = new ControladorInstituicao();
		}
		return instance;
	}
	
	private boolean existe(int codInstituicao){
		ArrayList<Instituicao> resultado = this.repositorioInsti.listar();
		for(Instituicao teste : resultado){
			if(teste.getCodInstituicao() == codInstituicao){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarI(Instituicao insti) throws ErroDeNegocioExcecao{
		if(insti != null && !this.existe(insti.getCodInstituicao())){
			this.repositorioInsti.cadastrarI(insti);
		} else{
			//Podemos fazer outros throws aqui, validando o pq que n cadastrou
			throw new ErroDeNegocioExcecao("Instituicao nao cadastrada!");
		}
	}
	
	public void atualizarInstituicao(Instituicao novaInsti) throws ErroDeNegocioExcecao{
		if(novaInsti != null && this.existe(novaInsti.getCodInstituicao())){
			this.repositorioInsti.atualizarInstituicao(novaInsti);
		} else{
			throw new ErroDeNegocioExcecao("Instituição não encontrada!");
		}
	}
	
	public Instituicao buscarI(int codInstituicao) throws ErroDeNegocioExcecao{
		Instituicao result = this.repositorioInsti.buscarI(codInstituicao);
		return result;
	}
	
	public void removerI(int codInstituicao) throws ErroDeNegocioExcecao{
		Instituicao insti = this.repositorioInsti.buscarI(codInstituicao);
		if(insti != null){
			this.repositorioInsti.removerI(codInstituicao);
		} else{
			throw new ErroDeNegocioExcecao("Instituicao não existe!");
		}
	}
	
}
