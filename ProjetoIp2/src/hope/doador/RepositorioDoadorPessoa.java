package hope.doador;

public class RepositorioDoadorPessoa implements IRepositorioDoadorPessoa{
	
	private DoadorPessoa[] doadorPArray;
	private int quantDoadorP = 0;
	
	public RepositorioDoadorPessoa(DoadorPessoa[] doadorPArray, int quantDoadorP) {
		
		this.doadorPArray = new DoadorPessoa[100];
		this.quantDoadorP = quantDoadorP;
	}

	public DoadorPessoa[] getDoadorPArray() {
		return doadorPArray;
	}

	public int getQuantDoadorP() {
		return quantDoadorP;
	}
	
	public boolean cadastrarP(DoadorPessoa doadorPessoa){
		if(doadorPessoa.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantDoadorP; i++){
				if(doadorPessoa.getCpf().equals(doadorPArray[i].getCpf())){
					return false;
				}
			}
			if(quantDoadorP < doadorPArray.length -1){
				doadorPArray[quantDoadorP] = doadorPessoa;
				quantDoadorP = quantDoadorP +1;
				return true;
			}
		}
		this.doadorPArray[this.quantDoadorP] = doadorPessoa;
		this.quantDoadorP = this.quantDoadorP +1;
		return true;
	}
	
	public DoadorPessoa buscarP(String cpf){
	 int t = 0;
	 boolean find = false;
	 while ((!find) && (t < this.quantDoadorP)){
			if(cpf.equals(this.doadorPArray[t].getCpf())){
				find = true;
			}else {
				t++;
			}
	 }
			DoadorPessoa resultado = null;
			if(t != this.quantDoadorP){
				resultado = this.doadorPArray[t];
			}
			return resultado;
	}
	
	public boolean atualizarDoadorP(DoadorPessoa novoDoadorP){
		for(int i = 0; i < quantDoadorP; i++){
			if(doadorPArray[i].getCpf().equals(novoDoadorP.getCpf())){
				doadorPArray[i] = novoDoadorP;
				return true;
			}
		}
		return false;
	}
	
	public boolean removerDoadorP(String cpf){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantDoadorP)){
			if(cpf.equals(this.doadorPArray[i].getCpf())){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantDoadorP){
			this.doadorPArray[i] = this.doadorPArray[this.quantDoadorP - 1];
			this.doadorPArray[this.quantDoadorP - 1] = null;
			this.quantDoadorP = this.quantDoadorP -1;
			System.out.println("Doador: " + cpf + "removida!");
			return true;
		}
		else {
			System.out.println("Doador n�o encontrado");
			return false;
		}
	}
	
	public String listarDoadoresP(){
		String listaFinal = "";
		for(int i = 0; i < quantDoadorP; i++){
			listaFinal += "\n Informacoes dos doadores:\n Nome: " + doadorPArray[i].getNome() + "\n Cidade: " 
		+ doadorPArray[i].getCidade() + "\n CPF do Doador: " + doadorPArray[i].getCpf() + "\n Tipo: " 
		+ doadorPArray[i].getTipo() + "\n Idade do doador: " + doadorPArray[i].getIdade();}
		return listaFinal;
	}

}
