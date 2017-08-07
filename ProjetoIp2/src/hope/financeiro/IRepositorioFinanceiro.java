package hope.financeiro;
import java.util.ArrayList;
//teste
public interface IRepositorioFinanceiro {

	public boolean cadastrar(Financeiro doacaoDinheiro);
	
	public boolean atualizarF(Financeiro novaDoacao);
	
	public Financeiro buscarDoacaoFinanceira(int codOperacao);
	
	public boolean removerDoacaoDinheiro(int codOperacao);
	
	public ArrayList<Financeiro> listarDoacoesFinanceiras();
}
