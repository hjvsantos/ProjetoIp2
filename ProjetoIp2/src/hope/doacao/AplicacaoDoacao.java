package hope.doacao;
import java.util.Scanner;
import hope.instituicao.Instituicao;
import hope.produtos.Produtos;
import hope.doador.Doador;
import hope.doador.DoadorEmpresa;
import hope.doador.DoadorPessoa;

public class AplicacaoDoacao {

	public static void main(String[] args) {
		
		Doacao[] donativos = new Doacao[100];
		RepositorioDoacao repoDoacao = new RepositorioDoacao(donativos, 100);
		
		Scanner leitura = new Scanner(System.in);
		int option = 0;
		
		System.out.println("**** DOA��ES **** \n");
		
		do {
			
			System.out.println("Escolha a op��o desejada: \n 1- Cadastrar doa��o \n 2- Pesquisar doa��o\n 3- Alterar doa��o\n 4- Excluir doa��o\n 5- Listar doa��es\n 6- SAIR\n ");
			option = leitura.nextInt();
			leitura.nextLine();
			int cod;
			DoadorEmpresa empresadoadora;
			DoadorPessoa doador;
			Instituicao instituicao;
			switch(option) {
				case 1:
					//CHECAR COMO � A ENTRADA PARA O TIPO INSTITUI��O
					  	/*System.out.println("Informe o cnpj da Institui��o que ser� beneficiada: \n");
					  	Instituicao beneficiada = leitura.nextLine();
					  	instituicao = beneficiada;
					  	*/
					
					
					  	System.out.println("Informe o seu CPF/CNPJ: \n");
					  	String id = leitura.nextLine();
					  	if(id.equals(empresadoadora)) {
					  		 empresadoadora.cnpj = id;
					  	}
					  	else
					  	{
					  	     doador.cpf = id;
					  	}
					  	
					  	System.out.println("Informe a quantidade de doa��es que voc� far� hoje: ");
					  	int quantidade = leitura.nextInt();
					  	
					  	System.out.println("Informe os produtos que fazem parte desta doa��o: \n");
					  	Produto prod = leitura;
					  	
					  	System.out.println();
					  	Doacao donativo = new Doacao(beneficiada,empresadoadora,
								doador, quantidade, Produtos produto,
								int doacaoDinheiro, int codigo);
					  	repoDoacao.cadastrarDoacao(donativo);
					  	
					  	break;
					  	
				case 2:
					  
					  	System.out.println("Informe o codigo da doa��o que voc� deseja pesquisar: \n");
					  	cod = leitura.nextInt();
					  	leitura.nextLine();
					  	System.out.println(repoDoacao.buscarDoacao(cod));
					  
				case 3:
					  
						System.out.println("Informe o codigo da doa��o a ser alterada: \n");
						cod = leitura.nextInt();
						leitura.nextLine();
					 
						
					    System.out.println("Digite o CNPJ da instituicao que deseja alterar: ");
						String cnpj = leitura.nextLine();
						leitura.nextLine();
						
						System.out.println("Digite o nome da instituicao a ser alterado: ");
						String novoNome = leitura.nextLine();
						
						System.out.println("Digite a cidade da instituicao a ser alterada: ");
						String novaCidade = leitura.nextLine();
						
						System.out.println("Digite o estado da instituicao a ser alterado: ");
						String novoEstado = leitura.nextLine();
						
						System.out.println("Digite o numero da conta da instituicao a ser alterado: ");
						double novaConta = leitura.nextDouble();
						
						Doacao donativo = new Doacao(beneficiado, DoadorEmpresa empresadoadora,
								DoadorPessoa doador, int quantidade, Produtos produto,
								int doacaoDinheiro, cod);
						
						repoDoacao.atualizarDoacao(novaDoacao);
						System.out.println(repoDoacao.atualizarDoacao(novaDoacao));
						break;	
						
				case 4:
						
						System.out.println("Informe o c�digo da doa��o que voc� deseja remover: ");
						cod = leitura.nextInt();
						System.out.println(repoDoacao.removerDoacao(cod));
						break;
				case 5:
					
						System.out.println(repoDoacao.listarDoacoes());
						break;
				case 6:
					
						System.out.println("Voc� saiu!");
						break;
						
				default:
					
						System.out.println("Voc� escolheu uma op��o inv�lida!");
			}
			
			
			
			
		}while (option != 6);

	}

}
