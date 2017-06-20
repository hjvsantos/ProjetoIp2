package hope.financeiro;

public class RepositorioFinanceiro implements IRepositorioFinanceiro{
	
	private Financeiro[] financeiroArray;
	private int quantDoacoesDinheiro = 0;
	
	public RepositorioFinanceiro(Financeiro[] financeiroArray, int quantDoacoesDinheiro) {
		this.financeiroArray = new Financeiro[100];
		this.quantDoacoesDinheiro = quantDoacoesDinheiro;
	}
	
	public Financeiro[] getFinanceiroArray() {
		return financeiroArray;
	}

	public int getQuantDoacoesDinheiro() {
		return quantDoacoesDinheiro;
	}

	public boolean cadastrar(Financeiro doacaoDinheiro){
		if(doacaoDinheiro.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantDoacoesDinheiro; i++){
				if(doacaoDinheiro.getCodDoador() == financeiroArray[i].getCodDoador()){
					return false;
				}
			}
			if(quantDoacoesDinheiro < financeiroArray.length -1){
				financeiroArray[quantDoacoesDinheiro] = doacaoDinheiro;
				quantDoacoesDinheiro = quantDoacoesDinheiro +1;
				return true;
			}
		}
		this.financeiroArray[this.quantDoacoesDinheiro] = doacaoDinheiro;
		this.quantDoacoesDinheiro = this.quantDoacoesDinheiro +1;
		return true;
	}
	
	public boolean atualizar(Financeiro doacaoDinheiro){
		for(int i = 0; i < quantDoacoesDinheiro; i++){
			if(financeiroArray[i].getCodDoador() == doacaoDinheiro.getCodDoador()){
				financeiroArray[i] = doacaoDinheiro;
				return true;
			}
		}
		return false;
	}
	
	public Financeiro buscarDoadorDinhehiro(String codDoador){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantDoacoesDinheiro)){
				if(codDoador.equals(this.financeiroArray[t].getCodDoador())){
					find = true;
				}else {
					t++;
				}
		 }
				Financeiro resultado = null;
				if(t != this.quantDoacoesDinheiro){
					resultado = this.financeiroArray[t];
				}
				return resultado;
		}
	
	public boolean removerDoacaoDinheiro(String codOperacao){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantDoacoesDinheiro)){
			if(codOperacao.equals(this.financeiroArray[i].getCodOperacao())){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantDoacoesDinheiro){
			this.financeiroArray[i] = this.financeiroArray[this.quantDoacoesDinheiro - 1];
			this.financeiroArray[this.quantDoacoesDinheiro - 1] = null;
			this.quantDoacoesDinheiro = this.quantDoacoesDinheiro -1;
			System.out.println("Alimento: " + codOperacao + "removido!");
			return true;
		}
		else {
			System.out.println("Doação financeira nao encontrada!");
			return false;
		}
	}
	
	public String listarDoadoresFinanceiros(){
		String listaFinal = "";
		for(int i = 0; i < quantDoacoesDinheiro; i++){
			listaFinal += "\n Informacoes da Doacao financeira:\n Conta de origem: " + financeiroArray[i].getContaOrigem() 
					+ "\n Conta de destino: " + financeiroArray[i].getContaDestino() + "\n Codigo da operacao: " 
					+ financeiroArray[i].getCodOperacao() + "\n Valor da doacao: " + financeiroArray[i].getValor();}
		return listaFinal;
	}

}
