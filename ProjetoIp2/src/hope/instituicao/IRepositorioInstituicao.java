package hope.instituicao;

public interface IRepositorioInstituicao {
	
	public boolean cadastrarI(Instituicao insti);
	
	public Instituicao buscarI(int codInstituicao);
	
	public boolean removerInstituicao(int codInstituicao);
	
	public boolean atualizarInstituicao(Instituicao novaInsti);
	
	public boolean consultarExistencia(int codInstituicao);
	
	public int retornarPosicao(int codInstituicao);
	
	public String listarInstituicoes();

}