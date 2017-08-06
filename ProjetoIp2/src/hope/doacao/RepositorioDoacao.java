package hope.doacao;

import hope.produto.Higiene;
import hope.produto.RepositorioHigiene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioDoacao implements IRepositorioDoacao, Serializable {

	public static final String NOME_DO_ARQ = "doacao.dat";
	ArrayList<Doacao> doacaoArray = new ArrayList<Doacao> ();
	public static RepositorioDoacao instancia;
	
	public RepositorioDoacao() {
		this.doacaoArray = new ArrayList<Doacao> ();
	}
	
public static RepositorioDoacao getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}
	
	public ArrayList<Doacao> getDoacaoArray() {
		return doacaoArray;
	}

	private void setDoacaoArray(ArrayList<Doacao> doacaoArray) {
		this.doacaoArray = doacaoArray;
	}
	
public static RepositorioDoacao lerDoArquivo() throws IOException{
		
		RepositorioDoacao instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioDoacao) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioDoacao();
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

public boolean cadastrarDoacao(Doacao doacao){
	this.doacaoArray.add(doacao);
	salvarArquivo();
	return true;
}	
	
	
public Doacao buscarDoacao(int codProduto){
	for(Doacao d : this.doacaoArray){
		if(d.getCodigo() == codProduto){
			return d;
		}
	}
	return null;
}	

public boolean removerDoacao(int codProduto){
	int count = 0;
	for(Doacao d : this.doacaoArray){
		if(d.getCodigo() == codProduto){
			this.doacaoArray.remove(d);
			salvarArquivo();
			return true;
		}
		count++;
	}
	return false;
}

public ArrayList<Doacao> listar(){
	return this.doacaoArray;
}

	
}