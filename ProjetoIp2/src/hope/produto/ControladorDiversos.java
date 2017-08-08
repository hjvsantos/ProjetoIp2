package hope.produto;

import hope.excecao.ErroDeNegocioExcecao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ControladorDiversos {
	
private RepositorioDiversos repositorioD;
private static ControladorDiversos instance;

public ControladorDiversos() {
	this.repositorioD = RepositorioDiversos.getInstance();
}

public static ControladorDiversos getInstance(){
	if(instance == null){
		instance = new ControladorDiversos();
	}
	return instance;
}

private boolean existe(int codProduto){
	ArrayList<Diversos> resultado = this.repositorioD.listarDiversos();
	for(Diversos d : resultado){
		if(d.getCodigoProduto() == codProduto){
			return true;
		}
	}
	return false;
}

public void cadastrarD(Diversos diversos) throws ErroDeNegocioExcecao{
	if(diversos != null && !this.existe(diversos.getCodigoProduto())){
		this.repositorioD.cadastrarD(diversos);
	} else{
		throw new ErroDeNegocioExcecao("Poduto diverso cadastrado com sucesso");
	}
}

public void atualizarDiversos(Diversos diversos) throws ErroDeNegocioExcecao{
	if(diversos != null && !this.existe(diversos.getCodigoProduto())){
		this.repositorioD.atualizarDiversos(diversos);
	} else{
		throw new ErroDeNegocioExcecao("Produto não localizado");
	}
}

public Diversos buscarD(int codProduto) throws ErroDeNegocioExcecao{
	Diversos result = this.repositorioD.buscarDiversos(codProduto);
	return result;
}

public void removerD(int codProduto) throws ErroDeNegocioExcecao{
	Diversos d = this.repositorioD.buscarDiversos(codProduto);
	if(d != null){
		this.repositorioD.removerDiversos(codProduto);
	} else{
		throw new ErroDeNegocioExcecao("Produto inexistente");
	}
}
}
