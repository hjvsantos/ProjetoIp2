package hope.doador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import hope.doacao.Doacao;
import hope.doador.DoadorPessoa;
import hope.excecao.ErroDeNegocioExcecao;

public class ControladorDoadorPessoa {

	private RepositorioDoadorPessoa repositorioDoador;
	private static ControladorDoadorPessoa instance;
	
	public ControladorDoadorPessoa() {
		this.repositorioDoador = RepositorioDoadorPessoa.getInstance();
	}
	
	public static ControladorDoadorPessoa getInstance() {
		if(instance == null) {
			instance = new ControladorDoadorPessoa();
		}
		return instance;
	}
	
	private boolean existe(String codigo) {
		ArrayList<DoadorPessoa> resultado = this.repositorioDoador.listar();
		for(DoadorPessoa d : resultado){
			if(d.getCodDoador().equals(codigo)){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarDoador(DoadorPessoa doador) throws ErroDeNegocioExcecao{
		if(doador != null && !this.existe(doador.getCodDoador())){
			this.repositorioDoador.cadastrarDoadorPessoa(doador);
		} else{
			throw new ErroDeNegocioExcecao("Doador cadastrado com sucesso");
		}
	}
	
	public DoadorPessoa buscarDoadorPessoa(int codigo) throws ErroDeNegocioExcecao{
		DoadorPessoa resultado = this.repositorioDoador.buscarDoadorPessoa(codigo);
		return resultado;
	}
	
	public void atualizarDoadorPessoa(DoadorPessoa novoDoador) throws ErroDeNegocioExcecao{
		if(novoDoador != null && this.existe(novoDoador.getCodigoDoador())){
			this.repositorioDoador.atualizarDoadorPessoa(novoDoador);
		} else{
			throw new ErroDeNegocioExcecao("Doador não encontrada!");
		}
	}
	
	public void removerD(int codigo) throws ErroDeNegocioExcecao{
		Doador d = this.repositorioDoador.buscarDoadorPessoa(codigo);
		if(d != null){
			this.repositorioDoador.removerDoadorPessoa(codigo);
		} else{
			throw new ErroDeNegocioExcecao("Doador inexistente");
		}
	}
	
	public ArrayList<DoadorPessoa> listarDoadoresP (){
		return this.repositorioDoador.listar();
	}
	
}
	
	