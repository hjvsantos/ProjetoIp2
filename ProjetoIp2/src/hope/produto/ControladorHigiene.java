package hope.produto;

import hope.excecao.ErroDeNegocioExcecao;
import hope.instituicao.ControladorInstituicao;
import hope.instituicao.Instituicao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ControladorHigiene {
	
	private RepositorioHigiene repositorioH;
	private static ControladorHigiene instance;
	
	public ControladorHigiene() {
		this.repositorioH = RepositorioHigiene.getInstance();
	}
	
	public static ControladorHigiene getInstance(){
		if(instance == null){
			instance = new ControladorHigiene();
		}
		return instance;
	}
	
	private boolean existe(int codProduto){
		ArrayList<Higiene> resultado = this.repositorioH.listarHigiene();
		for(Higiene h : resultado){
			if(h.getCodigoProduto() == codProduto){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarH(Higiene higiene) throws ErroDeNegocioExcecao{
		if(higiene != null && !this.existe(higiene.getCodigoProduto())){
			this.repositorioH.cadastrarH(higiene);
		} else{
			throw new ErroDeNegocioExcecao("Poduto de Higiene cadastrado com sucesso");
		}
	}
	
	public void atualizarHigiene(Higiene higiene) throws ErroDeNegocioExcecao{
		if(higiene != null && !this.existe(higiene.getCodigoProduto())){
			this.repositorioH.atualizarHigiene(higiene);
		} else{
			throw new ErroDeNegocioExcecao("Produto não localizado");
		}
	}
	
	public Higiene buscarH(int codProduto) throws ErroDeNegocioExcecao{
		Higiene result = this.repositorioH.buscarHigiene(codProduto);
		return result;
	}
	
	public void removerH(int codProduto) throws ErroDeNegocioExcecao{
		Higiene h = this.repositorioH.buscarHigiene(codProduto);
		if(h != null){
			this.repositorioH.removerHigiene(codProduto);
		} else{
			throw new ErroDeNegocioExcecao("Produto inexistente");
		}
	}

	public ArrayList<Higiene> listarHigiene() throws ErroDeNegocioExcecao{
		return this.repositorioH.listarHigiene();
	}
}
