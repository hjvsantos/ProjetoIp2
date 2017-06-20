package hope.doador;

public interface IRepositorioDoadorPessoa {
	
	public boolean cadastrarP(DoadorPessoa doadorPessoa);
	
	public DoadorPessoa buscarP(String cpf);
	
	public boolean atualizarDoadorP(DoadorPessoa novoDoadorP);
	
	public boolean removerDoadorP(String cpf);
	
	public String listarDoadoresP();

}
