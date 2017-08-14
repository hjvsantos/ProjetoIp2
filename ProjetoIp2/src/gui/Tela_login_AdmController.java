package gui;

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
import aplicacao.Fachada;

public class Tela_login_AdmController {
	
	private Mestre mestre;
	Fachada fachada = Fachada.getInstance();

	@FXML
	private TextField tx_cpf;
	@FXML
	private PasswordField ps_senha;
	@FXML
	private Button bt_entrar;
	@FXML
	private Button bt_voltar;
	
	
	public void setMestre(Mestre mestre){
		this.mestre = mestre;
	}
	
	
	public void acessarLogin() throws ErroDeNegocioExcecao{
		this.setMestre(mestre.getInstance());
	}
	
	@FXML
	public void acessarLogin(ActionEvent event) throws ErroDeNegocioExcecao {

		try {
			 if (this.fachada.efetuarLoginAdm(tx_cpf.getText(), ps_senha.getText()) == 1) {
				Parent root;
				Stage stage;

				stage = (Stage) bt_entrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
			} 
			}catch (Exception e) {
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
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Login_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}