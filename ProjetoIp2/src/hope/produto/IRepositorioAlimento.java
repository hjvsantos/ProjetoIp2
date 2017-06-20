package hope.produto;

public interface IRepositorioAlimento {
	
	public boolean cadastrar(Alimento alimento);
	
	public boolean atualizarAlimento(Alimento alimento);
	
	public Alimento buscarAlimento(int codigo);
	
	public boolean removerAlimento(int codigo);
	
	public String listarAlimentos();
}
