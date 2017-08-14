package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tela_Menu_InicialController {
	
	@FXML
	private Button menuLogar;
	@FXML
	private Button menuCadastrar;
	
	@FXML
	private Button BT_SAIR;
	
	@FXML
	private Button bt_adm;
	
	private void fecharTelaAction(){
	    Stage stage = (Stage) BT_SAIR.getScene().getWindow(); 
	    stage.close(); 
	}
	
	public void AbrirLoginUsuarios(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == menuLogar) {
				stage = (Stage) menuLogar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Login.fxml"));
			} else {
				stage = (Stage) menuLogar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Menu_Inicial.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirLoginAdm(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_adm) {
				stage = (Stage) bt_adm.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Login_Adm.fxml"));
			} else {
				stage = (Stage) menuLogar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Menu_Inicial.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirCadastroUsuarios(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == menuCadastrar) {
				stage = (Stage) menuCadastrar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Cadastro_Geral.fxml"));
			} else {
				stage = (Stage) menuCadastrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Menu_Inicial.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
