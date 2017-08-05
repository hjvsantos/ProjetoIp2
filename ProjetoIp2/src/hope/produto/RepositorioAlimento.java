package hope.produto;

import java.util.ArrayList;

public class RepositorioAlimento implements IRepositorioAlimento{
	ArrayList<Alimento> alimentoArray = new ArrayList<Alimento>();
	private int quantAlimento = 0;
	
	public RepositorioAlimento(Alimento[] alimento, int quantAlimento) {
		super();
		this.alimentoArray =  new ArrayList<Alimento>();
		this.quantAlimento = quantAlimento;
	}
	
	public ArrayList<Alimento> getAlimentoArray() {
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
				if(alimento.getCodigoProduto() == alimentoArray.get(i).getCodigoProduto()){
					return false;
				}
			}
			if(quantAlimento < alimentoArray.size() -1){
				alimentoArray.add(alimento);
				quantAlimento = quantAlimento +1;
				return true;
			}
		}
		return true;
	}
	
	public boolean atualizarAlimento(Alimento alimento){
		for(int i = 0; i < quantAlimento; i++){
			if(alimentoArray.get(i).getCodigoProduto() == alimento.getCodigoProduto()){
				alimentoArray.set(i, alimento);
				return true;
			}
		}
		return false;
	}
	
	public Alimento buscarAlimento(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantAlimento)){
				if(codigo == alimentoArray.get(t).getCodigoProduto()){
					find = true;
				}else {
					t++;
				}
		 }
				Alimento resultado = null;
				if(t != this.quantAlimento){
					resultado =alimentoArray.get(t);
				}
				return resultado;
		}
	
	public boolean removerAlimento(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantAlimento)){
			if(codigo == alimentoArray.get(i).getCodigoProduto()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantAlimento){
			alimentoArray.set((this.quantAlimento-1), alimentoArray.get(i));
			alimentoArray.remove(this.quantAlimento-1);
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
			if (codigoProduto == alimentoArray.get(i).getCodigoProduto()) {
				return true;
			}
		}
		return false;
	}

	public int retornarPosicaoA(int codigoProduto) {
		int pos = 0;
		for (int i = 0; i < quantAlimento; i++) {
			if (codigoProduto == alimentoArray.get(i).getCodigoProduto()) {
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
			listaFinal += "\n Informacoes dos Alimentos:\n Nome: " + alimentoArray.get(i).getNome() + "\n Codigo do Produto: " 
		+ alimentoArray.get(i).getCodigoProduto() + "\n Tipo: " + alimentoArray.get(i).getTipo() + "\n Quantidade: " 
					+ alimentoArray.get(i).getQuantidade() + "\n Validade: " + alimentoArray.get(i).getValidade();}
		return listaFinal;
	}
}
