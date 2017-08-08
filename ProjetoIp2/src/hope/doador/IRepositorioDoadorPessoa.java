package hope.doador;

import java.util.ArrayList;

public interface IRepositorioDoadorPessoa {
	
	public boolean cadastrarDoadorPessoa(DoadorPessoa doadorPessoa);
	
	public DoadorPessoa buscarDoadorPessoa(int codigo);
	
	
	public boolean removerDoadorPessoa(int codigo);
	
	public ArrayList<DoadorPessoa> listar();

}
