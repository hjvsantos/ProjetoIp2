package hope.produto;

import java.util.ArrayList;

public interface IRepositorioAlimento {
	
	public boolean cadastrarA(Alimento alimento);
		
	public Alimento buscarAlimento(int codProduto);
	
	public boolean removerAlimento(int codProduto);
	
	public ArrayList<Alimento> listarAlimentos();
}
