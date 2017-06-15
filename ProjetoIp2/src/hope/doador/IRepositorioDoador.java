package hope.doador;

public interface IRepositorioDoador {
	
	public boolean cadastrar(Doador doador);
	
	public Doador buscar(int codigoDoador);
	
	public boolean atualizarDoador(Doador novoDoador);
	
	public boolean removerDoador(int codigoDoador);
	
	public String listarDoadores();

}
