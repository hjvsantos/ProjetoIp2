package hope.produto;

import java.util.Random;
import java.util.Scanner;

public class ControladorVestimenta {
	
	private RepositorioVestimenta repositorioV;
	
	public ControladorVestimenta() {
		this.repositorioV = new RepositorioVestimenta(null, 100);
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
		
		System.out.println("Informe o tamanho da roupa: ");
		String tamanho = leitura.nextLine();
		while(tamanho == null){
			System.out.println("Digite uma tamanho valida: ");
			tamanho = leitura.nextLine();
			leitura.nextLine();
		}
		
		System.out.println("Informe a cor da roupa: ");
		String cor = leitura.nextLine();
		while(cor == null){
			System.out.println("Digite uma tamanho valida: ");
			cor = leitura.nextLine();
			leitura.nextLine();
		}
		
		System.out.println("Informe o genero da roupa: ");
		String genero = leitura.nextLine();
		while(genero == null){
			System.out.println("Digite uma tamanho valida: ");
			genero = leitura.nextLine();
			leitura.nextLine();
		}
		
		Random random = new Random();
		int codigoProduto = random.nextInt(100);
		
		Vestimenta roupa = new Vestimenta(tipo, quantidade, nome, codigoProduto, tamanho, cor, genero);
		repositorioV.cadastrar(roupa);
		System.out.println(roupa.toString()+"\n\tDoacao de roupa cadastrada!\n");
		return;		
		
		}
	
		public void buscarVest() {
			System.out.println("Digite o codigo do produto:");
			int codigoProduto  = leitura.nextInt();
	
			System.out.println(repositorioV.buscarVest(codigoProduto));
			return;
	}
	
		public void remover() {
			System.out.println("Digite o codigo do produto que deseja remover: ");
			int codigoProduto = leitura.nextInt();
		
			System.out.println(repositorioV.remover(codigoProduto));
			return;
	}
		
		public void atualizar() {
			System.out.println("Digite o codigo do produto que deseja alterar: ");
			int codigoProduto = leitura.nextInt();
			if(repositorioV.consultarExistenciaV(codigoProduto) == false){
				System.out.println("O produto não existente");
				return;
			}
			
			//Esse construtor aqui ta dando erro! Aí coloquei essa sugestão de eclipse
			Vestimenta novaVestimenta = new Vestimenta(null, codigoProduto, null, codigoProduto, null, null, null);
			novaVestimenta.setCodigoProduto(codigoProduto);
			novaVestimenta.setCodigoProduto(repositorioV.roupas.get(repositorioV.retornarPosicaoV(codigoProduto)).getCodigoProduto());
			
			System.out.println("Digite o tipo do produto a ser alterado: ");
			String novoTipo = leitura.next();
			repositorioV.roupas.get(repositorioV.retornarPosicaoV(codigoProduto)).setTipo(novoTipo);
			
			System.out.println("Digite o nome do produto a ser alterado: ");
			String novoNome = leitura.next();
			repositorioV.roupas.get(repositorioV.retornarPosicaoV(codigoProduto)).setNome(novoNome);
			
			System.out.println("Digite a quantidade do produto a ser alterado: ");
			int novaQuantidade = leitura.nextInt();
			repositorioV.roupas.get(repositorioV.retornarPosicaoV(codigoProduto)).setQuantidade(novaQuantidade);
		
			System.out.println("Digite o tamanho do produto a ser alterado: ");
			String novoTamanho = leitura.next();
			repositorioV.roupas.get(repositorioV.retornarPosicaoV(codigoProduto)).setTamanho(novoTamanho);
			
			System.out.println("Digite a cor do produto a ser alterado: ");
			String novaCor = leitura.next();
			repositorioV.roupas.get(repositorioV.retornarPosicaoV(codigoProduto)).setCor(novaCor);
			
			System.out.println("Digite o genero do produto a ser alterado: ");
			String novoGenero = leitura.next();
			repositorioV.roupas.get(repositorioV.retornarPosicaoV(codigoProduto)).setGenero(novoGenero);
		
			return;
		}
		
		public void listar() {
			System.out.println(repositorioV.listar());
			return;
		}
}
