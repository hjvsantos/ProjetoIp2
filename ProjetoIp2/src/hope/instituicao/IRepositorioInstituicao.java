package hope.instituicao;
import java.util.ArrayList;

public interface IRepositorioInstituicao {
	
	public boolean cadastrarI(Instituicao insti);
	
	public boolean atualizarInstituicao(Instituicao novaInsti);
	
	public Instituicao buscarI(int codInstituicao);
	
	public ArrayList<Instituicao> listar();
	
	public boolean removerI(int codInstituicao);
	
}