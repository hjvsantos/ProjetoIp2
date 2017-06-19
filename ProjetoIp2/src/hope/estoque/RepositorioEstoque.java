package hope.estoque;

public class RepositorioEstoque implements IRepositorioEstoque{

		private Estoque[] estoqueArray;
		private int tamanho = 0;
		
		public RepositorioEstoque(Estoque[] estoque, int tamanho) {
			this.estoqueArray = new Estoque[100];
			this.tamanho = tamanho;
		}

		public Estoque[] getEstoqueArray() {
			return estoqueArray;
		}

		public int getTamanho() {
			return tamanho;
		}
		
		public boolean inserir(Estoque estoque){
			if(estoque.equals(null)){
				return false;
			}else{
				for(int i = 0; i < this.tamanho; i++){
					if(estoque.getCodigo() == estoqueArray[i].getCodigo()){
						return false;
					}
				}
				if(tamanho < estoqueArray.length -1){
					estoqueArray[tamanho] = estoque;
					tamanho =  +1;
					return true;
				}
			}
			this.estoqueArray[this.tamanho] = estoque;
			this.tamanho = this.tamanho +1;
			return true;
		}
		
		public boolean atualizar(Estoque estoque){
			for(int i = 0; i < tamanho; i++){
				if(estoqueArray[i].getCodigo() == estoque.getCodigo()){
					estoqueArray[i] = estoque;
					return true;
				}
			}
			return false;
		}
		
		public Estoque buscarEstoque(int codigo){
			 int t = 0;
			 boolean find = false;
			 while ((!find) && (t < this.tamanho)){
					if(codigo == this.estoqueArray[t].getCodigo()){
						find = true;
					}else {
						t++;
					}
			 }
			 		Estoque resultado = null;
					if(t != this.tamanho){
						resultado = this.estoqueArray[t];
					}
					return resultado;
			}
		
		public boolean remover(int codigo){
			int i = 0;
			boolean find = false;
			while((!find) && (i < this.tamanho)){
				if(codigo == this.estoqueArray[i].getCodigo()){
					find = true;
				}
				else{
					i++;
				}
			}
			if(i != this.tamanho){
				this.estoqueArray[i] = this.estoqueArray[this.tamanho - 1];
				this.estoqueArray[this.tamanho - 1] = null;
				this.tamanho = this.tamanho -1;
				System.out.println("Produto: " + codigo + "removido!");
				return true;
			}
			else {
				System.out.println("Produto nao encontrado");
				return false;
			}
		}
		
		public String listarEstoque(){
			//TODO 
			return null;
			
		}	
}
