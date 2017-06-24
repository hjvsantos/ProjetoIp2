package hope.doador;

import java.util.Random;
import java.util.Scanner;

import hope.doador.DoadorPessoa;

public class ControladorDoadorPessoa {

	private RepositorioDoadorPessoa repositorio;
	
	public ControladorDoadorPessoa() {
		this.repositorio = new RepositorioDoadorPessoa(null, 0);
	}
	Scanner leitura = new Scanner(System.in);
	public void cadastrarDP() {
		
		
		System.out.println("Informe o seu nome: ");
		String nome = leitura.nextLine();
		
		System.out.println("Informe sua idade: ");
		int idade = leitura.nextInt();
		while(idade < 18){
			System.out.println("Um doador deve ser maior de idade!");
			System.out.println("Informe sua idade: ");
			idade = leitura.nextInt();
			leitura.nextLine();
		}
		
		System.out.println("Informe o seu CPF: ");
		String cpf = leitura.nextLine();
		while(cpf.equals(null)){
			System.out.println("Digite um CPF valido: ");
			cpf = leitura.nextLine();
			leitura.nextLine();
		}
		
		System.out.println("Informe o seu RG ");
		double rg = leitura.nextDouble();
		while(rg == 0){
			System.out.println("Digite um RG valido: ");
			rg = leitura.nextDouble();
			leitura.nextLine();
		}
	
		System.out.println("Informe sua cidade de origem:  ");
		String cidade = leitura.nextLine();
		while(cidade.equals(null)){
			System.out.println("Informe uma cidade existente: ");
			cidade = leitura.nextLine();
			leitura.nextLine();
		}
		
		System.out.println("Informe o seu estado de origem: ");
		String estado = leitura.nextLine();
		while(estado.equals(null)){
			System.out.println("Digite um estado existente: ");
			estado = leitura.nextLine();
		}		
		double numeroCartao;
		
		do{
		System.out.println("Informe o numero do seu cartão: ");
		numeroCartao = leitura.nextDouble();
		leitura.nextLine();
		}while (numeroCartao < 0 || numeroCartao > 99999);
	
		System.out.println("Informe o código do cartão (3 digitos): ");
		int codCartao = leitura.nextInt();
		while(codCartao == 0) {
			System.out.println("Digite um codigo válido: ");
			codCartao = leitura.nextInt();
		}
		
		Random random = new Random();
		int codDoador = random.nextInt(100);
		
		DoadorPessoa doadorPessoa = new DoadorPessoa(nome, idade, cpf, rg, cidade, estado, numeroCartao, codCartao, codDoador, 0);
		repositorio.cadastrarP(doadorPessoa);
		System.out.println(doadorPessoa.toString()+"\n\tDoador cadastrado!\n");
		return;		
	}
	
}
