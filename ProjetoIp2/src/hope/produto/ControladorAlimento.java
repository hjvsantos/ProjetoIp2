package hope.produto;

import hope.excecao.ErroDeNegocioExcecao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ControladorAlimento {
	
private RepositorioAlimento repositorioA;
private static ControladorAlimento instance;
	
	public ControladorAlimento() {
		this.repositorioA = RepositorioAlimento.getInstance();
	}
	
	public static ControladorAlimento getInstance(){
		if(instance == null){
			instance = new ControladorAlimento();
		}
		return instance;
	}
	
	private boolean existe(int codProduto){
		ArrayList<Alimento> resultado = this.repositorioA.listarAlimentos();
		for(Alimento a : resultado){
			if(a.getCodigoProduto() == codProduto){
				return true;
			}
		}
		return false;
	}
	
	
	public void cadastrarH(Alimento alimento) throws ErroDeNegocioExcecao{
		if(alimento != null && !this.existe(alimento.getCodigoProduto())){
			this.repositorioA.cadastrarA(alimento);
		} else{
			throw new ErroDeNegocioExcecao("Alimento cadastrado com sucesso");
		}
	}
	public Alimento buscarA(int codProduto) throws ErroDeNegocioExcecao{
		Alimento result = this.repositorioA.buscarAlimento(codProduto);
		return result;
	}
	
	public void removerA(int codProduto) throws ErroDeNegocioExcecao{
		Alimento a = this.repositorioA.buscarAlimento(codProduto);
		if(a != null){
			this.repositorioA.removerAlimento(codProduto);
		} else{
			throw new ErroDeNegocioExcecao("Alimento inexistente");
		}
	
	}
	
	public ArrayList<Alimento> listarAlimentos() throws ErroDeNegocioExcecao{
		return this.repositorioA.listarAlimentos();
	}

}
