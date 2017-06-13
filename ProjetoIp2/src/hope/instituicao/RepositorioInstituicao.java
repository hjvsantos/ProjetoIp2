package hope.instituicao;

import java.util.Scanner;

public class RepositorioInstituicao {
	
	private Instituicao[] instituicoesArray;
	private int qntInstituicoes;
	Scanner scanner = new Scanner(System.in);
	
	//Construtor
	public RepositorioInstituicao(Instituicao[] instituicoes, int qntInstituicoes){
		this.instituicoesArray = new Instituicao[100];
		this.qntInstituicoes = 0;
	}

	//GET & SET
	public Instituicao[] getInstituicoes() {
		return instituicoesArray;
	}

	public int getQntInstituicoes() {
		return qntInstituicoes;
	}
	
	//CRUD
	
	//Cadastrar Instituição
	public boolean cadastrar(Instituicao insti){
		if(insti.equals(null)){
			return false;
		}
		else {
			for(int i = 0; i < this.qntInstituicoes; i++){
				if(insti.getCnpj() == instituicoesArray[i].getCnpj()){
					return false;
				}
			}
			if(qntInstituicoes < instituicoesArray.length -1){
				instituicoesArray[qntInstituicoes] = insti;
				qntInstituicoes = qntInstituicoes +1;
				return true;
			}
		}
		this.instituicoesArray[this.qntInstituicoes] = insti;
		this.qntInstituicoes = this.qntInstituicoes +1;
		return true;
	}
	
	
	
	
}
