package hope.doador;
//Commitando!
import java.util.ArrayList;

public interface IRepositorioDoadorEmpresa {

	public boolean cadastrarDoadorEmpresa(DoadorEmpresa doadorEmpresa);
	
	public DoadorEmpresa buscarDoadorEmpresa(int codigo);
	
	public boolean atualizarDoadorEmpresa(DoadorEmpresa novoDoador);
	
	public boolean removerDoadorEmpresa(int codigo);
	
	public ArrayList<DoadorEmpresa> listar();
}
