package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tela_Novo_Cadastro_GeralController {

	@FXML
	private Button bt_cadastro_doador_juridico;
	@FXML
	private Button bt_cadastro_doador_fisico;
	@FXML
	private Button bt_cadastro_inst;
	@FXML
	private Button bt_voltar;
	
	public void AbrirCadastroDoadorJuridico(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cadastro_doador_juridico) {
				stage = (Stage) bt_cadastro_doador_juridico.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Novo_Doador_Juridico.fxml"));
			} else {
				stage = (Stage) bt_cadastro_doador_juridico.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirCadastroDoadorFisico(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cadastro_doador_fisico) {
				stage = (Stage) bt_cadastro_doador_fisico.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Novo_Doador_fisico.fxml"));
			} else {
				stage = (Stage) bt_cadastro_doador_fisico.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirCadastroDoadorInst(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cadastro_inst) {
				stage = (Stage) bt_cadastro_inst.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Nova_Instituicao.fxml"));
			} else {
				stage = (Stage) bt_cadastro_inst.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BotaoVoltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Menu_Inicial.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
