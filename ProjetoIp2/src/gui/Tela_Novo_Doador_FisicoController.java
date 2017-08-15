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

public class Tela_Novo_Doador_FisicoController {
	
	@FXML
	private Button bt_proximo;
	
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
	
	
	void Proximo(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_proximo) {
				stage = (Stage) bt_proximo.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Fisico.fxml"));
			} else {
				stage = (Stage) bt_proximo.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Doador_Fisico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Voltar(ActionEvent event) {
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
