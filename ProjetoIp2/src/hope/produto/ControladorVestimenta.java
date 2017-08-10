package hope.produto;

import hope.excecao.ErroDeNegocioExcecao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ControladorVestimenta {
	
	private RepositorioVestimenta repositorioV;
	private static ControladorVestimenta instance;
	
	public ControladorVestimenta() {
		this.repositorioV = RepositorioVestimenta.getInstance();
	}
	
	public static ControladorVestimenta getInstance(){
		if(instance == null){
			instance = new ControladorVestimenta();
		}
		return instance;
	}
	
	private boolean existe(int codProduto){
		ArrayList<Vestimenta> resultado = this.repositorioV.listarRoupas();
		for(Vestimenta v : resultado){
			if(v.getCodigoProduto() == codProduto){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarV(Vestimenta vestimenta) throws ErroDeNegocioExcecao{
		if(vestimenta != null && !this.existe(vestimenta.getCodigoProduto())){
			this.repositorioV.cadastrarV(vestimenta);
		} else{
			throw new ErroDeNegocioExcecao("Vestimenta cadastrada com sucesso");
		}
	}
	
	public void atualizarV(Vestimenta vestimenta) throws ErroDeNegocioExcecao{
		if(vestimenta != null && !this.existe(vestimenta.getCodigoProduto())){
			this.repositorioV.atualizarV(vestimenta);
		} else{
			throw new ErroDeNegocioExcecao("Vestimenta não localizado");
		}
	}
	
	public Vestimenta buscarV(int codProduto) throws ErroDeNegocioExcecao{
		Vestimenta result = this.repositorioV.buscarV(codProduto);
		return result;
	}
	
	public void removerV(int codProduto) throws ErroDeNegocioExcecao{
		Vestimenta v = this.repositorioV.buscarV(codProduto);
		if(v != null){
			this.repositorioV.removerV(codProduto);
		} else{
			throw new ErroDeNegocioExcecao("Alimento não existente");
		}
	}
	
	public ArrayList<Vestimenta> listarRoupas() throws ErroDeNegocioExcecao{
		return this.repositorioV.listarRoupas();
	}
}
