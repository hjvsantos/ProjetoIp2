package gui;

import aplicacao.Fachada;
import hope.administrador.Adm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela_Atualizar_AdmController {

	@FXML private TextField tf_Nome_Adm;
	@FXML private TextField tf_CPF_Adm;
	@FXML private TextField tf_Cidade_Adm;
	@FXML private TextField tf_Estado_Adm;
	@FXML private TextField tf_Senha_Adm;
	
	@FXML
	private Button bt_atualizar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML Button bt_buscarAdm;
	
	private Fachada fachada;
	
	public void initialize() {
		this.tf_Nome_Adm.setEditable(false);
		 this.tf_Cidade_Adm.setEditable(false);
		 this.tf_Estado_Adm.setEditable(false);
		 this.tf_Senha_Adm.setEditable(false);
	}
	
	@FXML
	public void buscarAdm(){
	     try {
	    	 this.fachada = Fachada.getInstance();
	    	 String cpf = this.tf_CPF_Adm.getText();
	    	 Adm admin = this.fachada.buscarAdm(cpf);
	    	 if(admin != null) {
	    		 this.tf_CPF_Adm.setEditable(false);
	    		 this.tf_Nome_Adm.setText(admin.getNome());
	    		 this.tf_Cidade_Adm.setText(admin.getCidade());
	    		 this.tf_Estado_Adm.setText(admin.getEstado());
	    		 this.tf_Senha_Adm.setText(admin.getSenha());
	    	 }
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}
	
	
	@FXML
	public void AtualizarAdm() {
		try{
			Adm adm = new Adm(tf_Nome_Adm.getText(), tf_CPF_Adm.getText(), tf_Senha_Adm.getText(), tf_Cidade_Adm.getText(), tf_Estado_Adm.getText());
			this.fachada.atualizarAdm(adm); 
			Parent root;
			Stage stage;

			stage = (Stage) bt_atualizar.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
		}catch (Exception e) {
		e.printStackTrace();
	}
	}
		
		
	@FXML
	public void Cancelar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Atualizar_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
