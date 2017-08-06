package hope.produto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioAlimento implements IRepositorioAlimento, Serializable{
	
	ArrayList<Alimento> alimentoArray = new ArrayList<Alimento>();
	public static final String NOME_DO_ARQ = "alimento.dat";
	public static RepositorioAlimento instancia;
	
	public RepositorioAlimento() {
		
		this.alimentoArray =  new ArrayList<Alimento>();
	}
	
	public ArrayList<Alimento> getAlimentoArray() {
		return alimentoArray;
	}
	
public static RepositorioAlimento getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}

private void setAlimentoArray(ArrayList<Alimento> alimentoArray) {
	this.alimentoArray = alimentoArray;
}

public static RepositorioAlimento lerDoArquivo() throws IOException{
	
	RepositorioAlimento instanciaLocal = null;
	File entrada = new File(NOME_DO_ARQ);
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	
	try {
		fis = new FileInputStream(entrada);
		ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		instanciaLocal = (RepositorioAlimento) obj;
	} catch (Exception e) {
		instanciaLocal = new RepositorioAlimento();
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

public boolean cadastrarA(Alimento alimento){
	this.alimentoArray.add(alimento);
	salvarArquivo();
	return true;
}	
	
public Alimento buscarAlimento(int codProduto){
	for(Alimento a : this.alimentoArray){
		if(a.getCodigoProduto() == codProduto){
			return a;
		}
	}
	return null;
}	
	
public boolean removerAlimento(int codProduto){
	int count = 0;
	for(Alimento i : this.alimentoArray){
		if(i.getCodigoProduto() == codProduto){
			this.alimentoArray.remove(i);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}
	
public ArrayList<Alimento> listar(){
	return this.alimentoArray;
}

}
