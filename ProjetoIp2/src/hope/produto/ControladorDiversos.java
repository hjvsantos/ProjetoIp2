package hope.produto;

import java.util.Random;
import java.util.Scanner;

public class ControladorDiversos {
	
private RepositorioDiversos repositorioD;
	
	public ControladorDiversos() {
		this.repositorioD = new RepositorioDiversos(100, null);
	}
	Scanner leitura = new Scanner(System.in);

	public void cadastrar() {
		System.out.println("Informe o tipo do produto: ");
		String tipo = leitura.nextLine();
		while(tipo.equals(null)){
			System.out.println("Digite um tipo valido: ");
			tipo = leitura.nextLine();
			leitura.nextLine();
		}
		
		System.out.println("Informe o nome do produto: ");
		String nome = leitura.nextLine();
		while(nome.equals(null)){
			System.out.println("Digite um nome valido: ");
			nome = leitura.nextLine();
			leitura.nextLine();
		}
		
		System.out.println("Informe a quantidade do produto: ");
		int quantidade = leitura.nextInt();
		while(quantidade <= 0){
			System.out.println("Digite uma quantidade valida: ");
			nome = leitura.nextLine();
			leitura.nextLine();
		}
		
		System.out.println("Informe uma descricao para o produto: ");
		String descricao = leitura.nextLine();
		while(descricao == null){
			System.out.println("Digite uma data valida: ");
			descricao = leitura.nextLine();
			leitura.nextInt();
		}
		
		Random random = new Random();
		int codigoProduto = random.nextInt(100);
		
		Diversos diverso = new Diversos(tipo, quantidade, nome, codigoProduto, descricao);
		repositorioD.cadastrarDiv(diverso);
		System.out.println(diverso.toString()+"\n\tDoacao de 'produtos diversos' cadastrado!\n");
		return;		
		}
	
		public void buscarDiv() {
			System.out.println("Digite o codigo do produto:");
			int codigoProduto  = leitura.nextInt();
	
			System.out.println(repositorioD.buscarDiv(codigoProduto));
			return;
	}
	
		public void removerDiv() {
			System.out.println("Digite o codigo do produto que deseja remover: ");
			int codigoProduto = leitura.nextInt();
		
			System.out.println(repositorioD.removerDiv(codigoProduto));
			return;
	}
		
		public void atualizarDiv() {
			System.out.println("Digite o codigo do produto que deseja alterar: ");
			int codigoProduto = leitura.nextInt();
			if(repositorioD.consultarExistenciaD(codigoProduto) == false){
				System.out.println("O produto não existente!");
				return;
			}
			
			//Esse construtor aqui ta dando erro! Aí coloquei essa sugestão de eclipse
			Diversos novoProdDiverso = new Diversos(null, codigoProduto, null, codigoProduto, null);
			novoProdDiverso.setCodigoProduto(codigoProduto);
			novoProdDiverso.setCodigoProduto(repositorioD.getDiversosArray()[repositorioD.retornarPosicaoD(codigoProduto)].getCodigoProduto());
			
			System.out.println("Digite o tipo do produto a ser alterado: ");
			String novoTipo = leitura.next();
			repositorioD.getDiversosArray()[repositorioD.retornarPosicaoD(codigoProduto)].setTipo(novoTipo);
			
			System.out.println("Digite o nome do produto a ser alterado: ");
			String novoNome = leitura.next();
			repositorioD.getDiversosArray()[repositorioD.retornarPosicaoD(codigoProduto)].setNome(novoNome);
			
			System.out.println("Digite a quantidade do produto a ser alterado: ");
			int novaQuantidade = leitura.nextInt();
			repositorioD.getDiversosArray()[repositorioD.retornarPosicaoD(codigoProduto)].setQuantidade(novaQuantidade);
		
			System.out.println("Digite a validade do produto a ser alterado: ");
			String novaDescricao = leitura.nextLine();
			repositorioD.getDiversosArray()[repositorioD.retornarPosicaoD(codigoProduto)].setDescricao(novaDescricao);
			
			return;
		}
		
		public void listarDiv() {
			System.out.println(repositorioD.listarDiv());
			return;
		}
}
