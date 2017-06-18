package hope.categoria;

public enum Categoria {
	produto("produto"),
	financeiro("financeiro");
	
private String tipo;
	
	Categoria (String tipo)
	{
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
