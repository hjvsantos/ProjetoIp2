package hope.doacao;

import hope.categoria.Categoria;
import hope.instituicao.Instituicao;

import java.util.Random;
import java.util.Scanner;

public class ControladorDoacao {

private RepositorioDoacao repositorio;

public ControladorDoacao(RepositorioDoacao repositorio) {
	this.repositorio = repositorio;
}
	
Scanner leitura = new Scanner(System.in);

public void cadastrarDoacao() {
		System.out.println("Informe a categoria da doação:");
		String categoria = leitura.next();
		System.out.println("Informe a quantidade:");
		int quantidade = leitura.nextInt();
		Random random = new Random();
		int codDoacao = random.nextInt(100);
		
		Doacao doacao = new Doacao(categoria, null, null, 0, 0, codDoacao);
	}
	
public void buscarDoacao() {
	System.out.println("Digite o codigo da doação:");
	int codigo  = leitura.nextInt();

	System.out.println(repositorio.buscarDoacao(codigo));
	return;
}

public void removerDoacao() {
	System.out.println("Digite o codigo da doação: ");
	int codigo  = leitura.nextInt();
	
	System.out.println(repositorio.removerDoacao(codigo));
	return;
}

public void listarDoacao() {
	System.out.println(repositorio.listarDoacoes());
	return;
}

}
