package hope.instituicao;

public interface IRepositorioInstituicao {
	
	public boolean cadastrarI(Instituicao insti);
	
	public Instituicao buscarI(String cnpj);
	
	public boolean removerInstituicao(String cnpj);
	
	public boolean atualizarInstituicao(Instituicao novaInsti);
	
	public String listarInstituicoes();

}