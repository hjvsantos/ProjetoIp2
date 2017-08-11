package hope.doador.controller;

import hope.doador.*;
import javafx.scene.control.TextField;
import view.controllers.Sistema;
public class CadastrarDoadorController {

	private ControladorDoadorPessoa cdp;
	
	@FXML private TextField tfNome;
	@FXML private Integer tfIdade;
	@FXML private TextField tfCPF;
	@FXML private Double tfRG;
	@FXML private TextField tfCidade;
	@FXML private TextField tfEstado;
	@FXML private Double tfNumeroCartao;
	@FXML private Integer tfCodigoCartao;
	@FXML private Integer tfCodigoDoador;

	@FXML
	private void limparFields() {
		tfNome.setText(" ");
		tfCPF.setText(" ");
		tfIdade.intValue();
		tfRG.doubleValue();
		tfCidade.setText(" ");
		tfEstado.setText(" ");
		tfNumeroCartao.doubleValue();
		tfCodigoCartao.intValue();
		tfCodigoDoador.intValue();
		
	}
	
	@FXML 
	private void salvarDoador() {
		cdp = ControladorDoadorPessoa.getInstance();
		String nome = tfNome.getText();
		String cpf = tfCPF.getText();
		Integer idade = tfIdade.getInteger(nome, tfIdade); 
		Double RG = tfRG.doubleValue(); 
		String cidade = tfCidade.getText();
		String estado = tfEstado.getText();
		Double numCard = tfNumeroCartao.doubleValue();
		Integer codCard = tfCodigoCartao.getInteger(cpf, tfCodigoCartao);
		Integer codDoador = tfCodigoDoador.getInteger(nome, tfCodigoDoador);
		if((nome != null && nome != " ") && (cpf != null && cpf != " ") 
				&& (idade != null) && (RG != null)
				&& (cidade != null && cidade != " ")
				&& (estado != null && estado != " ")
				&& (numCard != null)
				&& (codCard != null)
				&& (codDoador != null)) {
			DoadorPessoa p = new DoadorPessoa(nome,idade,cpf,RG,cidade,estado,numCard,codCard,codDoador);
			cdp.cadastrarDoador(p);
			limparFields();
			System.out.println("Sucesso!"); //Será substituido por um alerta.
		}
		else
		{
			System.out.println("Erro ao salvar!"); //Será substituido por um alerta.
		}
	}
	
	
}
