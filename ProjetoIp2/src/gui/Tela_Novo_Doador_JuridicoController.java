package gui;

import java.awt.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Tela_Novo_Doador_JuridicoController {
	
	@FXML
	private Button bt_proximo;
	
	@FXML
	private Button bt_voltar;
	
	@FXML
	private PasswordField ps_senha;
	
	@FXML
	private TextField tx_nome;
	
	@FXML
	private TextField tx_cnpj;
	
	@FXML
	private TextField tx_cidade;
	
	@FXML
	private TextField tx_estado;
	
	@FXML
	private TextField tx_ano_fundacao;
	
	public void Cadastro(ActionEvent event) {
		
	}
	
	public void Voltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Cadastro_Geral.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Doador_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
