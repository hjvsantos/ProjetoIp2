package hope.doacao;

import hope.categoria.Categoria;
import hope.excecao.ErroDeNegocioExcecao;
import hope.instituicao.Instituicao;
import hope.produto.Alimento;
import hope.produto.ControladorHigiene;
import hope.produto.Higiene;
import hope.produto.RepositorioHigiene;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ControladorDoacao {

	private RepositorioDoacao repositorioD;
	private static ControladorDoacao instance;
	
	public ControladorDoacao() {
		this.repositorioD = RepositorioDoacao.getInstance();
	}
	
	public static ControladorDoacao getInstance(){
		if(instance == null){
			instance = new ControladorDoacao();
		}
		return instance;
	}
	
	private boolean existe(int codProduto){
		ArrayList<Doacao> resultado = this.repositorioD.listarDoacoes();
		for(Doacao d : resultado){
			if(d.getCodigo() == codProduto){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrarD(Doacao doacao) throws ErroDeNegocioExcecao{
		if(doacao != null && !this.existe(doacao.getCodigo())){
			this.repositorioD.cadastrarDoacao(doacao);
		} else{
			throw new ErroDeNegocioExcecao("Doação cadastrado com sucesso");
		}
	}
	
	
	public Doacao buscarD(int codProduto) throws ErroDeNegocioExcecao{
		Doacao result = this.repositorioD.buscarDoacao(codProduto);
		return result;
	}
	
	public void removerD(int codProduto) throws ErroDeNegocioExcecao{
		Doacao d = this.repositorioD.buscarDoacao(codProduto);
		if(d != null){
			this.repositorioD.removerDoacao(codProduto);
		} else{
			throw new ErroDeNegocioExcecao("Doação inexistente");
		}
	}
	
	public ArrayList<Doacao> listarDoacao() throws ErroDeNegocioExcecao{
		return this.repositorioD.listarDoacoes();
	}

}
