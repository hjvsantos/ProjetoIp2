package hope.doador;

public class RepositorioDoadorEmpresa implements IRepositorioDoadorEmpresa{
	
	private DoadorEmpresa[] doadorEArray;
	private int quantDoadorE = 0;
	
	public RepositorioDoadorEmpresa(DoadorEmpresa[] doadorEArray, int quantDoadorE) {
		
		this.doadorEArray = new DoadorEmpresa[100];
		this.quantDoadorE = quantDoadorE;
	}

	public DoadorEmpresa[] getDoadorEArray() {
		return doadorEArray;
	}

	public int getQuantDoadorE() {
		return quantDoadorE;
	}
	
	public boolean cadastrarE(DoadorEmpresa doadorEmpresa){
		if(doadorEmpresa.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantDoadorE; i++){
				if(doadorEmpresa.getCnpj().equals(doadorEArray[i].getCnpj())){
					return false;
				}
			}
			if(quantDoadorE < doadorEArray.length -1){
				doadorEArray[quantDoadorE] = doadorEmpresa;
				quantDoadorE = quantDoadorE +1;
				return true;
			}
		}
		this.doadorEArray[this.quantDoadorE] = doadorEmpresa;
		this.quantDoadorE = this.quantDoadorE +1;
		return true;
	}
	
	public DoadorEmpresa buscarE(String cnpj){
	 int t = 0;
	 boolean find = false;
	 while ((!find) && (t < this.quantDoadorE)){
			if(cnpj.equals(this.doadorEArray[t].getCnpj())){
				find = true;
			}else {
				t++;
			}
	 }
			DoadorEmpresa resultado = null;
			if(t != this.quantDoadorE){
				resultado = this.doadorEArray[t];
			}
			return resultado;
	}
	
	public boolean atualizarDoadorE(DoadorEmpresa novoDoadorE){
		for(int i = 0; i < quantDoadorE; i++){
			if(doadorEArray[i].getCnpj().equals(novoDoadorE.getCnpj())){
				doadorEArray[i] = novoDoadorE;
				return true;
			}
		}
		return false;
	}
	
	public boolean removerDoadorE(String cnpj){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantDoadorE)){
			if(cnpj.equals(this.doadorEArray[i].getCnpj())){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantDoadorE){
			this.doadorEArray[i] = this.doadorEArray[this.quantDoadorE - 1];
			this.doadorEArray[this.quantDoadorE - 1] = null;
			this.quantDoadorE = this.quantDoadorE -1;
			System.out.println("Doador: " + cnpj + "removida!");
			return true;
		}
		else {
			System.out.println("Doador n�o encontrado");
			return false;
		}
	}
	
	public String listarDoadoresE(){
		String listaFinal = "";
		for(int i = 0; i < quantDoadorE; i++){
			listaFinal += "\n Informacoes dos doadores:\n Nome: " + doadorEArray[i].getNome() + "\n Cidade: " 
		+ doadorEArray[i].getCidade() + "\n CNPJ do Doador: " + doadorEArray[i].getCnpj() + "\n Tipo: " 
		+ doadorEArray[i].getType() + "\n Ano de fundacao: " + doadorEArray[i].getAnoFundacao();}
		return listaFinal;
	}

}
