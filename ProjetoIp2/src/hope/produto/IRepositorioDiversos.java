package hope.produto;

public interface IRepositorioDiversos {
	
	public boolean cadastrarDiv(Diversos div);
	
	public boolean atualizarDiv(Diversos div);
	
	public Diversos buscarDiv(int codigo);
	
	public boolean removerDiv(int codigo);
	
	public String listarDiv();
	
}
