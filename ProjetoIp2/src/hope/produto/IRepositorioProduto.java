package hope.produto;

public interface IRepositorioProduto {
	
	public boolean cadastrar(Produto produto);
	
	public boolean atualizarProduto(Produto produto);
	
	public Produto buscar(int codigo);
	
	public boolean removerProduto(int codigo);
	
	public String listarProdutos();

}