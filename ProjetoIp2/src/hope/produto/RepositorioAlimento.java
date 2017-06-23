package hope.produto;

public class RepositorioAlimento implements IRepositorioAlimento{
	private Alimento[] alimentoArray;
	private int quantAlimento = 0;
	
	public RepositorioAlimento(Alimento[] alimento, int quantAlimento) {
		super();
		this.alimentoArray = new Alimento[100];
		this.quantAlimento = quantAlimento;
	}
	
	public Alimento[] getAlimentoArray() {
		return alimentoArray;
	}

	public int getQuantAlimento() {
		return quantAlimento;
	}
	
	public boolean cadastrar(Alimento alimento){
		if(alimento.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantAlimento; i++){
				if(alimento.getCodigoProduto() == alimentoArray[i].getCodigoProduto()){
					return false;
				}
			}
			if(quantAlimento < alimentoArray.length -1){
				alimentoArray[quantAlimento] = alimento;
				quantAlimento = quantAlimento +1;
				return true;
			}
		}
		this.alimentoArray[this.quantAlimento] = alimento;
		this.quantAlimento= this.quantAlimento +1;
		return true;
	}
	
	public boolean atualizarAlimento(Alimento alimento){
		for(int i = 0; i < quantAlimento; i++){
			if(alimentoArray[i].getCodigoProduto() == alimento.getCodigoProduto()){
				alimentoArray[i] = alimento;
				return true;
			}
		}
		return false;
	}
	
	public Alimento buscarAlimento(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantAlimento)){
				if(codigo == this.alimentoArray[t].getCodigoProduto()){
					find = true;
				}else {
					t++;
				}
		 }
				Alimento resultado = null;
				if(t != this.quantAlimento){
					resultado = this.alimentoArray[t];
				}
				return resultado;
		}
	
	public boolean removerAlimento(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantAlimento)){
			if(codigo == this.alimentoArray[i].getCodigoProduto()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantAlimento){
			this.alimentoArray[i] = this.alimentoArray[this.quantAlimento - 1];
			this.alimentoArray[this.quantAlimento - 1] = null;
			this.quantAlimento = this.quantAlimento -1;
			System.out.println("Alimento: " + codigo + "removido!");
			return true;
		}
		else {
			System.out.println("Alimento nao encontrado!");
			return false;
		}
	}
	
	public boolean consultarExistenciaA(int codigoProduto) {
		for (int i = 0; i < quantAlimento; i++) {
			if (codigoProduto == this.alimentoArray[i].getCodigoProduto()) {
				return true;
			}
		}
		return false;
	}

	public int retornarPosicaoA(int codigoProduto) {
		int pos = 0;
		for (int i = 0; i < quantAlimento; i++) {
			if (codigoProduto == alimentoArray[i].getCodigoProduto()) {
				return pos;
			} else {
				pos++;

			}
		}
		return pos;
	}
	
	public String listarAlimentos(){
		String listaFinal = "";
		for(int i = 0; i < quantAlimento; i++){
			listaFinal += "\n Informacoes dos Alimentos:\n Nome: " + alimentoArray[i].getNome() + "\n Codigo do Produto: " 
		+ alimentoArray[i].getCodigoProduto() + "\n Tipo: " + alimentoArray[i].getTipo() + "\n Quantidade: " 
					+ alimentoArray[i].getQuantidade() + "\n Validade: " + alimentoArray[i].getValidade();}
		return listaFinal;
	}
}
