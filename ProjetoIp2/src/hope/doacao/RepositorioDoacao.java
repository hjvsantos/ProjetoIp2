package hope.doacao;

import java.util.ArrayList;

public class RepositorioDoacao implements IRepositorioDoacao {

	private ArrayList<Doacao> doacaoArray = new ArrayList<Doacao>();
	private int quantDoacao = 0;
	
	public RepositorioDoacao(Doacao[] doacaoArray, int quantDoacao) {
		super();
		this.doacaoArray = new ArrayList<Doacao>();
		this.quantDoacao = quantDoacao;
	}

	public ArrayList<Doacao> getDoacaoArray(int codigo) {
		return doacaoArray;
	}

	public int getQuantDoacao() {
		return quantDoacao;
	}
	
	public boolean cadastrarDoacao(Doacao doacao){
		if(doacao.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantDoacao; i++){
				if(doacao.getCodigo() == doacaoArray.get(i).getCodigo()){
					return false;
				}
			}
			if(quantDoacao < doacaoArray.size() -1){
				doacaoArray.add(doacao);
				quantDoacao = quantDoacao +1;
				return true;
			}
		}
		doacaoArray.add(doacao);
		this.quantDoacao = this.quantDoacao +1;
		return true;
	}
	
	public boolean consultarExistencia(int codo) {
		for (int i = 0; i < quantDoacao; i++) {
			if (codo == doacaoArray.get(i).getCodigo()) {
				return true;
			}
		}
		return false;
	}
	
	public Doacao buscarDoacao(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantDoacao)){
				if(codigo == doacaoArray.get(t).getCodigo()){
					find = true;
				}else {
					t++;
				}
		 }
				Doacao resultado = null;
				if(t != this.quantDoacao){
					resultado = doacaoArray.get(t);
				}
				return resultado;
		}	
	
	public boolean atualizarDoacao(Doacao novaDoacao){
		for(int i = 0; i < quantDoacao; i++){
			if(doacaoArray.get(i).getCodigo() == novaDoacao.getCodigo()){
				doacaoArray.set(i, novaDoacao);
				return true;
			}
		}
		return false;
	}
	
	public boolean removerDoacao(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantDoacao)){
			if(codigo == doacaoArray.get(i).getCodigo()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantDoacao){
			doacaoArray.set((this.quantDoacao - 1), doacaoArray.get(i));
			doacaoArray.remove(this.quantDoacao - 1);
			this.quantDoacao = this.quantDoacao -1;
			System.out.println("Doação: " + codigo + "removida!");
			return true;
		}
		else {
			System.out.println("Doador não encontrado");
			return false;
		}
		
	}
	
	public String listarDoacoes(){
		String listaFinal = "";
		for(int f = 0; f < quantDoacao; f++){
			listaFinal += "\n Informacoes das doações:\n Doador: " + doacaoArray.get(f).getDoador()+ "\n Beneficiado: " 
		+ doacaoArray.get(f).getCodInstituicao() + "\n Doação: " + doacaoArray.get(f).getCodigo();}
		return listaFinal;
	}
	
}