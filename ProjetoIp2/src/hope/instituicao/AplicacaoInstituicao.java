package hope.instituicao;

import java.util.Scanner;

public class AplicacaoInstituicao {

	public static void main(String[] args) {
		
		Instituicao[] i = new Instituicao[100];
		RepositorioInstituicao meuRep = new RepositorioInstituicao (i, 100);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("Menu de Instituicoes!!! \n");
		
		do{
			System.out.println("Escolha uma das opcoes a seguir:\n 1)Cadastrar instituicao.\n 2)Buscar instituicao.\n 3)Remover instituicao.\n" +
					" 4)Atualizar dados da instituicao.\n 5)Listar todas as instituicoes cadastrados.\n 6)Sair.");
				opcao = scanner.nextInt();
				scanner.nextLine();
				double numConta;
		
			switch(opcao){
			case 1:
					System.out.println("Informe o CNPJ da instituicao: ");
					String cnpj = scanner.nextLine();
					while(cnpj.equals(null)){
						System.out.println("Digite um nome valido: ");
						cnpj = scanner.nextLine();
						scanner.nextLine();
				
					System.out.println("Informe o nome da instituicao: ");
					String nome = scanner.nextLine();
					while(nome.equals(null)){
						System.out.println("Digite um nome valido: ");
						nome = scanner.nextLine();
						scanner.nextLine();
					}
					System.out.println("Informe a cidade da instituicao: ");
					String cidade = scanner.nextLine();
					while(cidade.equals(null)){
						System.out.println("Digite um nome de cidade valido: ");
						cidade = scanner.nextLine();
					}		
					System.out.println("Informe o estado da instituicao: ");
					String estado = scanner.nextLine();
					while(estado.equals(null)){
						System.out.println("Digite um nome de estado valido: ");
						estado = scanner.nextLine();
					}
					do{
					System.out.println("Informe o numero da conta bancaria (de cinco digitos): ");
					numConta = scanner.nextDouble();
					scanner.nextLine();
					}while (numConta < 0 || numConta > 99999);
				
					System.out.println("Informe o codigo da Instituicao: ");
					String codInstituicao = scanner.nextLine();
					scanner.nextLine();
					
					Instituicao instituicao = new Instituicao(nome, cnpj, cidade, estado, numConta, codInstituicao);
					meuRep.cadastrar(instituicao);
					break;				
			}
		
			case 2:
					System.out.println("Digite o CNPJ da instituicao:");
					String cnpjNovo  = scanner.nextLine();
					scanner.nextLine();
				
					System.out.println(meuRep.buscar(cnpjNovo));
					break;
					
				
			case 3:
					System.out.println("Digite o CNPJ da instituicao que deseja remover: ");
					String cnpjRemover = scanner.nextLine();
					scanner.nextLine();
					
					System.out.println(meuRep.removerInstituicao(cnpjRemover));
					break;
				
			case 4:
					System.out.println("Digite o CNPJ da instituicao que deseja alterar: ");
					String cnpjAlterado = scanner.nextLine();
					scanner.nextLine();
					
					System.out.println("Digite o nome da instituicao a ser alterado: ");
					String novoNome = scanner.nextLine();
					
					System.out.println("Digite a cidade da instituicao a ser alterada: ");
					String novaCidade = scanner.nextLine();
					
					System.out.println("Digite o estado da instituicao a ser alterado: ");
					String novoEstado = scanner.nextLine();
					
					System.out.println("Digite o numero da conta da instituicao a ser alterado: ");
					double novaConta = scanner.nextDouble();
					
					System.out.println("Digite o codigo da instituicao a ser alterado: ");
					String novoCod = scanner.nextLine();
					
					Instituicao novaInstituicao = new Instituicao(cnpjAlterado, novoNome, novaCidade, novoEstado, novaConta, novoCod);
					
					meuRep.atualizarInstituicao(novaInstituicao);
					System.out.println(meuRep.atualizarInstituicao(novaInstituicao));
					break;	
				
			case 5:
					System.out.println(meuRep.listarInstituicoes());
					break;
				
			case 6:
					System.out.println("Voce saiu! :) ");
					return;
				
				default:
					System.out.printf("Voce digitou uma operacao invalida.");	
			}
		
		} while(opcao != 6);
		
	}
		
}