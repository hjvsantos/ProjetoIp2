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
	
	public void initialize(){
		this.mestre = Mestre.getInstance();
//		Adm adm = new Adm("tassia", "023494", "123456", "Recife", "Pernambuco");
	}
	
	
	@FXML
	public void acessarLogin(ActionEvent event) throws ErroDeNegocioExcecao {

		String cpf = tx_cpf.getText();
		String senha = ps_senha.getText();
				
		try {
			 if (this.fachada.efetuarLoginAdm(cpf, senha) == 1) {
				Parent root;
				Stage stage;

				stage = (Stage) bt_entrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("gui/Tela_Principal_Adm.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
			} 
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}	
	}
	
	public void botaoVoltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("gui/Tela_Menu_Inicial.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("gui/Tela_Login_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
