package hope.administrador;

import java.util.ArrayList;

public interface IRepositorioAdm {

	public ArrayList<Adm> listar();
	
	public boolean removerAdm(String cpf);
	
	public Adm buscarAdm(String cpf);
	
	public boolean atualizarAdm(Adm adm);
	
	public boolean cadastrarAdm(Adm adm);
}
