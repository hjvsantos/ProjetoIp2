package gui;

import java.io.IOException;

import aplicacao.Fachada;
import hope.instituicao.Instituicao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Tela_Nova_InstituicaoController {

	@FXML
	private TextField tf_nome;
	@FXML
	private TextField tf_cnpj;
	@FXML
	private TextField tf_cidade;
	@FXML
	private TextField tf_estado;
	@FXML
	private TextField tf_num_conta;
	
	@FXML
	private Button bt_cadastrar;
	@FXML
	private Button bt_cancelar;
	
	Fachada fachada;
	
	@FXML
	public void initialize(){
		fachada = fachada.getInstance();
	}
	
	public void CadastrarInstituicao(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		
		if(validarCampos()){
		
			try {
				String nome, cnpj, cidade, estado;
				double numeroConta;
				
				nome = tf_nome.getText();
				cnpj = tf_cnpj.getText();
				cidade = tf_cidade.getText();
				estado = tf_estado.getText();
				numeroConta = tf_num_conta.getTranslateX();
				Instituicao insti = new Instituicao(nome, cnpj, cidade, estado, numeroConta);
				fachada.cadastrarI(insti);
				
				stage = (Stage) bt_cadastrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Nova_Instituicao.fxml"));
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				
		} catch (Exception e){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informações inválidas");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
}
	
	private boolean validarCampos() throws IOException {
		boolean validade = false;
		try {
			if (tf_nome.getText().isEmpty() || tf_cnpj.getText().isEmpty()
					|| tf_cidade.getText().isEmpty() || tf_estado.getText().isEmpty()
					|| tf_num_conta.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informações inválidas");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				validade = true;
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informações inválidas");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();
		}
		return validade;
	}
	
	
	public void Cancelar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Cadastro_Geral.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Nova_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
