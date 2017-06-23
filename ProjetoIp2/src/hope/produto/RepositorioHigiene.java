package hope.produto;

public class RepositorioHigiene implements IRepositorioHigiene{
	private Higiene[] higieneArray;
	private int quantHigiene = 0;
	
	public RepositorioHigiene(Higiene[] higieneArray, int quantHigiene) {
		super();
		this.higieneArray = new Higiene[100];
		this.quantHigiene = quantHigiene;
	}
	
	public Higiene[] getHigieneArray() {
		return higieneArray;
	}

	public int getQuantHigiene() {
		return quantHigiene;
	}
	
	public boolean cadastrar(Higiene higiene){
		if(higiene.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantHigiene; i++){
				if(higiene.getCodigoProduto() == higieneArray[i].getCodigoProduto()){
					return false;
				}
			}
			if(quantHigiene < higieneArray.length -1){
				higieneArray[quantHigiene] = higiene;
				quantHigiene = quantHigiene +1;
				return true;
			}
		}
		this.higieneArray[this.quantHigiene] = higiene;
		this.quantHigiene= this.quantHigiene +1;
		return true;
	}	
	
	public boolean atualizarHigiene(Higiene higiene){
		for(int i = 0; i < quantHigiene; i++){
			if(higieneArray[i].getCodigoProduto() == higiene.getCodigoProduto()){
				higieneArray[i] = higiene;
				return true;
			}
		}
		return false;
	}
	
	public Higiene buscarHig(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantHigiene)){
				if(codigo == this.higieneArray[t].getCodigoProduto()){
					find = true;
				}else {
					t++;
				}
		 }
				Higiene resultado = null;
				if(t != this.quantHigiene){
					resultado = this.higieneArray[t];
				}
				return resultado;
		}
	
	public boolean removerHigiene(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantHigiene)){
			if(codigo == this.higieneArray[i].getCodigoProduto()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantHigiene){
			this.higieneArray[i] = this.higieneArray[this.quantHigiene - 1];
			this.higieneArray[this.quantHigiene - 1] = null;
			this.quantHigiene = this.quantHigiene -1;
			System.out.println("Produto de higiene: " + codigo + "removido!");
			return true;
		}
		else {
			System.out.println("produto nao encontrado!");
			return false;
		}
	}
	
	public String listarHigiene(){
		String listaFinal = "";
		for(int i = 0; i < quantHigiene; i++){
			listaFinal += "\n Informacoes dos Alimentos:\n Nome: " + higieneArray[i].getNome() + "\n Codigo do Produto: " 
		+ higieneArray[i].getCodigoProduto() + "\n Tipo: " + higieneArray[i].getTipo() + "\n Quantidade: " + higieneArray[i].getQuantidade() 
		+ "\n Descri��o:" + higieneArray[i].getDescricao();}
		return listaFinal;
	}
	
}
