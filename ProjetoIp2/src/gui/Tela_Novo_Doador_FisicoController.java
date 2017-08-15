package gui;

import java.awt.TextField;

import hope.doador.ControladorDoadorPessoa;
import hope.doador.DoadorPessoa;
import hope.excecao.ErroDeNegocioExcecao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Tela_Novo_Doador_FisicoController {
	
	@FXML
	private Button bt_voltar;
	
	@FXML
	private PasswordField ps_senha;
	
	@FXML
	private TextField tx_nome;
	
	@FXML
	private TextField tx_cpf;
	
	@FXML
	private TextField tx_cidade;
	
	@FXML
	private TextField tx_estado;
	
	private ControladorDoadorPessoa cdp;
	
	@FXML private TextField tf_Nome_DoadorFisico;
	@FXML private Integer tf_Idade_DoadorFisico;
	@FXML private TextField tf_CPF_DoadorFisico;
	@FXML private Double tf_RG_DoadorFisico;
	@FXML private TextField tf_Cidade_DoadorFisico;
	@FXML private TextField tf_Estado_DoadorFisico;
	@FXML private TextField tf_NumeroCartao_DoadorFisico;
	@FXML private TextField tf_CodigoCard_DoadorFisico;
	@FXML private Integer tf_CodDoador_DoadorFisico;
	@FXML private TextField tf_bandeiraCard_DoadorFisico;
	@FXML private TextField tf_ValidadeCard_DoadorFisico;
	@FXML private PasswordField ps_Senha_DoadorFisico;

	@FXML
	private void limparFields() {
		tf_Nome_DoadorFisico.setText(" ");
		tf_CPF_DoadorFisico.setText(" ");
		tf_Idade_DoadorFisico.intValue();
		tf_RG_DoadorFisico.doubleValue();
		tf_Cidade_DoadorFisico.setText(" ");
		tf_Estado_DoadorFisico.setText(" ");
		tf_NumeroCartao_DoadorFisico.setText(" ");
		tf_CodigoCard_DoadorFisico.setText(" ");
		tf_CodDoador_DoadorFisico.intValue();
		tf_bandeiraCard_DoadorFisico.setText(" ");
		tf_ValidadeCard_DoadorFisico.setText(" ");
		ps_Senha_DoadorFisico.setText(" ");
		
	}
	
	@FXML 
	private void cadastrarDoadorFisico() {
		cdp = ControladorDoadorPessoa.getInstance();
		String nome = tf_Nome_DoadorFisico.getText();
		String cpf = tf_CPF_DoadorFisico.getText();
		Integer idade = tf_Idade_DoadorFisico.getInteger(nome, tf_Idade_DoadorFisico); 
		Double RG = tf_RG_DoadorFisico.doubleValue(); 
		String cidade = tf_Cidade_DoadorFisico.getText();
		String estado = tf_Estado_DoadorFisico.getText();
		String numCard = tf_NumeroCartao_DoadorFisico.getText();
		String codCard = tf_CodigoCard_DoadorFisico.getText();
		Integer codDoador = tf_CodDoador_DoadorFisico.getInteger(nome, tf_CodDoador_DoadorFisico);
		String bandeira = tf_bandeiraCard_DoadorFisico.getText();
		String validade = tf_ValidadeCard_DoadorFisico.getText();
		String senha = ps_Senha_DoadorFisico.getText();
		if((nome != null && nome != " ") && (cpf != null && cpf != " ") 
				&& (idade != null) && (RG != null)
				&& (cidade != null && cidade != " ")
				&& (estado != null && estado != " ")
				&& (numCard != null && numCard != " ")
				&& (codCard != null && codCard != " ")
				&& (codDoador != 0)
				&& (bandeira != null && bandeira != " ")
				&& (validade != null && validade != " ")
				&& (senha != null && senha != " ")) {
			DoadorPessoa p = new DoadorPessoa(nome,idade,cpf,RG,cidade,estado,numCard,codCard,codDoador, bandeira, validade, senha);
			try {
				cdp.cadastrarDoador(p);
			} catch (ErroDeNegocioExcecao e) {
				e.printStackTrace();
			}
			limparFields();
			Alert alerta = new Alert(AlertType.CONFIRMATION);
   		 	alerta.setTitle("Cadastro realizado com sucesso!");
		}
		else
		{
			Alert alerta = new Alert(AlertType.ERROR);
   		 	alerta.setTitle("ERRO!");
		}
	}
	
	public void voltarDF(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Menu_Inicial.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Doador_Fisico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
