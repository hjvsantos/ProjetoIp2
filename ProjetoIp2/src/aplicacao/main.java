package aplicacao;

import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Menu"+"\n1-Doador"+"\n2-Instituição"+"\n3-Sair");
		int i=0;
		Scanner entrada = new Scanner(System.in);
		
		i = entrada.nextInt();
		
		switch(i){
			case 1:
				System.out.println("Menu do Doador"+"\n1-Pessoa Física"+"\n2-Pessoa Jurídica"+"\n3-Sair");
				i = entrada.nextInt();
					
				break;
			case 2:
				System.out.println("Menu Instituição"+"\n1-Cadastro"+"\n2-Solicitações"+"\n3-Sair");
				i= entrada.nextInt();
					switch(i){
						case 1:
								System.out.println("Informe o nome da Instituição:");
								String nome = entrada.nextLine();
								System.out.println("Informe o CNPJ da Instituição:");
								String cnpj = entrada.nextLine();
								System.out.println("Informe a cidade da Instituição:");
								String cidade = entrada.nextLine();
								System.out.println("Informe o estado da Instituição:");
								String estado = entrada.nextLine();
								System.out.println("Informe o numero da conta da Instituição:");
								double conta = entrada.nextDouble();
								Random nAleatorio = new Random(100);
								System.out.println("O código gerado para instituição é:"+nAleatorio);
								
							break;
						case 2:
							
							break;
						case 3:
							break;
						default:
							System.out.println("Opção inválida!");
					}
				break;
			case 3:
				break;
			default:
				System.out.println("Opção inválida!");
		}
				
	}

}
