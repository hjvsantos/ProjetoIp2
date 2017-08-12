package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tela_Principal_InstituicaoController {

	@FXML
	private Button bt_atualizar;
	@FXML
	private Button bt_solic_doacao;
	@FXML
	private Button bt_sair;
	@FXML
	private Button bt_remover;
	
	public void AbrirAtulizar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_atualizar) {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Atualizar_Instituicao.fxml"));
			} else {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Sair(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_sair) {
				stage = (Stage) bt_sair.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Menu_Inicial.fxml"));
			} else {
				stage = (Stage) bt_sair.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirSolicitarDoacao(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_solic_doacao) {
				stage = (Stage) bt_solic_doacao.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Solicitacoes_Instituicao.fxml"));
			} else {
				stage = (Stage) bt_solic_doacao.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirRemover(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_remover) {
				stage = (Stage) bt_remover.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Confirma_Remocao_Usuario.fxml"));
			} else {
				stage = (Stage) bt_remover.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
