package hope.produto;

public class RepositorioDiversos implements IRepositorioDiversos {

	private int quantidade;
	private Diversos[] diversosArray;
	
	public RepositorioDiversos(int quantidade, Diversos[] diversosArray) {
		this.quantidade = quantidade;
		this.diversosArray = new Diversos[100];
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public Diversos[] getDiversosArray() {
		return diversosArray;
	}
	
	public boolean cadastrarDiv(Diversos variedade){
		if(variedade.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantidade; i++){
				if(variedade.getCodigoProduto() == diversosArray[i].getCodigoProduto()){
					return false;
				}
			}
			if(quantidade < diversosArray.length -1){
				diversosArray[quantidade] = variedade;
				quantidade = quantidade +1;
				return true;
			}
		}
		this.diversosArray[this.quantidade] = variedade;
		this.quantidade = this.quantidade +1;
		return true;
	}
	
	public boolean atualizarDiv(Diversos variedade ){
		for(int i = 0; i < quantidade; i++){
			if(diversosArray[i].getCodigoProduto() == variedade.getCodigoProduto()){
				diversosArray[i] = variedade;
				return true;
			}
		}
		return false;
	}
	
	public Diversos buscarDiv(int codigo){
		 int d = 0;
		 boolean find = false;
		 while ((!find) && (d < this.quantidade)){
				if(codigo == this.diversosArray[d].getCodigoProduto()){
					find = true;
				}else {
					d++;
				}
		 }
				Diversos resultado = null;
				if(d != this.quantidade){
					resultado = this.diversosArray[d];
				}
				return resultado;
		}
	
	public boolean removerDiv(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantidade)){
			if(codigo == this.diversosArray[i].getCodigoProduto()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantidade){
			this.diversosArray[i] = this.diversosArray[this.quantidade - 1];
			this.diversosArray[this.quantidade - 1] = null;
			this.quantidade = this.quantidade -1;
			System.out.println("Produto: " + codigo + "removido!");
			return true;
		}
		else {
			System.out.println("Doador nao encontrado");
			return false;
		}
	}
	
	public String listarDiv(){
		String listaFinal = "";
		for(int i = 0; i < quantidade; i++){
			listaFinal += "\n Informacoes dos doadores:\n Nome: " + diversosArray[i].getNome() + "\n Codigo do Produto: " 
		+ diversosArray[i].getCodigoProduto() + "\n Tipo: " + diversosArray[i].getTipo() + "\n Quantidade: " 
					+ diversosArray[i].getQuantidade();}
		return listaFinal;
	}	
}
	

