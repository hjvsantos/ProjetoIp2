package hope.produto;

import java.util.ArrayList;

public class RepositorioVestimenta implements IRepositorioVestimenta{

	ArrayList<Vestimenta> roupas = new ArrayList<Vestimenta>();
	private int quantidadeRoupas;
	
	public RepositorioVestimenta(Vestimenta[] roupas, int quantidadeRoupas) {
		this.roupas =  new ArrayList<Vestimenta>();
		this.quantidadeRoupas = quantidadeRoupas;
	}

	public ArrayList<Vestimenta> getRoupas() {
		return roupas;
	}

	public int getQuantidadeRoupas() {
		return quantidadeRoupas;
	}
	
	public boolean cadastrar(Vestimenta doacoes){
		if(doacoes.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantidadeRoupas; i++){
				if(doacoes.getCodigoProduto() == roupas.get(i).getCodigoProduto()){
					return false;
				}
			}
			if(quantidadeRoupas < roupas.size() -1){
				roupas.add(doacoes);
				quantidadeRoupas = quantidadeRoupas +1;
				return true;
			}
		}
		
		return true;
	}
	
	public boolean atualizar(Vestimenta doacoes ){
		for(int i = 0; i < quantidadeRoupas; i++){
			if(roupas.get(i).getCodigoProduto() == doacoes.getCodigoProduto()){
				roupas.set(i, doacoes);
				return true;
			}
		}
		return false;
	}
	
	public Vestimenta buscarVest(int codigo){
		 int v = 0;
		 boolean find = false;
		 while ((!find) && (v < this.quantidadeRoupas)){
				if(codigo == roupas.get(v).getCodigoProduto()){
					find = true;
				}else {
					v++;
				}
		 }
		 		Vestimenta resultado = null;
				if(v != this.quantidadeRoupas){
					resultado =roupas.get(v);
				}
				return resultado;
		}
	
	public boolean remover(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantidadeRoupas)){
			if(codigo == roupas.get(i).getCodigoProduto()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantidadeRoupas){
			roupas.set((this.quantidadeRoupas - 1), roupas.get(i));
			roupas.remove(this.quantidadeRoupas - 1);
			this.quantidadeRoupas = this.quantidadeRoupas -1;
			System.out.println("Produto: " + codigo + "removido!");
			return true;
		}
		else {
			System.out.println("Doador nao encontrado");
			return false;
		}
	}
	
	public boolean consultarExistenciaV(int codigo) {
		for (int i = 0; i < quantidadeRoupas; i++) {
			if (codigo == roupas.get(i).getCodigoProduto()) {
				return true;
			}
		}
		return false;
	}

	public int retornarPosicaoV(int codigo) {
		int pos = 0;
		for (int i = 0; i < quantidadeRoupas; i++) {
			if (codigo == roupas.get(i).getCodigoProduto()) {
				return pos;
			} else {
				pos++;

			}
		}
		return pos;
	}
	
	public String listar(){
		String listaFinal = "";
		for(int i = 0; i < quantidadeRoupas; i++){
			listaFinal += "\n Informacoes dos doadores:\n Nome: " + roupas.get(i).getNome() + "\n Codigo do Produto: " + roupas.get(i).getCodigoProduto() + "\n Tipo: " + roupas.get(i).getTipo() + "\n Quantidade: " + roupas.get(i).getQuantidade();}
		return listaFinal;
	}	
}

