package hope.financeiro;

public interface IRepositorioFinanceiro {

	public boolean cadastrar(Financeiro doacaoDinheiro);
	
	public boolean atualizar(Financeiro doacaoDinheiro);
	
	public Financeiro buscarDoadorDinhehiro(String codDoador);
	
	public boolean removerDoacaoDinheiro(int codOperacao);
	
	public boolean consultarExistenciaF(int codOperacao);
	
	public int retornarPosicaoF(int cod);
	
	public String listarDoacoesFinanceiras();
}
