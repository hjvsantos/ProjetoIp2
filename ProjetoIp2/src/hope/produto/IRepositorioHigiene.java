package hope.produto;

public interface IRepositorioHigiene {
	
	public boolean cadastrar(Higiene higiene);
	
	public boolean atualizarHigiene(Higiene higiene);
	
	public Higiene buscar(int codigo);
	
	public boolean removerHigiene(int codigo);
	
	public String listarHigiene();
}
