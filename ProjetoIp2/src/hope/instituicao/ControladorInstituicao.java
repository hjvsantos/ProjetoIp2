package hope.instituicao;

import java.util.Random;
import java.util.Scanner;

public class ControladorInstituicao {

	private RepositorioInstituicao repositorio;
	
	public ControladorInstituicao() {
		this.repositorio = new RepositorioInstituicao(null, 100);
	}
	
	Scanner leitura = new Scanner(System.in);
	
	public void cadastrarInstituicao () {
		System.out.println("Informe o CNPJ da instituicao: ");
		String cnpj = leitura.nextLine();
		while(cnpj.equals(null)){
			System.out.println("Digite um cnpj valido: ");
			cnpj = leitura.nextLine();
			leitura.nextLine();
		}
	
		System.out.println("Informe o nome da instituicao: ");
		String nome = leitura.nextLine();
		while(nome.equals(null)){
			System.out.println("Digite um nome valido: ");
			nome = leitura.nextLine();
			leitura.nextLine();
		}
		System.out.println("Informe a cidade da instituicao: ");
		String cidade = leitura.nextLine();
		while(cidade.equals(null)){
			System.out.println("Digite um nome de cidade valido: ");
			cidade = leitura.nextLine();
		}		
		System.out.println("Informe o estado da instituicao: ");
		String estado = leitura.nextLine();
		while(estado.equals(null)){
			System.out.println("Digite um nome de estado valido: ");
			estado = leitura.nextLine();
		}
		double numConta;
		
		do{
		System.out.println("Informe o numero da conta bancaria (de cinco digitos): ");
		numConta = leitura.nextDouble();
		leitura.nextLine();
		}while (numConta < 0 || numConta > 99999);
	
		Random random = new Random();
		int codInstituicao = random.nextInt(100);
		
		
		
		Instituicao instituicao = new Instituicao(nome, cnpj, cidade, estado, numConta, codInstituicao);
		repositorio.cadastrarI(instituicao);
		System.out.println(instituicao.toString()+"\n\tInstituição cadastrada!\n");
		return;		
	}
	
	public void buscarInstituição() {
		System.out.println("Digite o codigo da instituicao:");
		int codigoNovo  = leitura.nextInt();
	
		System.out.println(repositorio.buscarI(codigoNovo));
		return;
	}
	
	public void removerInstituicao() {
		System.out.println("Digite o codigo da instituicao que deseja remover: ");
		int codigoRemover = leitura.nextInt();
		
		System.out.println(repositorio.removerInstituicao(codigoRemover));
		return;
	}
	
	public void atualizarInstituicao() {
		System.out.println("Digite o codigo da instituicao que deseja alterar: ");
		int codI = leitura.nextInt();
		if(repositorio.consultarExistencia(codI)==false){
			System.out.println("Instituição não existente");
			return;
		}
	}
		
		/*
		Instituicao novaInstituicao = new Instituicao();
		novaInstituicao.setCodInstituicao(codI);
		novaInstituicao.setCnpj(repositorio.getInstituicoes()[repositorio.retornarPosicao(codI)].getCnpj());
		
		
		System.out.println("Digite o nome da instituicao a ser alterado: ");
		String novoNome = leitura.next();
		repositorio.getInstituicoes()[repositorio.retornarPosicao(codI)].setNome(novoNome);
		
		System.out.println("Digite a cidade da instituicao a ser alterada: ");
		String novaCidade = leitura.next();
		repositorio.getInstituicoes()[repositorio.retornarPosicao(codI)].setCidade(novaCidade);
		
		System.out.println("Digite o estado da instituicao a ser alterado: ");
		String novoEstado = leitura.next();
		repositorio.getInstituicoes()[repositorio.retornarPosicao(codI)].setEstado(novoEstado);
		
		System.out.println("Digite o numero da conta da instituicao a ser alterado: ");
		double novaConta = leitura.nextDouble();
		repositorio.getInstituicoes()[repositorio.retornarPosicao(codI)].setNumeroConta(novaConta);
		
		System.out.println(repositorio.getInstituicoes()[repositorio.retornarPosicao(codI)].toString()+"\n");
		
		return;
	}
	*/
	
	public void listarInstituicao() {
		System.out.println(repositorio.listarInstituicoes());
		return;
	}
}
