package hope.produto;

public class RepositorioVestimenta implements IRepositorioVestimenta{

	private Vestimenta[] roupas;
	private int quantidadeRoupas;
	
	public RepositorioVestimenta(Vestimenta[] roupas, int quantidadeRoupas) {
		this.roupas = roupas;
		this.quantidadeRoupas = quantidadeRoupas;
	}

	public Vestimenta[] getRoupas() {
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
				if(doacoes.getCodigoProduto() == roupas[i].getCodigoProduto()){
					return false;
				}
			}
			if(quantidadeRoupas < roupas.length -1){
				roupas[quantidadeRoupas] = doacoes;
				quantidadeRoupas = quantidadeRoupas +1;
				return true;
			}
		}
		this.roupas[this.quantidadeRoupas] = doacoes;
		this.quantidadeRoupas = this.quantidadeRoupas +1;
		return true;
	}
	
	public boolean atualizar(Vestimenta doacoes ){
		for(int i = 0; i < quantidadeRoupas; i++){
			if(roupas[i].getCodigoProduto() == doacoes.getCodigoProduto()){
				roupas[i] = doacoes;
				return true;
			}
		}
		return false;
	}
	
	public Vestimenta buscarVest(int codigo){
		 int v = 0;
		 boolean find = false;
		 while ((!find) && (v < this.quantidadeRoupas)){
				if(codigo == this.roupas[v].getCodigoProduto()){
					find = true;
				}else {
					v++;
				}
		 }
		 		Vestimenta resultado = null;
				if(v != this.quantidadeRoupas){
					resultado = this.roupas[v];
				}
				return resultado;
		}
	
	public boolean remover(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantidadeRoupas)){
			if(codigo == this.roupas[i].getCodigoProduto()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantidadeRoupas){
			this.roupas[i] = this.roupas[this.quantidadeRoupas - 1];
			this.roupas[this.quantidadeRoupas - 1] = null;
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
			if (codigo == this.roupas[i].getCodigoProduto()) {
				return true;
			}
		}
		return false;
	}

	public int retornarPosicaoV(int codigo) {
		int pos = 0;
		for (int i = 0; i < quantidadeRoupas; i++) {
			if (codigo == roupas[i].getCodigoProduto()) {
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
			listaFinal += "\n Informacoes dos doadores:\n Nome: " + roupas[i].getNome() + "\n Codigo do Produto: " + roupas[i].getCodigoProduto() + "\n Tipo: " + roupas[i].getTipo() + "\n Quantidade: " + roupas[i].getQuantidade();}
		return listaFinal;
	}	
}

