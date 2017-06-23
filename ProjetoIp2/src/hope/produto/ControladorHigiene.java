package hope.produto;

import java.util.Random;
import java.util.Scanner;

public class ControladorHigiene {
	
	private RepositorioHigiene repositorioH;
	
	public ControladorHigiene() {
		this.repositorioH = new RepositorioHigiene(null, 100);
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
		
		Higiene higiene = new Higiene(tipo, quantidade, nome, codigoProduto, descricao);
		repositorioH.cadastrar(higiene);
		System.out.println(higiene.toString()+"\n\tDoacao de produto de higiene cadastrado!\n");
		return;		
		
		}
	
		public void buscarHig() {
			System.out.println("Digite o codigo do produto:");
			int codigoProduto  = leitura.nextInt();
	
			System.out.println(repositorioH.buscarHig(codigoProduto));
			return;
	}
	
		public void removerHigiene() {
			System.out.println("Digite o codigo do produto que deseja remover: ");
			int codigoProduto = leitura.nextInt();
		
			System.out.println(repositorioH.removerHigiene(codigoProduto));
			return;
	}
		
		public void atualizarHigiene() {
			System.out.println("Digite o codigo do produto que deseja alterar: ");
			int codigoProduto = leitura.nextInt();
			if(repositorioH.consultarExistenciaH(codigoProduto) == false){
				System.out.println("O produto não existente!");
				return;
			}
			
			//Esse construtor aqui ta dando erro! Aí coloquei essa sugestão de eclipse
			Higiene novoProdHigiene = new Higiene(null, codigoProduto, null, codigoProduto, null);
			novoProdHigiene.setCodigoProduto(codigoProduto);
			novoProdHigiene.setCodigoProduto(repositorioH.getHigieneArray()[repositorioH.retornarPosicaoH(codigoProduto)].getCodigoProduto());
			
			System.out.println("Digite o tipo do produto a ser alterado: ");
			String novoTipo = leitura.next();
			repositorioH.getHigieneArray()[repositorioH.retornarPosicaoH(codigoProduto)].setTipo(novoTipo);
			
			System.out.println("Digite o nome do produto a ser alterado: ");
			String novoNome = leitura.next();
			repositorioH.getHigieneArray()[repositorioH.retornarPosicaoH(codigoProduto)].setNome(novoNome);
			
			System.out.println("Digite a quantidade do produto a ser alterado: ");
			int novaQuantidade = leitura.nextInt();
			repositorioH.getHigieneArray()[repositorioH.retornarPosicaoH(codigoProduto)].setQuantidade(novaQuantidade);
		
			System.out.println("Digite a validade do produto a ser alterado: ");
			String novaDescricao = leitura.nextLine();
			repositorioH.getHigieneArray()[repositorioH.retornarPosicaoH(codigoProduto)].setDescricao(novaDescricao);
			
			return;
		}
		
		public void listarHigiene() {
			System.out.println(repositorioH.listarHigiene());
			return;
		}

}
