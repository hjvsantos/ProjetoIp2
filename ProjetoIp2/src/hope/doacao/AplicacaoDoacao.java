package hope.doacao;
import java.util.Scanner;
import hope.instituicao.Instituicao;
import hope.produto.Produto;
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
			DoadorEmpresa empresadoadora = null;
			DoadorPessoa doador = null;
			Instituicao instituicao;
			switch(option) {
				case 1:
					System.out.println("Informe o seu CPF/CNPJ: \n");
				  	String id = leitura.nextLine();
				  		do{
				  		System.out.println(" Digite uma identifica��o v�lida: \n");
				  		id = leitura.nextLine();
				  		} while (id == null);
				  		
				  		if(id.equals(empresadoadora.cnpj)) {
				  			empresadoadora.cnpj = id;
				  		}
				  		else if (id.equals(doador.cpf))
				  		{
				  			doador.cpf = id;
				  		}
				  		
				  		System.out.println("Informe o codigo da Institui��o que ser� beneficiada: \n");
					  	String codInstituicao = leitura.nextLine();
					  	while (codInstituicao == null) {
					  		System.out.println("Informe uma identifica��o v�lida: \n");
					  		codInstituicao = leitura.nextLine();
					  	}
				  	
					  	System.out.println("Informe a quantidade de doa��es que voc� far� hoje: ");
					  	int quantidade = leitura.nextInt();
					  	leitura.nextLine();
					  	
					  	
					  	//System.out.println("Informe os produtos que fazem parte desta doa��o: \n");
					  	
					  	
					  	System.out.println("Informe a quantia em dinheiro a ser doada: \n");
					  	int doacaoDinheiro = leitura.nextInt();
					  	
					  	System.out.println("Informe um c�digo para esta doa��o: \n");
					  	int codigo = leitura.nextInt();
					  	
					  	Doacao donativo = new Doacao(codInstituicao, empresadoadora,
								doador, quantidade,
								doacaoDinheiro, codigo);
					  	
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
						
					    System.out.println(repoDoacao.getDoacaoArray(cod));
						
					    System.out.println("Digite o codigo da instituicao que deseja alterar: ");
						codInstituicao = leitura.nextLine();
						leitura.nextLine();
						
						System.out.println("Digite o CPF do novo doador: ");
						String nomeDoador = leitura.nextLine();
						
						System.out.println("Informe a nova quantidade de doa��es: ");
						int novaQtd = leitura.nextInt();
						
						System.out.println("Informe a nova quantia em dinheiro: ");
						double novaDoacaoDinheiro = leitura.nextDouble();
						
						Doacao novaDoacao = new Doacao(codInstituicao, empresadoadora, doador, novaQtd, novaDoacaoDinheiro, cod);
						
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
