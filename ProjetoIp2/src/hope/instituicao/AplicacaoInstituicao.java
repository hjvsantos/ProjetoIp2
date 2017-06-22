package hope.instituicao;

import java.util.Random;
import java.util.Scanner;

public class AplicacaoInstituicao {

	public static void main(String[] args) {
		
		ControladorInstituicao controler = new ControladorInstituicao();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("\t Menu \n");
		
		do{
			System.out.println("Escolha uma das opcoes a seguir:\n 1)Cadastrar instituicao.\n 2)Buscar instituicao.\n 3)Remover instituicao.\n" +
					" 4)Atualizar dados da instituicao.\n 5)Listar todas as instituicoes cadastrados.\n 6)Sair.");
				opcao = scanner.nextInt();
				scanner.nextLine();
		
			switch(opcao){
			case 1:
					controler.cadastrarInstituicao();
					break;
		
			case 2:
					controler.buscarInstituição();
					break;
					
			case 3:
					controler.removerInstituicao();
					break;
					
			case 4:
					controler.atualizarInstituicao();
					break;
			
			case 5:
					controler.listarInstituicao();
					break;
				
			case 6:
					System.out.println("Voce saiu");
					return;
				
				default:
					System.out.printf("Voce digitou uma operacao invalida.");	
			}
		
		} while(opcao != 6);
		}
	}
		
