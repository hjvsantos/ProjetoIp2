package hope.doador.controller;


import hope.administrador.Adm;
import hope.administrador.ControladorAdm;
import hope.doador.ControladorDoadorEmpresa;
import hope.doador.ControladorDoadorPessoa;
import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;
import hope.excecao.ErroDeNegocioExcecao;
import hope.instituicao.ControladorInstituicao;
import hope.instituicao.Instituicao;



public class LoginController {
	
	private ControladorDoadorPessoa doadorFisico;
	private ControladorDoadorEmpresa doadorJuridico;
	private ControladorAdm administrador;
	private ControladorInstituicao instituicao;
	private static LoginController instance;
	
	public LoginController() {

		this.doadorFisico = ControladorDoadorPessoa.getInstance();
		this.doadorJuridico = ControladorDoadorEmpresa.getInstance();
		this.administrador = ControladorAdm.getInstance();
		this.instituicao = ControladorInstituicao.getInstance();
	}
	
	public static LoginController getInstance() {
		if (instance == null) {
			instance = new LoginController();
		}
		return instance;
	}
	
	public int efetuarLoginAdm(String cpf, String senha) throws ErroDeNegocioExcecao {

		int igual = 0;
		Adm administrador = this.administrador.buscarAdm(cpf);

		if(administrador == null){
			throw new ErroDeNegocioExcecao(" Adm não existe! ");
		}else if (administrador != null && administrador.getSenha().equals(senha)) {
			igual = 1;
		} else {
			throw new ErroDeNegocioExcecao("senha invalida!");
		}
		
		return igual;
	}
	
	public int efetuarLoginUsuarios(int cod, String senha) throws ErroDeNegocioExcecao {

		int igual = 0;
		DoadorPessoa doadorFisico = this.doadorFisico.buscarDoadorPessoa(cod);
		DoadorEmpresa doadorJuridico = this.doadorJuridico.buscarDoadorEmpresa(cod);
		Instituicao instituicao = this.instituicao.buscarI(cod);

		if(doadorFisico == null && doadorJuridico == null && instituicao == null){
			throw new ErroDeNegocioExcecao(" Usuario não existe! ");
		}else if (doadorFisico != null && doadorFisico.getSenha().equals(senha)) {
			igual = 1;
		} else if (doadorJuridico != null && doadorJuridico.getSenha().equals(senha)) {
			igual = -1;
		}else if (instituicao != null && instituicao.getSenha().equals(senha)) {
			igual = -2;
		}else {
			throw new ErroDeNegocioExcecao("senha invalida!");
		}
		
		return igual;
	}
	
}
