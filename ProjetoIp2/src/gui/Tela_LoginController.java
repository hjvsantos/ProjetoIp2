package gui;


import java.io.IOException;

import aplicacao.Fachada;
import hope.excecao.ErroDeNegocioExcecao;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Tela_LoginController {
	
	private Mestre mestre;
	Fachada fachada = Fachada.getInstance();

	@FXML
	private TextField tx_cod;
	@FXML
	private PasswordField ps_senha;
	@FXML
	private Button bt_entrar;
	@FXML
	private Button bt_voltar;
	@FXML
	private Button bt_sair;
	
	
	public void setMestre(Mestre mestre){
		this.mestre = mestre;
	}
}
	/*
	private int user;
	private String pass;
	
	public void initialize(){
		this.mestre = Mestre.getInstance();
		this.user = 0101;
		this.pass = "tassia";
		this.bt_entrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				boolean loginOk = false;
				try{
					if(event.getSource() == bt_entrar){
						if(ps_senha.getText().equals(pass)){
							stage = (Stage) bt_entrar.getScene().getWindow();
							root = (Parent) FXMLLoader.load(getClass().getResource("/view/OverviewTemplate.fxml"));
							loginOk = true;
						}else{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Falha de Login");
							alert.setHeaderText("Informações inválidas");
							alert.setContentText("Senha incorreta");
							alert.showAndWait();
						}
					}else{
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Falha de Login");
						alert.setHeaderText("Informações inválidas");
						alert.setContentText("Usuário não encontrado");
						alert.showAndWait();
					}
		//	}
				if(loginOk){
					Scene scene = new Scene(root);
					stage.setScene(scene);
					String tituloAtual = stage.getTitle();
					stage.setTitle(tituloAtual +" - "+ (""+user.charAt(0)).toUpperCase() + user.substring(1, user.length()));
					stage.setResizable(true);
					mestre.changeStage(stage);
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			
	});

	}
	
	*/
	
	
	/*
	@FXML
	public void acessarLogin(ActionEvent event) throws ErroDeNegocioExcecao {

		try {
			 if (this.fachada.efetuarLoginUsuarios(tx_cod.getAnchor(), ps_senha.getText()) == 1) {
				Parent root;
				Stage stage;

				stage = (Stage) bt_entrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Fisico.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}else if (this.fachada.efetuarLoginUsuarios(tx_cod.getAnchor(), ps_senha.getText()) == -1) {
				Parent root;
				Stage stage;

				stage = (Stage) bt_entrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Juridico.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);

			} else if (this.fachada.efetuarLoginUsuarios(tx_cod.getAnchor(), ps_senha.getText()) == -2) {
				Parent root;
				Stage stage;

				stage = (Stage) bt_entrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Instituicao.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void botaoVoltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Menu_Inicial.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Login.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
*/
