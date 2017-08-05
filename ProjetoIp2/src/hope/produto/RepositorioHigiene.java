package hope.produto;

import java.util.ArrayList;

public class RepositorioHigiene implements IRepositorioHigiene{
	ArrayList<Higiene> higieneArray = new ArrayList<Higiene> ();
	private int quantHigiene = 0;
	
	public RepositorioHigiene(Higiene[] higieneArray, int quantHigiene) {
		super();
		this.higieneArray = new ArrayList<Higiene> ();
		this.quantHigiene = quantHigiene;
	}
	
	public ArrayList<Higiene> getHigieneArray() {
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
				if(higiene.getCodigoProduto() == higieneArray.get(i).getCodigoProduto()){
					return false;
				}
			}
			if(quantHigiene < higieneArray.size()-1){
				higieneArray.add(higiene);
				quantHigiene = quantHigiene +1;
				return true;
			}
		}
		return true;
	}	
	
	public boolean atualizarHigiene(Higiene higiene){
		for(int i = 0; i < quantHigiene; i++){
			if(higieneArray.get(i).getCodigoProduto() == higiene.getCodigoProduto()){
				higieneArray.set(i, higiene);
				return true;
			}
		}
		return false;
	}
	
	public Higiene buscarHig(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantHigiene)){
				if(codigo == higieneArray.get(t).getCodigoProduto()){
					find = true;
				}else {
					t++;
				}
		 }
				Higiene resultado = null;
				if(t != this.quantHigiene){
					resultado = higieneArray.get(t);
				}
				return resultado;
		}
	
	public boolean removerHigiene(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantHigiene)){
			if(codigo == higieneArray.get(i).getCodigoProduto()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantHigiene){
			
			higieneArray.set((this.quantHigiene - 1), higieneArray.get(i));
			higieneArray.remove(this.quantHigiene - 1);
			this.quantHigiene = this.quantHigiene -1;
			System.out.println("Produto de higiene: " + codigo + "removido!");
			return true;
		}
		else {
			System.out.println("produto nao encontrado!");
			return false;
		}
	}
	
	public boolean consultarExistenciaH(int codigoProduto) {
		for (int i = 0; i < quantHigiene; i++) {
			if (codigoProduto == higieneArray.get(i).getCodigoProduto()) {
				return true;
			}
		}
		return false;
	}

	public int retornarPosicaoH(int codigoProduto) {
		int pos = 0;
		for (int i = 0; i < quantHigiene; i++) {
			if (codigoProduto == higieneArray.get(i).getCodigoProduto()) {
				return pos;
			} else {
				pos++;

			}
		}
		return pos;
	}
	
	public String listarHigiene(){
		String listaFinal = "";
		for(int i = 0; i < quantHigiene; i++){
			listaFinal += "\n Informacoes dos Alimentos:\n Nome: " + higieneArray.get(i).getNome() + "\n Codigo do Produto: " 
		+ higieneArray.get(i).getCodigoProduto() + "\n Tipo: " + higieneArray.get(i).getTipo() + "\n Quantidade: " + higieneArray.get(i).getQuantidade() 
		+ "\n Descri��o:" + higieneArray.get(i).getDescricao();}
		return listaFinal;
	}
	
}
