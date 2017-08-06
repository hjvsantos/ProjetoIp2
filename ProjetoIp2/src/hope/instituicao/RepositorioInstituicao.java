package hope.instituicao;

import java.util.ArrayList;

public class RepositorioInstituicao implements IRepositorioInstituicao {

	private ArrayList<Instituicao> instituicoesArray = new ArrayList<Instituicao>();
	private int qntInstituicoes;

	// Construtor
	public RepositorioInstituicao(Instituicao[] instituicoesArray, int qntInstituicoes) {
		this.instituicoesArray = new ArrayList<Instituicao>();
		this.qntInstituicoes = qntInstituicoes;
	}

	// GET & SET
	public ArrayList<Instituicao> getInstituicoesArray(int codInstituicao) {
		return instituicoesArray;
	}

	public int getQntInstituicoes() {
		return qntInstituicoes;
	}

	// CRUD

	// Cadastrar Instituição
	public boolean cadastrarI(Instituicao insti) {
		if (insti.equals(null)) {
			return false;
		} else {
			for (int i = 0; i < this.qntInstituicoes; i++) {
				if (insti.getCnpj() == instituicoesArray.get(i).getCnpj()) {
					return false;
				}
			}
			if (qntInstituicoes < instituicoesArray.size() - 1) {
				instituicoesArray.add(insti);
				qntInstituicoes = qntInstituicoes + 1;
				return true;
			}
		}
		instituicoesArray.add(insti);
		this.qntInstituicoes = this.qntInstituicoes + 1;
		return true;
	}

	// Buscar Instituição

	public Instituicao buscarI(int codInstituicao) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.qntInstituicoes)) {
			if (codInstituicao == this.instituicoesArray.get(i).getCodInstituicao()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		Instituicao resultado = null;
		if (i != this.qntInstituicoes) {
			resultado = this.instituicoesArray.get(i);
		}
		return resultado;
	}

	// Remover Instituição
	public boolean removerInstituicao(int codInstituicao) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.qntInstituicoes)) {
			if (codInstituicao == this.instituicoesArray.get(i).getCodInstituicao()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		if (i != this.qntInstituicoes) {
			this.instituicoesArray.set((qntInstituicoes -1), instituicoesArray.get(i));
			this.instituicoesArray.remove(this.qntInstituicoes -1);
			this.qntInstituicoes = this.qntInstituicoes - 1;
			System.out.println("Instituicao: " + codInstituicao + "removida!");
			return true;
		} else {
			System.out.println("Instituicao nao encontrada!");
			return false;
		}
	}

	public boolean consultarExistencia(int codInstituicao) {
		for (int i = 0; i < qntInstituicoes; i++) {
			if (codInstituicao == this.instituicoesArray.get(i).getCodInstituicao()) {
				return true;
			}
		}
		return false;
	}

	public int retornarPosicao(int codInstituicao) {
		int pos = 0;
		for (int i = 0; i < qntInstituicoes; i++) {
			if (codInstituicao == instituicoesArray.get(i).getCodInstituicao()) {
				return pos;
			} else {
				pos++;

			}
		}
		return pos;
	}

	// Atualizar Instituicao
	public boolean atualizarInstituicao(Instituicao novaInsti) {
		for (int i = 0; i < qntInstituicoes; i++) {
			if (instituicoesArray.get(i).getCodInstituicao() == novaInsti.getCodInstituicao()) {
				instituicoesArray.set(i, novaInsti);
				return true;
			}
		}
		return false;
	}

	// Listar Instituições
	public String listarInstituicoes() {
		String listaFinal = "";
		for (int i = 0; i < qntInstituicoes; i++) {
			listaFinal += "\n Informacoes das instituicoes:\n Nome: "
					+ instituicoesArray.get(i).getNome() + "\n CNPJ: "
					+ instituicoesArray.get(i).getCnpj() + "\n Cidade: "
					+ instituicoesArray.get(i).getCidade() + "\n Estado: "
					+ instituicoesArray.get(i).getEstado() + "\n Numero da conta: "
					+ instituicoesArray.get(i).getNumeroConta()
					+ "\n Codigo da Instituição:"
					+ instituicoesArray.get(i).getCodInstituicao()
					+ "\n Donativos: " + "\n";
		}
		return listaFinal;
	}

}
