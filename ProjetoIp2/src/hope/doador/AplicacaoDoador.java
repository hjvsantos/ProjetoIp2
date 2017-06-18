package hope.doador;

import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;

import java.util.Random;
import java.util.Scanner;

public class AplicacaoDoador {

public static void main(String[] args) {
		
		Doador[] i = new Doador[100];
		RepositorioDoador meuRep = new RepositorioDoador (i, 100);
		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("Menu\n");
		
		do{
			System.out.println("Escolha uma das opcoes a seguir:\n 1)Cadastrar Doador.\n 2)Buscar instituicao.\n 3)Remover instituicao.\n" +
					" 4)Atualizar dados da instituicao.\n 5)Listar todas as instituicoes cadastrados.\n 6)Sair.");
				opcao = entrada.nextInt();
				entrada.nextLine();
				double numConta;
		
			switch(opcao){
			case 1:
					System.out.println("Informe o CPF ou CNPJ do Doador: ");
					String id = entrada.nextLine();
					while(id.equals(null)){
						System.out.println("Digite uma identificação valida: ");
						id = entrada.nextLine();
						entrada.nextLine();
				
					System.out.println("Informe o nome do doador: ");
					String nome = entrada.nextLine();
					while(nome.equals(null)){
						System.out.println("Digite um nome valido: ");
						nome = entrada.nextLine();
						entrada.nextLine();
					}
					System.out.println("Informe a cidade do doador: ");
					String cidade = entrada.nextLine();
					while(cidade.equals(null)){
						System.out.println("Digite um nome de cidade valido: ");
						cidade = entrada.nextLine();
					}		
					System.out.println("Informe o estado da doador: ");
					String estado = entrada.nextLine();
					while(estado.equals(null)){
						System.out.println("Digite um nome de estado valido: ");
						estado = entrada.nextLine();
					}
					do{
					System.out.println("Informe o numero do cartao: ");
					numConta = entrada.nextDouble();
					entrada.nextLine();
					}while (numConta < 0 || numConta > 99999999);
					
					System.out.println("Informe o codigo do cartao:");
					int codCar = entrada.nextInt();
					while(codCar == 0){
						System.out.println("O codigo é invalido");
					}
					
					Random random  = new Random();
					int x = random.nextInt(100);
					
					
				
					Doador doador = new Doador(nome, id, cidade, numConta, codCar, 0, x);
					meuRep.cadastrar(doador);
					break;				
			}
		
			case 2:
					System.out.println("Digite o codigo do doador");
					int idBusca = entrada.nextInt();
				
					System.out.println(meuRep.buscar(idBusca));
					break;
					
				
			case 3:
					System.out.println("Digite o codigo do Doador que deseja remover: ");
					int idRemove = entrada.nextInt();
					
					System.out.println(meuRep.removerDoador(idRemove));
					break;
				
			case 4:
					System.out.println("Digite o codigo do doador que deseja alterar: ");
					int codAlterado = entrada.nextInt();
					entrada.nextLine();
					
					System.out.println("Digite o nome do doador a ser alterado: ");
					String novoNome = entrada.nextLine();
					
					
					System.out.println("Digite a cidade da instituicao a ser alterada: ");
					String novaCidade = entrada.nextLine();
					
					System.out.println("Digite o estado do doador a ser alterado: ");
					String novoEstado = entrada.nextLine();
					
					System.out.println("Digite o numero da conta da instituicao a ser alterado: ");
					double novoCard = entrada.nextDouble();
					
					System.out.println("Digite o numero do codigo do cartao a ser alterado: ");
					int codCard = entrada.nextInt();
					
					Doador novoDoador= new Doador(novoNome, novaCidade, novoEstado, novoCard, codCard, 0, codAlterado);
					
					meuRep.atualizarDoador(novoDoador);
					System.out.println(meuRep.atualizarDoador(novoDoador));
					break;	
				
			case 5:
					System.out.println(meuRep.listarDoadores());
					break;
				
			case 6:
					System.out.println("Voce saiu! ");
					return;
				
				default:
					System.out.printf("Voce digitou uma operacao invalida.");	
			}
		
		} while(opcao != 6);
		
	}
}
