package hope.instituicao;

public interface IRepositorioInstituicao {
	
	public boolean cadastrar(Instituicao insti);
	
	public Instituicao buscar(String cnpj);
	
	public boolean removerInstituicao(String cnpj);
	
	public boolean atualizarInstituicao(Instituicao novaInsti);
	
	public String listarInstituicoes();

}