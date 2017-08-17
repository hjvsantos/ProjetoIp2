package hope.instituicao;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioInstituicao implements IRepositorioInstituicao, Serializable {

	public static final String NOME_DO_ARQ = "instituicao.dat";
	private ArrayList<Instituicao> instituicoesArray;
	public static RepositorioInstituicao instancia;

	public RepositorioInstituicao(){
		this.instituicoesArray = new ArrayList<>();
	}
	
	public static RepositorioInstituicao getInstance(){
		
		if(instancia == null){
			try{
				instancia = lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}
	
	private ArrayList<Instituicao> getInstituicoesArray() {
		return instituicoesArray;
	}

	private void setInstituicoesArray(ArrayList<Instituicao> instituicoesArray) {
		this.instituicoesArray = instituicoesArray;
	}

	public static RepositorioInstituicao lerDoArquivo() throws IOException{
		
		RepositorioInstituicao instanciaLocal = null;
		File entrada = new File(NOME_DO_ARQ);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(entrada);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			instanciaLocal = (RepositorioInstituicao) obj;
		} catch (Exception e) {
			instanciaLocal = new RepositorioInstituicao();
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
	
	@Override
	public boolean cadastrarI(Instituicao insti){
		this.instituicoesArray.add(insti);
		salvarArquivo();
		return true;
	}
	
	@Override
	public boolean atualizarInstituicao(Instituicao novaInsti){
		int count = 0;
		for(Instituicao i : this.instituicoesArray){
			
			if(i.getCodInstituicao() == novaInsti.getCodInstituicao()){
				this.instituicoesArray.set(count, novaInsti);
				salvarArquivo();
				return true;
			}
			count++;
		}
		return false;
	}
	
	@Override
	public Instituicao buscarI(int cod){
		for(Instituicao i : this.instituicoesArray){
			if(i.getCodInstituicao() == (cod)){
				return i;
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Instituicao> listarInstituicoes(){
		return this.instituicoesArray;
	}
	
	@Override
	public boolean removerI(int codInstituicao){
		int count = 0;
		for(Instituicao i : this.instituicoesArray){
			if(i.getCodInstituicao() == (codInstituicao)){
				this.instituicoesArray.remove(i);
				salvarArquivo();
				return true;
			}
			count++;
		}
		return false;
	}

}
