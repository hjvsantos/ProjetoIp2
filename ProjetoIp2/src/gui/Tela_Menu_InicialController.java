package gui;

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
	private Button bt_sair;
	@FXML
	private Button bt_adm;
	
	
	private Mestre mestre;
	
	public void setMestre(Mestre mestre){
		this.mestre = mestre;
	}
	
	@FXML
	public void menuLogar(ActionEvent event){
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == menuLogar) {
				stage = (Stage) menuLogar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Login.fxml"));
			} else {
				stage = (Stage) menuLogar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Menu_Inicial.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void menuCadastrar(ActionEvent event){
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == menuCadastrar) {
				stage = (Stage) menuCadastrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			} else {
				stage = (Stage) menuCadastrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Menu_Inicial.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void menuAdm(ActionEvent event){
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_adm) {
				stage = (Stage) bt_adm.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Principal_Adm.fxml"));
			} else {
				stage = (Stage) bt_adm.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Menu_Inicial.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setApp(Mestre mestre){
		this.mestre = mestre;
	}
	
	private void fecharTelaAction(){
	    Stage stage = (Stage) bt_sair.getScene().getWindow(); 
	    stage.close(); 
	}

}
