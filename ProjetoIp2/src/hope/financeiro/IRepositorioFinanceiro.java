package hope.financeiro;

public interface IRepositorioFinanceiro {

	public boolean cadastrar(Financeiro doacaoDinheiro);
	
	public boolean atualizar(Financeiro doacaoDinheiro);
	
	public Financeiro buscarDoadorDinhehiro(String codDoador);
	
	public boolean removerDoacaoDinheiro(String codOperacao);
	
	public String listarDoadoresFinanceiros();
}
