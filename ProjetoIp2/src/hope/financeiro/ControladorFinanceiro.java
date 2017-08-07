package hope.financeiro;
import hope.excecao.*;
import java.util.ArrayList;
//teste
public class ControladorFinanceiro {
	
	private RepositorioFinanceiro repositorioF;
	private static ControladorFinanceiro instance;
	
	public ControladorFinanceiro() {
		this.repositorioF = RepositorioFinanceiro.getInstance();
	}
	
	public static ControladorFinanceiro getInstance(){
		if(instance == null){
			instance = new ControladorFinanceiro();
		}
		return instance;
	}
	
	private boolean existe(int codOperacao){
		ArrayList<Financeiro> resultado = this.repositorioF.listarDoacoesFinanceiras();
		for(Financeiro teste : resultado){
			if(teste.getCodOperacao() == codOperacao){
				return true;
			}
		}
		return false;
	}
	
	public void cadastrar(Financeiro doacaoDinheiro)throws ErroDeNegocioExcecao{
		if(doacaoDinheiro != null && !this.existe(doacaoDinheiro.getCodOperacao())){
			this.repositorioF.cadastrar(doacaoDinheiro);
		} else{
			//Podemos fazer outros throws aqui, validando o pq que n realizou
			throw new ErroDeNegocioExcecao("Doação nao realizada!");
		}
	}
		
		public void atualizarF(Financeiro novaDoacao) throws ErroDeNegocioExcecao{
			if(novaDoacao != null && this.existe(novaDoacao.getCodOperacao())){
				this.repositorioF.atualizarF(novaDoacao);
			} else{
				throw new ErroDeNegocioExcecao("Instituição não encontrada!");
			}
		}
		
		public Financeiro buscarDoacaoFinanceira(int codOperacao) throws ErroDeNegocioExcecao{
			Financeiro result = this.repositorioF.buscarDoacaoFinanceira(codOperacao);
			return result;
		}
		
		public void removerDoacaoFinanceira(int codOperacao) throws ErroDeNegocioExcecao{
			Financeiro fina = this.repositorioF.buscarDoacaoFinanceira(codOperacao);
			if(fina != null){
				this.repositorioF.removerDoacaoDinheiro(codOperacao);
			} else{
				throw new ErroDeNegocioExcecao("Codigo de operação financeira não existe!");
			}
		}
}


