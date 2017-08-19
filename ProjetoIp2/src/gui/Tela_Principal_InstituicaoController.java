package gui;

import java.io.IOException;

import aplicacao.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Tela_Principal_InstituicaoController {

	@FXML
	private Button bt_atualizar;
	@FXML
	private Button bt_solic_doacao;
	@FXML
	private Button bt_sair;
	@FXML Label lb_nome;
	@FXML Label lb_cnpj;
	@FXML Label lb_cidade;
	@FXML Label lb_estado;
	@FXML Label lb_codigo;
	@FXML Label lb_num_conta;
	

	
	private Mestre mestre;
	Tela_Nova_InstituicaoController tela = new Tela_Nova_InstituicaoController();
	
	Fachada fachada = Fachada.getInstance();
	private Stage stage;
	
	public void Inicialize(){
		
		
	}
	
	
	public void setMestre(Mestre mestre) {
		this.mestre = mestre;
	}
	
	public void AbrirAtulizar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_atualizar) {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Atualizar_Instituicao.fxml"));
			} else {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Principal_Instituicao.fxml"));
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
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Menu_Inicial.fxml"));
			} else {
				stage = (Stage) bt_sair.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Principal_Instituicao.fxml"));
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
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Solicitacoes_Instituicao.fxml"));
			} else {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Principal_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void start(Stage stage) {
		 this.stage = stage;

	        initRootLayout();

	        showPersonOverview();
	}
	
	 private BorderPane rootLayout;
	 
	public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Tela_Principal_InstituicaoController.class.getResource("/gui/Tela_Principal_Instituicao.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void showPersonOverview() {
        try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Tela_Nova_InstituicaoController.class.getResource("/gui/Tela_Principal_Instituicao.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Define o person overview dentro do root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getStage() {
        return stage;
    }
	
}
