package hope.produto;

import hope.instituicao.Instituicao;
import hope.instituicao.RepositorioInstituicao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioHigiene implements IRepositorioHigiene, Serializable{
	
	public static final String NOME_DO_ARQ = "higiene.dat";
	ArrayList<Higiene> higieneArray = new ArrayList<Higiene> ();
	public static RepositorioHigiene instancia;
	
	public RepositorioHigiene() {
		this.higieneArray = new ArrayList<Higiene> ();
	}
	
public static RepositorioHigiene getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}
	
	public ArrayList<Higiene> getHigieneArray() {
		return higieneArray;
	}

	private void setHigieneArray(ArrayList<Higiene> higieneArray) {
		this.higieneArray = higieneArray;
	}
	
public static RepositorioHigiene lerDoArquivo() throws IOException{
		
		RepositorioHigiene instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioHigiene) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioHigiene();
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

public boolean cadastrarH(Higiene higiene){
	this.higieneArray.add(higiene);
	salvarArquivo();
	return true;
}	
	
public boolean atualizarHigiene(Higiene higiene){
	int count = 0;
	for(Higiene h : this.higieneArray){
		
		if(h.getCodigoProduto() == higiene.getCodigoProduto()){
			this.higieneArray.set(count, higiene);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}
	
public Higiene buscarHigiene(int codProduto){
	for(Higiene h : this.higieneArray){
		if(h.getCodigoProduto() == codProduto){
			return h;
		}
	}
	return null;
}	

public boolean removerHigiene(int codProduto){
	int count = 0;
	for(Higiene i : this.higieneArray){
		if(i.getCodigoProduto() == codProduto){
			this.higieneArray.remove(i);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}

public ArrayList<Higiene> listarHigiene(){
	return this.higieneArray;
}

}
