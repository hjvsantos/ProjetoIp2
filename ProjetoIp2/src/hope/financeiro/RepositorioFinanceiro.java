package hope.financeiro;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RepositorioFinanceiro implements IRepositorioFinanceiro, Serializable{
	
	ArrayList<Financeiro> financeiroArray = new ArrayList<Financeiro>();
	public static final String NOME_DO_ARQ = "financeiro.dat";
	public static RepositorioFinanceiro instancia;
	
	public RepositorioFinanceiro(){
		this.financeiroArray = new ArrayList<Financeiro>();
	}

	public ArrayList<Financeiro> getFinanceiroArray(){
		return financeiroArray;
	}
	
	private void setFinanceiroArray(ArrayList<Financeiro> financeiroArray){
		this.financeiroArray = financeiroArray;
	}
	
public static RepositorioFinanceiro getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}

public static RepositorioFinanceiro lerDoArquivo() throws IOException{
	
	RepositorioFinanceiro instanciaLocal = null;
	File entrada = new File(NOME_DO_ARQ);
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	
	try {
		fis = new FileInputStream(entrada);
		ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		instanciaLocal = (RepositorioFinanceiro) obj;
	} catch (Exception e) {
		instanciaLocal = new RepositorioFinanceiro();
	} finally {
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
			}
		}
	}
	return instanciaLocal;
}	

public void salvarArquivo(){
	if (instancia == null){
		return;
	}
	File saida = new File(NOME_DO_ARQ);
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	
	try {
		fos = new FileOutputStream(saida);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(instancia);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				}
		}
	}
}

	public boolean cadastrar(Financeiro doacaoDinheiro){
		this.financeiroArray.add(doacaoDinheiro);
		salvarArquivo();
		return true;
	}
	
	public boolean atualizarF(Financeiro novaDoacao){
		int count = 0;
		for(Financeiro f : this.financeiroArray){
			
			if(f.getCodOperacao() == novaDoacao.getCodOperacao()){
				this.financeiroArray.set(count, novaDoacao);
				salvarArquivo();
				return true;
			}
			count++;
		}
		return false;
	}
	
	public Financeiro buscarDoacaoFinanceira(int codOperacao){
		for(Financeiro f : this.financeiroArray){
			if(f.getCodOperacao() == codOperacao){
				return f;
			}
		}
		return null;
	}
	
	public boolean removerDoacaoDinheiro(int codOperacao){
		int count = 0;
		for(Financeiro f : this.financeiroArray){
			if(f.getCodOperacao() == codOperacao){
				this.financeiroArray.remove(f);
				salvarArquivo();
				return true;
			}
			count++;
		}
		return false;
	}
	
	
	public ArrayList<Financeiro> listarDoacoesFinanceiras(){
		return this.financeiroArray;

	}
}
