package hope.produto;

public interface IRepositorioVestimenta {

	public boolean cadastrar(Vestimenta roupa);
	
	public boolean atualizar(Vestimenta roupa);
	
	public Vestimenta buscar(int codigo);
	
	public boolean remover(int codigo);
	
	public String listar();
}
