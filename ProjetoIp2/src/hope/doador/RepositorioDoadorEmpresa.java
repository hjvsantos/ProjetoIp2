package hope.doador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioDoadorEmpresa implements IRepositorioDoadorEmpresa, Serializable {
	
	public static final String NOME_DO_ARQ = "empresadoadora.dat";
	ArrayList<DoadorEmpresa> arrayDoadorEmpresa = new ArrayList<DoadorEmpresa> ();
	public static RepositorioDoadorEmpresa instancia;
	
public static RepositorioDoadorEmpresa getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}
	
	public ArrayList<DoadorEmpresa> getArrayDoadorEmpresa() {
		return arrayDoadorEmpresa;
	}
	public void setArrayDoadorEmpresa(ArrayList<DoadorEmpresa> arrayDoadorEmpresa) {
		this.arrayDoadorEmpresa = arrayDoadorEmpresa;
	}
	
public static RepositorioDoadorEmpresa lerDoArquivo() throws IOException{
		
		RepositorioDoadorEmpresa instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioDoadorEmpresa) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioDoadorEmpresa();
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

public boolean cadastrarDoadorEmpresa(DoadorEmpresa doador){
	this.arrayDoadorEmpresa.add(doador);
	salvarArquivo();
	return true;
}	
	
	
public DoadorEmpresa buscarDoadorEmpresa(int codigo){
	for(DoadorEmpresa d : this.arrayDoadorEmpresa){
		if(d.getCodigoDoador() == codigo){
			return d;
		}
	}
	return null;
}	

public boolean removerDoadorEmpresa(int codigo){
	int count = 0;
	for(DoadorEmpresa d : this.arrayDoadorEmpresa){
		if(d.getCodigoDoador() == codigo){
			this.arrayDoadorEmpresa.remove(d);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}

public ArrayList<DoadorEmpresa> listar(){
	return this.arrayDoadorEmpresa;
}


}