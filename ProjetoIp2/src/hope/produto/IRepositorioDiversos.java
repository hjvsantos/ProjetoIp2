package hope.produto;

public interface IRepositorioDiversos {
	
	public boolean cadastrar(Diversos div);
	
	public boolean atualizar(Diversos div);
	
	public Diversos buscar(int codigo);
	
	public boolean remover(int codigo);
	
	public String listar();
	
}
