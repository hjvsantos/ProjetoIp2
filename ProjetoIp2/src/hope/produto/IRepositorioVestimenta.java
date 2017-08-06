package hope.produto;

import java.util.ArrayList;

public interface IRepositorioVestimenta {

	public boolean cadastrar(Vestimenta roupa);
	
	public boolean atualizarVestimenta(Vestimenta roupa);
	
	public Vestimenta buscar(int codProduto);
	
	public boolean remover(int codProduto);
	
	public ArrayList<Vestimenta> listar();
}
