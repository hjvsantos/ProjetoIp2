package hope.produtos;



public class RepositorioProdutos {
	private Produtos[] produtoArray;
	private int quantProduto = 0;
	
	public RepositorioProdutos(Produtos[] produto, int quantProduto) {
		super();
		this.produtoArray = new Produtos[100];
		this.quantProduto = quantProduto;
	}

	public Produtos[] getProdutoArray() {
		return produtoArray;
	}

	public int getQuantProduto() {
		return quantProduto;
	}
	
	public boolean cadastrar(Produtos produto){
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
	
	public boolean atualizarProduto(Produtos produto){
		for(int i = 0; i < quantProduto; i++){
			if(produtoArray[i].getCodigo() == produto.getCodigo()){
				produtoArray[i] = produto;
				return true;
			}
		}
		return false;
	}
	
	public Produtos buscar(int codigo){
		 int t = 0;
		 boolean find = false;
		 while ((!find) && (t < this.quantProduto)){
				if(codigo == this.produtoArray[t].getCodigo()){
					find = true;
				}else {
					t++;
				}
		 }
				Produtos resultado = null;
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
			System.out.println("Doador não encontrado");
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
