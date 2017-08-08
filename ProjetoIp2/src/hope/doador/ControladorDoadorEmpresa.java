package hope.doador;

import java.util.ArrayList;

import hope.excecao.ErroDeNegocioExcecao;

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
	
	public DoadorEmpresa buscarDoadorEmpresa(int codigo) throws ErroDeNegocioExcecao{
		DoadorEmpresa resultado = this.repositorioDE.buscarDoadorEmpresa(codigo);
		return resultado;
	}
	
	public void removerDoadorEmpresa(int codigo) throws ErroDeNegocioExcecao{
		Doador d = this.repositorioDE.buscarDoadorEmpresa(codigo);
		if(d != null){
			this.repositorioDE.removerDoadorEmpresa(codigo);
		} else{
			throw new ErroDeNegocioExcecao("Empresa/Instituição inexistente");
		}
	}
	
}
