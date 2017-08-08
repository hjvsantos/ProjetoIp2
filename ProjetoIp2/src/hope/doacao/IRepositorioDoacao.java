package hope.doacao;

import java.util.ArrayList;

public interface IRepositorioDoacao {

	public boolean cadastrarDoacao(Doacao doacao);
	
	public Doacao buscarDoacao(int codProduto);
	
	public boolean removerDoacao(int codProduto);
	
	public ArrayList<Doacao> listarDoacoes();
}

