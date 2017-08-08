package hope.doador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioDoadorPessoa implements IRepositorioDoadorPessoa, Serializable{
	
	public static final String NOME_DO_ARQ = "doadorPessoa.dat";
	ArrayList<DoadorPessoa> arrayDoadorPessoa = new ArrayList<DoadorPessoa>(); 
	public static RepositorioDoadorPessoa instancia;
	
	public ArrayList<DoadorPessoa> getArrayDoadorPessoa() {
		return arrayDoadorPessoa;
	}

	public void setArrayDoadorPessoa(ArrayList<DoadorPessoa> arrayDoadorPessoa) {
		this.arrayDoadorPessoa = arrayDoadorPessoa;
	}
	
	public static RepositorioDoadorPessoa getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}

	public static RepositorioDoadorPessoa lerDoArquivo() throws IOException{
		
		RepositorioDoadorPessoa instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioDoadorPessoa) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioDoadorPessoa();
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
	
	public boolean cadastrarDoadorPessoa (DoadorPessoa doador) {
	    this.arrayDoadorPessoa.add(doador);
	    salvarArquivo();
	    return true;
	}

	public DoadorPessoa buscarDoadorPessoa (int codigo) {
		for(DoadorPessoa d : this.arrayDoadorPessoa){
			if(d.getCodigoDoador() == codigo){
				return d;
			}
		}
		return null;	

	}
	
	public boolean removerDoadorPessoa(int codigo){
		int count = 0;
		for(DoadorPessoa d : this.arrayDoadorPessoa){
			if(d.getCodigoDoador() == codigo){
				this.arrayDoadorPessoa.remove(d);
				salvarArquivo();
				return true;
			}
			count++;
		}
		return false;
	}
	
	public ArrayList<DoadorPessoa> listar(){
		return this.arrayDoadorPessoa;
	}
}
