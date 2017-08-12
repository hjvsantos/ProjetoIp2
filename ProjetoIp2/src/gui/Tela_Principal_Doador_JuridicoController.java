package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tela_Principal_Doador_JuridicoController {

	@FXML
	private Button bt_atualizar;
	@FXML
	private Button bt_doacao_financeira;
	@FXML
	private Button bt_sair;
	@FXML
	private Button bt_doacao_prod;
	
	public void AbrirAtulizar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_atualizar) {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Atualizar_Doador_Juridico.fxml"));
			} else {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirDoacaoFinanceira(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_doacao_financeira) {
				stage = (Stage) bt_doacao_financeira.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Doacao_Financeira.fxml"));
			} else {
				stage = (Stage) bt_doacao_financeira.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirDoacaoProduto(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_doacao_prod) {
				stage = (Stage) bt_doacao_prod.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Doacao_Produto.fxml"));
			} else {
				stage = (Stage) bt_doacao_prod.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Juridico.fxml"));
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
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
