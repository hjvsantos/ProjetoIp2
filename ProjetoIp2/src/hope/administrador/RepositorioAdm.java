package hope.administrador;

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

public class RepositorioAdm implements IRepositorioAdm, Serializable{
	
	public static final String NOME_DO_ARQ = "administradores.dat";
	private ArrayList<Adm> admArray;
	public static RepositorioAdm instancia;

	private RepositorioAdm(){
		admArray = new ArrayList<>();
	}
	
	public static RepositorioAdm getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}
	
	private ArrayList<Adm> getAdmArray() {
		return admArray;
	}

	private void setAdmArray(ArrayList<Adm> admArray) {
		this.admArray = admArray;
	}

	public static RepositorioAdm lerDoArquivo() throws IOException{
		
		RepositorioAdm instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioAdm) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioAdm();
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
					/* Silent */}
			}
		}
	}
	
	public boolean cadastrarAdm(Adm adm){
		this.admArray.add(adm);
		salvarArquivo();
		return true;
	}
	
	public boolean atualizarAdm(Adm adm){
		int count = 0;
		for(Adm i : this.admArray){
			
			if(i.getCpf().equals(adm.getCpf())){
				this.admArray.set(count, adm);
				salvarArquivo();
				return true;
			}
			count++;
		}
		return false;
	}
	
	
	public Adm buscarAdm(String cpf){
		for(Adm i : this.admArray){
			if(i.getCpf().equals(cpf)){
				return i;
			}
		}
		return null;
	}
	
	
	public ArrayList<Adm> listar(){
		return this.admArray;
	}
	
	public boolean removerAdm(String cpf){
		int count = 0;
		for(Adm i : this.admArray){
			if(i.getCpf().equals(cpf)){
				this.admArray.remove(i);
				salvarArquivo();
				return true;
			}
			count++;
		}
		return false;
	}
}
