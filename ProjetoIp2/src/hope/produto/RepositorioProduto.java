package hope.produto;



public class RepositorioProduto implements IRepositorioProduto{
	private Produto[] produtoArray;
	private int quantProduto = 0;
	
	public RepositorioProduto(Produto[] produto, int quantProduto) {
		super();
		this.produtoArray = new Produto[100];
		this.quantProduto = quantProduto;
	}

	public Produto[] getProdutoArray() {
		return produtoArray;
	}

	public int getQuantProduto() {
		return quantProduto;
	}
	
	public boolean cadastrar(Produto produto){
		if(produto.equals(null)){
			return false;
		}else{
			for(int i = 0; i < this.quantProduto; i++){
				if(produto.getCodigo() == produtoArray[i].getCodigo()){
					return false;
				}
			}
			if(quantProduto < produtoArray.length -1){
				produtoArray[quantProduto] = produto;
				quantProduto = quantProduto +1;
				return true;
			}
		}
		this.produtoArray[this.quantProduto] = produto;
		this.quantProduto = this.quantProduto +1;
		return true;
	}
	
	public boolean atualizarProduto(Produto produto){
		for(int i = 0; i < quantProduto; i++){
			if(produtoArray[i].getCodigo() == produto.getCodigo()){
				produtoArray[i] = produto;
				return true;
			}
		}
		return false;
	}
	
	public Produto buscar(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantProduto)){
				if(codigo == this.produtoArray[t].getCodigo()){
					find = true;
				}else {
					t++;
				}
		 }
				Produto resultado = null;
				if(t != this.quantProduto){
					resultado = this.produtoArray[t];
				}
				return resultado;
		}
	
	public boolean removerProduto(int codigo){
		int i = 0;
		boolean find = false;
		while((!find) && (i < this.quantProduto)){
			if(codigo == this.produtoArray[i].getCodigo()){
				find = true;
			}
			else{
				i++;
			}
		}
		if(i != this.quantProduto){
			this.produtoArray[i] = this.produtoArray[this.quantProduto - 1];
			this.produtoArray[this.quantProduto - 1] = null;
			this.quantProduto = this.quantProduto -1;
			System.out.println("Produto: " + codigo + "removido!");
			return true;
		}
		else {
			System.out.println("Doador n�o encontrado");
			return false;
		}
	}
	
	public String listarProdutos(){
		String listaFinal = "";
		for(int i = 0; i < quantProduto; i++){
			listaFinal += "\n Informacoes dos doadores:\n Nome: " + produtoArray[i].getNome() + "\n Codigo do Produto: " + produtoArray[i].getCodigo() + "\n Tipo: " + produtoArray[i].getTipo() + "\n Quantidade: " + produtoArray[i].getQuantidade();}
		return listaFinal;
	}	
}