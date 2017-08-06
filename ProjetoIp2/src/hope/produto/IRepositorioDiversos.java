package hope.produto;

import java.util.ArrayList;

public interface IRepositorioDiversos {
	
	public boolean cadastrarD(Diversos div);
	
	public boolean atualizarDiversos(Diversos diversos);
	
	public Diversos buscarDiversos(int codProduto);
	
	public boolean removerDiversos(int codProduto);
	
	public ArrayList<Diversos> listar();
	
}
