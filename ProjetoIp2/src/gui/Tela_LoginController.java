package gui;


import aplicacao.Fachada;
import hope.excecao.ErroDeNegocioExcecao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela_LoginController {
	
	//private Principal principal;
	Fachada fachada = Fachada.getInstance();

	@FXML
	private TextField tl_tf_usuario;
	@FXML
	private PasswordField tl_pf_senhaUsuario;
	@FXML
	private Button bt_entrar;
	@FXML
	private Button bt_voltar;
	
	/*
	public void setMestre(Mestre mestre){
		this.mestre = mestre;
	}
	
	
	public void acessarLogin() throws ErroDeNegocioExcecao{
		this.setPrincipal(principal.getInstance());
	}
	
	@FXML
	public void acessarLogin(ActionEvent event) throws ErroDeNegocioExcecao {

		try {
			 if (this.fachada.efetuarLogin(tl_tf_usuario.getText(), tl_pf_senhaUsuario.getText()) == 1) {
				Parent root;
				Stage stage;

				stage = (Stage) TL_BT_Acessar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/sistema_mercadinho/gui/Backoffice.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}else if (this.fachada.efetuarLogin(TL_TF_Usuario.getText(), TL_PF_SenhaLogin.getText()) == -1) {
				Parent root;
				Stage stage;

				stage = (Stage) TL_BT_Acessar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/sistema_mercadinho/gui/FrenteDeCaixa.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	*/
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
