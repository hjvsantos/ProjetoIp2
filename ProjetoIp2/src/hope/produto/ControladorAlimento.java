package hope.produto;

import java.util.Random;
import java.util.Scanner;

public class ControladorAlimento {
	
private RepositorioAlimento repositorioA;
	
	public ControladorAlimento() {
		this.repositorioA = new RepositorioAlimento(null, 100);
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
		
		System.out.println("Informe a data de validade do produto: ");
		int validade = leitura.nextInt();
		//Ajustar isso aqui depois pro formato de data
		while(validade == 0){
			System.out.println("Digite uma data valida: ");
			validade = leitura.nextInt();
			leitura.nextInt();
		}
		
		Random random = new Random();
		int codigoProduto = random.nextInt(100);
		
		Alimento alimento = new Alimento(tipo, quantidade, nome, codigoProduto, validade);
		repositorioA.cadastrar(alimento);
		System.out.println(alimento.toString()+"\n\tDoacao de alimento cadastrada!\n");
		return;		
		
		}
	
		public void buscarAlimento() {
			System.out.println("Digite o codigo do produto:");
			int codigoProduto  = leitura.nextInt();
	
			System.out.println(repositorioA.buscarAlimento(codigoProduto));
			return;
	}
	
		public void removerAlimento() {
			System.out.println("Digite o codigo do produto que deseja remover: ");
			int codigoProduto = leitura.nextInt();
		
			System.out.println(repositorioA.removerAlimento(codigoProduto));
			return;
	}
		
		public void atualizar() {
			System.out.println("Digite o codigo do produto que deseja alterar: ");
			int codigoProduto = leitura.nextInt();
			if(repositorioA.consultarExistenciaA(codigoProduto) == false){
				System.out.println("O produto não existente!");
				return;
			}
			
			//Esse construtor aqui ta dando erro! Aí coloquei essa sugestão de eclipse
			Vestimenta novaVestimenta = new Vestimenta(null, codigoProduto, null, codigoProduto, null, null, null);
			novaVestimenta.setCodigoProduto(codigoProduto);
			novaVestimenta.setCodigoProduto(repositorioA.getAlimentoArray()[repositorioA.retornarPosicaoA(codigoProduto)].getCodigoProduto());
			
			System.out.println("Digite o tipo do produto a ser alterado: ");
			String novoTipo = leitura.next();
			repositorioA.getAlimentoArray()[repositorioA.retornarPosicaoA(codigoProduto)].setTipo(novoTipo);
			
			System.out.println("Digite o nome do produto a ser alterado: ");
			String novoNome = leitura.next();
			repositorioA.getAlimentoArray()[repositorioA.retornarPosicaoA(codigoProduto)].setNome(novoNome);
			
			System.out.println("Digite a quantidade do produto a ser alterado: ");
			int novaQuantidade = leitura.nextInt();
			repositorioA.getAlimentoArray()[repositorioA.retornarPosicaoA(codigoProduto)].setQuantidade(novaQuantidade);
		
			System.out.println("Digite a validade do produto a ser alterado: ");
			int novaValidade = leitura.nextInt();
			repositorioA.getAlimentoArray()[repositorioA.retornarPosicaoA(codigoProduto)].setValidade(novaValidade);
			
			return;
		}
		
		public void listarAlimentos() {
			System.out.println(repositorioA.listarAlimentos());
			return;
		}

}
