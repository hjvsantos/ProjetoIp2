package hope.produto;

public interface IRepositorioVestimenta {

	public boolean cadastrar(Vestimenta roupa);
	
	public boolean atualizar(Vestimenta roupa);
	
	public Vestimenta buscarVest(int codigo);
	
	public boolean remover(int codigo);
	
	public boolean consultarExistenciaV(int codigo);
	
	public int retornarPosicaoV(int codigo);
	
	public String listar();
}
