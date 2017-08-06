package hope.financeiro;
import java.util.Random;
import java.util.Scanner;

import hope.instituicao.Instituicao;

public class ControladorFinanceiro {
	
	private RepositorioFinanceiro repositorioF;
	
	public ControladorFinanceiro() {
		this.repositorioF = new RepositorioFinanceiro(null, 100);
	}
	Scanner leitura = new Scanner(System.in);
	
	public void cadastrar(Financeiro doacaoDinheiro){
		
		System.out.println("Informe o valor que deseja doar: ");
		int valor = leitura.nextInt();
		while(valor <= 0){
			System.out.println("Digite um valor valido: ");
			valor = leitura.nextInt();
			leitura.nextInt();
		}
		
		double contaOrigem;
		do{
			System.out.println("Informe o numero da conta bancaria do doador (5 digitos): ");
			contaOrigem = leitura.nextDouble();
			leitura.nextLine();
		}while (contaOrigem < 0 || contaOrigem > 99999);
		
		double contaDestino;
		do{
			System.out.println("Informe o numero da conta bancaria da instituicao beneficiada (5 digitos): ");
			contaDestino = leitura.nextDouble();
			leitura.nextLine();
		}while (contaDestino < 0 || contaDestino > 99999);
		
		//quero gerar o cod de operacao para relacionar as duas contas envolvidas!
		Random random = new Random();
		int codOperacao = random.nextInt(100);
		
		Financeiro financeiro = new Financeiro(contaOrigem, contaDestino, valor, codOperacao);
		repositorioF.cadastrar(financeiro);
		System.out.println(financeiro.toString()+"\n\tDoacao financeira cadastrada!\n");
		return;	
		
	}
	
	//Esse codDoador vai ser o random gerado quando for cadastrado o doador... adaptar quando tiver essa aplicacao pronta!!!
	public void buscarDoadorDinheiro() {
		System.out.println("Doador, digite seu codigo:");
		String codDoador  = leitura.nextLine();
	
		System.out.println(repositorioF.buscarDoadorDinhehiro(codDoador));
		return;
	}
	
	public void removerDoacaoDinheiro() {
		System.out.println("Digite o codigo de operacao da doacao que deseja remover: ");
		int codOperacaoRemover = leitura.nextInt();
		
		System.out.println(repositorioF.removerDoacaoDinheiro(codOperacaoRemover));
		return;
	}
	
	public void atualizar(){
		System.out.println("Digite o codigo da operacao que deseja alterar: ");
		int codF = leitura.nextInt();
		if(repositorioF.consultarExistenciaF(codF)==false){
			System.out.println("Codigo invalido!");
			return;
		}
	}
		
	//TODO
		/*
		Financeiro novoFinanceiro = new Financeiro();
		novoFinanceiro.setCodOperacao(codF);
		novoFinanceiro.setCodOperacao(repositorioF.getFinanceiroArray()[repositorioF.retornarPosicaoF(codF)]);
		
		System.out.println("Digite o numero da conta do doador a ser alterado: ");
		int novaContaOrigem = leitura.nextInt();
		repositorioF.getFinanceiroArray()[repositorioF.retornarPosicaoF(codF)].setContaOrigem(novaContaOrigem);
		
		System.out.println("Digite o numero da conta da instituicao a ser alterado: ");
		int novaContaDestino = leitura.nextInt();
		repositorioF.getFinanceiroArray()[repositorioF.retornarPosicaoF(codF)].setContaOrigem(novaContaDestino);
		
		System.out.println("Digite o valor da doacao a ser alterado: ");
		int novaValor = leitura.nextInt();
		repositorioF.getFinanceiroArray()[repositorioF.retornarPosicaoF(codF)].setContaOrigem(novaValor);
		
		System.out.println(repositorioF.getFinanceiroArray()[repositorioF.retornarPosicaoF(codF)].toString()+"\n");
		
		return;
	}
	*/
	
	public void listarDoacoesFinanceiras() {
		System.out.println(repositorioF.listarDoacoesFinanceiras());
		return;
	}

}
