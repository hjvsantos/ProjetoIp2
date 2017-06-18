package hope.doacao;

public interface IRepositorioDoacao {

	public boolean cadastrarDoacao(Doacao doacao);
	
	public Doacao buscarDoacao(int codigoDoacao);
	
	public boolean atualizarDoacao(Doacao novaDoacao);
	
	public boolean removerDoacao(int codigoDoacao);
	
	public String listarDoacoes();
}