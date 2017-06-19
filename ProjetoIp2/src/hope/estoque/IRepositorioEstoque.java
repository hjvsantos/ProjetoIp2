package hope.estoque;

public interface IRepositorioEstoque {
	
	public boolean inserir(Estoque estoque);
	
	public boolean atualizar(Estoque estoque);
	
	public Estoque buscarEstoque(int codigo);
	
	public boolean remover(int codigo);
	
	public String listarEstoque();

}
