package hope.produto;

import java.util.ArrayList;

public interface IRepositorioVestimenta {

	public boolean cadastrarV(Vestimenta roupa);
	
	public boolean atualizarV(Vestimenta roupa);
	
	public Vestimenta buscarV(int codProduto);
	
	public boolean removerV(int codProduto);
	
	public ArrayList<Vestimenta> listarRoupas();
}
