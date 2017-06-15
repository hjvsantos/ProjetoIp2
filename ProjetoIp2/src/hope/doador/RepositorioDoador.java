package hope.doador;

public class RepositorioDoador implements IRepositorioDoador {

	private Doador[] doadorArray;
	private int quantDoador = 0;
	
	public RepositorioDoador(Doador[] doadorArray, int quantDoador) {
		
		this.doadorArray = new Doador[100];
		this.quantDoador = quantDoador;
	}

	public Doador[] getDoadorArray() {
		return doadorArray;
	}

	public int getQuantDoador() {
		return quantDoador;
	}
	
	public boolean cadastrar(Doador doador){
		if(doador.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantDoador; i++){
				if(doador.getCodigoDoador() == doadorArray[i].getCodigoDoador()){
					return false;
				}
			}
			if(quantDoador < doadorArray.length -1){
				doadorArray[quantDoador] = doador;
				quantDoador = quantDoador +1;
				return true;
			}
		}
		this.doadorArray[this.quantDoador] = doador;
		this.quantDoador = this.quantDoador +1;
		return true;
	}
	
	public Doador buscar(int codigoDoador){
	 int t = 0;
	 boolean find = false;
	 while ((!find) && (t < this.quantDoador)){
			if(codigoDoador == this.doadorArray[t].getCodigoDoador()){
				find = true;
			}else {
				t++;
			}
	 }
			Doador resultado = null;
			if(t != this.quantDoador){
				resultado = this.doadorArray[t];
			}
			return resultado;
	}
	
	public boolean atualizarDoador(Doador novoDoador){
		for(int i = 0; i < quantDoador; i++){
			if(doadorArray[i].getCodigoDoador() == novoDoador.getCodigoDoador()){
				doadorArray[i] = novoDoador;
				return true;
			}
		}
		return false;
	}
	
	public boolean removerDoador(int codigoDoador){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantDoador)){
			if(codigoDoador == this.doadorArray[i].getCodigoDoador()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantDoador){
			this.doadorArray[i] = this.doadorArray[this.quantDoador - 1];
			this.doadorArray[this.quantDoador - 1] = null;
			this.quantDoador = this.quantDoador -1;
			System.out.println("Doador: " + codigoDoador + "removida!");
			return true;
		}
		else {
			System.out.println("Doador n�o encontrado");
			return false;
		}
	}
	
	public String listarDoadores(){
		String listaFinal = "";
		for(int i = 0; i < quantDoador; i++){
			listaFinal += "\n Informacoes dos doadores:\n Nome: " + doadorArray[i].getNome() + "\n Cidade: " 
		+ doadorArray[i].getCidade() + "\n Codigo do Doador: " + doadorArray[i].getCodigoDoador() + "\n Tipo: " + doadorArray[i].getType();}
		return listaFinal;
	}
}
	


