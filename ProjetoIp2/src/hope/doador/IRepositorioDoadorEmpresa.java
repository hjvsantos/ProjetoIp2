package hope.doador;

import java.util.ArrayList;

public interface IRepositorioDoadorEmpresa {

	public boolean cadastrarDoadorEmpresa(DoadorEmpresa doadorEmpresa);
	
	public DoadorEmpresa buscarDoadorEmpresa(int codigo);
	
	
	public boolean removerDoadorEmpresa(int codigo);
	
	public ArrayList<DoadorEmpresa> listar();
}
