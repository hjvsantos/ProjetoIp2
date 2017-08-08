package hope.produto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioDiversos implements IRepositorioDiversos, Serializable {

	public static final String NOME_DO_ARQ = "diversos.dat";
	ArrayList<Diversos> diversosArray = new ArrayList<Diversos> ();
	public static RepositorioDiversos instancia;
	
	public RepositorioDiversos() {
		this.diversosArray = new ArrayList<Diversos> ();
	}
	
public static RepositorioDiversos getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}
	
	public ArrayList<Diversos> getDiversosArray() {
		return diversosArray;
	}

	private void setDiversosArray(ArrayList<Diversos> diversosArray) {
		this.diversosArray = diversosArray;
	}
	
public static RepositorioDiversos lerDoArquivo() throws IOException{
		
		RepositorioDiversos instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioDiversos) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioDiversos();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					/* Silence exception */
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
				/* Silent */}
		}
	}
}

public boolean cadastrarD(Diversos diversos){
	this.diversosArray.add(diversos);
	salvarArquivo();
	return true;
}	
	
public boolean atualizarDiversos(Diversos diversos){
	int count = 0;
	for(Diversos d : this.diversosArray){
		
		if(d.getCodigoProduto() == diversos.getCodigoProduto()){
			this.diversosArray.set(count, diversos);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}
	
public Diversos buscarDiversos(int codProduto){
	for(Diversos d : this.diversosArray){
		if(d.getCodigoProduto() == codProduto){
			return d;
		}
	}
	return null;
}	

public boolean removerDiversos(int codProduto){
	int count = 0;
	for(Diversos d : this.diversosArray){
		if(d.getCodigoProduto() == codProduto){
			this.diversosArray.remove(d);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}

public ArrayList<Diversos> listarDiversos(){
	return this.diversosArray;
}
}
	

