package gui;

import aplicacao.Fachada;
import hope.administrador.Adm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	    	 else
	    	 {
	    		 this.tf_Nome_Adm.setEditable(false);
	    		 this.tf_Cidade_Adm.setEditable(false);
	    		 this.tf_Estado_Adm.setEditable(false);
	    		 this.tf_Senha_Adm.setEditable(false);
	    		 Alert alerta = new Alert(AlertType.ERROR);
	    		 alerta.setTitle("ERRO!");
	    		 alerta.setHeaderText("Erro Usuário");
	    		 alerta.setContentText("Usuario nao encontrado!");
	    		 alerta.showAndWait();
	    	 }
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}
	
	
	@FXML
	public void AtualizarAdm() {
		try {
			this.fachada = Fachada.getInstance();
			String cpf = this.tf_CPF_Adm.getText();
			String nome = this.tf_Nome_Adm.getText();
			String cidade = this.tf_Cidade_Adm.getText();
			String estado = this.tf_Estado_Adm.getText();
			String senha = this.tf_Senha_Adm.getText();
			Adm admin = new Adm(cpf, nome, cidade, estado, senha);
			admin.setCpf(cpf);
			admin.setNome(nome);
			admin.setCidade(cidade);
			admin.setEstado(estado);
			admin.setSenha(senha);
			this.fachada.atualizarAdm(admin);
		}
		catch(Exception e) {
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
