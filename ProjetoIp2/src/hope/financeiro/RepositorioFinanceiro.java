package hope.financeiro;

import java.util.ArrayList;

public class RepositorioFinanceiro implements IRepositorioFinanceiro{
	
	private ArrayList<Financeiro> financeiroArray = new ArrayList<Financeiro>();
	private int quantDoacoesDinheiro;
	
	public RepositorioFinanceiro(Financeiro[] financeiroArray, int quantDoacoesDinheiro) {
		this.financeiroArray = new ArrayList<Financeiro>();
		this.quantDoacoesDinheiro = quantDoacoesDinheiro;
	}
	
	public ArrayList<Financeiro> getFinanceiroArray() {
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
				if(doacaoDinheiro.getCodDoador() == financeiroArray.get(i).getCodDoador()){
					return false;
				}
			}
			if(quantDoacoesDinheiro < financeiroArray.size() -1){
				financeiroArray.add(doacaoDinheiro);
				quantDoacoesDinheiro = quantDoacoesDinheiro +1;
				return true;
			}
		}
		financeiroArray.add(doacaoDinheiro);
		this.quantDoacoesDinheiro = this.quantDoacoesDinheiro +1;
		return true;
	}
	
	public boolean atualizar(Financeiro doacaoDinheiro){
		for(int i = 0; i < quantDoacoesDinheiro; i++){
			if(financeiroArray.get(i).getCodDoador() == doacaoDinheiro.getCodDoador()){
				financeiroArray.set(i, doacaoDinheiro);
				return true;
			}
		}
		return false;
	}
	
	public Financeiro buscarDoadorDinhehiro(String codDoador){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantDoacoesDinheiro)){
				if(codDoador.equals(this.financeiroArray.get(t).getCodDoador())){
					find = true;
				}else {
					t++;
				}
		 }
				Financeiro resultado = null;
				if(t != this.quantDoacoesDinheiro){
					resultado = this.financeiroArray.get(t);
				}
				return resultado;
		}
	
	public boolean removerDoacaoDinheiro(int codOperacao){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantDoacoesDinheiro)){
			if(codOperacao == this.financeiroArray.get(i).getCodOperacao()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantDoacoesDinheiro){
			this.financeiroArray.set((quantDoacoesDinheiro - 1), financeiroArray.get(i));
			this.financeiroArray.remove(this.quantDoacoesDinheiro - 1);
			this.quantDoacoesDinheiro = this.quantDoacoesDinheiro -1;
			System.out.println("Doação financeira: " + codOperacao + "removida!");
			return true;
		}
		else {
			System.out.println("Doação financeira nao encontrada!");
			return false;
		}
	}
	
	
	
	public boolean consultarExistenciaF(int codOperacao) {
		for (int i = 0; i < getQuantDoacoesDinheiro(); i++) {
			if (codOperacao == this.financeiroArray.get(i).getCodOperacao()) {
				return true;
			}
		}
		return false;
	}

	public int retornarPosicaoF(int cod) {
		int pos = 0;
		for (int i = 0; i < getQuantDoacoesDinheiro(); i++) {
			if (cod == financeiroArray.get(i).getCodOperacao()) {
				return pos;
			} else {
				pos++;

			}
		}
		return pos;
	}
	
	public String listarDoacoesFinanceiras(){
		String listaFinal = "";
		for(int i = 0; i < quantDoacoesDinheiro; i++){
			listaFinal += "\n Informacoes da Doacao financeira:\n Conta de origem: " + financeiroArray.get(i).getContaOrigem() 
					+ "\n Conta de destino: " + financeiroArray.get(i).getContaDestino() + "\n Codigo da operacao: " 
					+ financeiroArray.get(i).getCodOperacao() + "\n Valor da doacao: " + financeiroArray.get(i).getValor();}
		return listaFinal;
	}

}
