package hope.doador;

import java.util.ArrayList;

import hope.excecao.ErroDeNegocioExcecao;
import hope.instituicao.Instituicao;
import hope.produto.Alimento;

public class ControladorDoadorEmpresa {

	private RepositorioDoadorEmpresa repositorioDE;
	private static ControladorDoadorEmpresa instance;
	
	public static ControladorDoadorEmpresa getInstance() {
		if(instance == null) {
			instance = new ControladorDoadorEmpresa();
		}
		return instance;
	}
	
	private boolean existe(int codigo) {
		ArrayList<DoadorEmpresa> resultado = this.repositorioDE.listar();
		for(DoadorEmpresa d : resultado){
			if(d.getCodigoDoador() == codigo){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarDoadorEmpresa(DoadorEmpresa doadorE) throws ErroDeNegocioExcecao{
		if(doadorE != null && !this.existe(doadorE.getCodigoDoador())){
			this.repositorioDE.cadastrarDoadorEmpresa(doadorE);
		} else{
			throw new ErroDeNegocioExcecao("Empresa/Instituição cadastrada com sucesso");
		}
	}
	
	public DoadorEmpresa buscarDoadorEmpresa(int cod) throws ErroDeNegocioExcecao{
		DoadorEmpresa resultado = this.repositorioDE.buscarDoadorEmpresa(cod);
		return resultado;
	}
	
	public void atualizarDoadorEmpresa(DoadorEmpresa novoDoador) throws ErroDeNegocioExcecao{
		if(novoDoador != null && this.existe(novoDoador.getCodigoDoador())){
			this.repositorioDE.atualizarDoadorEmpresa(novoDoador);
		} else{
			throw new ErroDeNegocioExcecao("Empresa/Instituicao Doadora n�o encontrada!");
		}
	}
	
	public void removerDoadorEmpresa(int codigo) throws ErroDeNegocioExcecao{
		Doador d = this.repositorioDE.buscarDoadorEmpresa(codigo);
		if(d != null){
			this.repositorioDE.removerDoadorEmpresa(codigo);
		} else{
			throw new ErroDeNegocioExcecao("Empresa/Instituição inexistente");
		}
	}
	
	public ArrayList<DoadorEmpresa> listarEempresas() throws ErroDeNegocioExcecao{
		return this.repositorioDE.listar();
	}
	
}
