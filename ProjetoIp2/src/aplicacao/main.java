package aplicacao;

import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Menu"+"\n1-Doador"+"\n2-Institui��o"+"\n3-Sair");
		int i=0;
		Scanner entrada = new Scanner(System.in);
		
		i = entrada.nextInt();
		
		switch(i){
			case 1:
				System.out.println("Menu do Doador"+"\n1-Pessoa F�sica"+"\n2-Pessoa Jur�dica"+"\n3-Sair");
				i = entrada.nextInt();
					
				break;
			case 2:
				System.out.println("Menu Institui��o"+"\n1-Cadastro"+"\n2-Solicita��es"+"\n3-Sair");
				i= entrada.nextInt();
					switch(i){
						case 1:
								System.out.println("Informe o nome da Institui��o:");
								String nome = entrada.nextLine();
								System.out.println("Informe o CNPJ da Institui��o:");
								String cnpj = entrada.nextLine();
								System.out.println("Informe a cidade da Institui��o:");
								String cidade = entrada.nextLine();
								System.out.println("Informe o estado da Institui��o:");
								String estado = entrada.nextLine();
								System.out.println("Informe o numero da conta da Institui��o:");
								double conta = entrada.nextDouble();
								Random nAleatorio = new Random(100);
								System.out.println("O c�digo gerado para institui��o �:"+nAleatorio);
								
							break;
						case 2:
							
							break;
						case 3:
							break;
						default:
							System.out.println("Op��o inv�lida!");
					}
				break;
			case 3:
				break;
			default:
				System.out.println("Op��o inv�lida!");
		}
				
	}

}
