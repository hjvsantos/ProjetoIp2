package hope.administrador;

import hope.excecao.ErroDeNegocioExcecao;

import java.util.ArrayList;

public class ControladorAdm {

	private RepositorioAdm repositorioAdm;
	private static ControladorAdm instance;
	
	public ControladorAdm() {
		this.repositorioAdm = RepositorioAdm.getInstance();
	}
	
	public static ControladorAdm getInstance(){
		if(instance == null){
			instance = new ControladorAdm();
		}
		return instance;
	}
	
	private boolean existe(String cpf){
		ArrayList<Adm> resultado = this.repositorioAdm.listar();
		for(Adm teste : resultado){
			if(teste.getCpf().equals(cpf)){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarAdm(Adm adm) throws ErroDeNegocioExcecao{
		if(adm != null && !this.existe(adm.getCpf())){
			this.repositorioAdm.cadastrarAdm(adm);
		} else{
			throw new ErroDeNegocioExcecao("Administrador não cadastrado!");
		}
	}
	
	public void atualizarAdm(Adm adm) throws ErroDeNegocioExcecao{
		if(adm != null && this.existe(adm.getCpf())){
			this.repositorioAdm.atualizarAdm(adm);
		} else{
			throw new ErroDeNegocioExcecao("Administrador não encontrado!");
		}
	}
	
	public Adm buscarAdm(String cpf) throws ErroDeNegocioExcecao{
		Adm result = this.repositorioAdm.buscarAdm(cpf);
		return result;
	}
	
	public void removerAdm(String cpf) throws ErroDeNegocioExcecao{
		Adm adm= this.repositorioAdm.buscarAdm(cpf);
		if(adm != null){
			this.repositorioAdm.removerAdm(cpf);
		} else{
			throw new ErroDeNegocioExcecao("Administrador não existente!");
		}
	}
}
