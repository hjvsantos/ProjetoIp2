package hope.produto;

import hope.instituicao.Instituicao;

import java.util.ArrayList;

public interface IRepositorioHigiene {
	
	public boolean cadastrarH(Higiene higiene);
	
	public boolean atualizarHigiene(Higiene higiene);
	
	public Higiene buscarHigiene(int codProduto);
	
	public boolean removerHigiene(int codProduto);
	
	public ArrayList<Higiene> listar();
}
