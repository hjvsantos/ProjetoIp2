package hope.doador;

public interface IRepositorioDoadorEmpresa {

	public boolean cadastrarE(DoadorEmpresa doadorEmpresa);
	
	public DoadorEmpresa buscarE(String cnpj);
	
	public boolean atualizarDoadorE(DoadorEmpresa novoDoadorE);
	
	public boolean removerDoadorE(String cnpj);
	
	public String listarDoadoresE();
}
