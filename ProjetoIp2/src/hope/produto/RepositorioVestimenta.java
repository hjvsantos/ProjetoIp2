package hope.produto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioVestimenta implements IRepositorioVestimenta, Serializable{

	ArrayList<Vestimenta> roupas = new ArrayList<Vestimenta>();
	public static final String NOME_DO_ARQ = "vestimenta.dat";
	public static RepositorioVestimenta instancia;
	
	public RepositorioVestimenta() {
		this.roupas =  new ArrayList<Vestimenta>();
	}
	
public static RepositorioVestimenta getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}

	public ArrayList<Vestimenta> getRoupas() {
		return roupas;
	}

	private void setHigieneArray(ArrayList<Vestimenta> roupas) {
		this.roupas = roupas;
	}
	
public static RepositorioVestimenta lerDoArquivo() throws IOException{
		
		RepositorioVestimenta instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioVestimenta) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioVestimenta();
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
	
public boolean cadastrarV(Vestimenta vestimenta){
	this.roupas.add(vestimenta);
	salvarArquivo();
	return true;
}	
	
public boolean atualizarV(Vestimenta vestimenta){
	int count = 0;
	for(Vestimenta v : this.roupas){
		
		if(v.getCodigoProduto() == roupas.get(count).getCodigoProduto()){
			this.roupas.set(count, vestimenta);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}
	
public Vestimenta buscarV(int codProduto){
	for(Vestimenta v : this.roupas){
		if(v.getCodigoProduto() == codProduto){
			return v;
		}
	}
	return null;
}	
	
public boolean removerV(int codProduto){
	int count = 0;
	for(Vestimenta v : this.roupas){
		if(v.getCodigoProduto() == codProduto){
			this.roupas.remove(v);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}
	
public ArrayList<Vestimenta> listarRoupas(){
	return this.roupas;
}	
}

