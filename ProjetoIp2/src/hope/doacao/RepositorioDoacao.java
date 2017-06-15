package hope.doacao;

public class RepositorioDoacao {

	private Doacao[] doacaoArray;
	private int quantDoacao = 0;
	
	public RepositorioDoacao(Doacao[] doacaoArray, int quantDoacao) {
		super();
		this.doacaoArray = new Doacao[100];
		this.quantDoacao = quantDoacao;
	}

	public Doacao[] getDoacaoArray(int codigo) {
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
				if(doacao.getCodigo() == doacaoArray[i].getCodigo()){
					return false;
				}
			}
			if(quantDoacao < doacaoArray.length -1){
				doacaoArray[quantDoacao] = doacao;
				quantDoacao = quantDoacao +1;
				return true;
			}
		}
		this.doacaoArray[this.quantDoacao] = doacao;
		this.quantDoacao = this.quantDoacao +1;
		return true;
	}
	
	public Doacao buscarDoacao(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantDoacao)){
				if(codigo == this.doacaoArray[t].getCodigo()){
					find = true;
				}else {
					t++;
				}
		 }
				Doacao resultado = null;
				if(t != this.quantDoacao){
					resultado = this.doacaoArray[t];
				}
				return resultado;
		}	
	
	public boolean atualizarDoacao(Doacao novaDoacao){
		for(int i = 0; i < quantDoacao; i++){
			if(doacaoArray[i].getCodigo() == novaDoacao.getCodigo()){
				doacaoArray[i] = novaDoacao;
				return true;
			}
		}
		return false;
	}
	
	public boolean removerDoacao(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantDoacao)){
			if(codigo == this.doacaoArray[i].getCodigo()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantDoacao){
			this.doacaoArray[i] = this.doacaoArray[this.quantDoacao - 1];
			this.doacaoArray[this.quantDoacao - 1] = null;
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
			listaFinal += "\n Informacoes das doações:\n Doador: " + doacaoArray[f].getDoador()+ "\n Beneficiado: " 
		+ doacaoArray[f].getCodInstituicao() + "\n Doação: " + doacaoArray[f].getCodigo();}
		return listaFinal;
	}
	
}
