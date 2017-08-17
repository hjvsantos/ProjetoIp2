package gui;

import hope.instituicao.Instituicao;

import java.io.IOException;
import java.util.Random;

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
import aplicacao.Fachada;

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
	private TextField tf_senha;
	
	@FXML
	private Button bt_cadastrar;
	@FXML
	private Button bt_voltar;
	
	Fachada fachada;
	private Mestre mestre;
	
	@FXML
	public void initialize(){
		fachada = fachada.getInstance();
	}
	
	public void setMestre(Mestre mestre){
		this.mestre = mestre;
	}
	
	public void CadastrarInstituicao(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		
		if(validarCampos()){
		
			try {
				String nome, cnpj, cidade, estado, senha, numeroConta;
				
				nome = tf_nome.getText();
				cnpj = tf_cnpj.getText();
				cidade = tf_cidade.getText();
				estado = tf_estado.getText();
				numeroConta = tf_num_conta.getText();
				senha = tf_senha.getText();
				
				Random rand = new Random();
				int x = rand.nextInt(100);
				
				//senha = ps_senha.getText(); aqui vai ser a senha 
				
				Instituicao insti = new Instituicao("nome", "cnpj", "cidade", "estado", "numeroConta", x, "senha");
				fachada.cadastrarI(insti);
				
				stage = (Stage) bt_cadastrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("gui/Tela_Principal_Instituicao.fxml"));
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				
		} catch (Exception e){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informacoes invalidas");
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
					|| tf_num_conta.getText().isEmpty() || tf_senha.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informacoes invalidas");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				validade = true;
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informacoes invalidas");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();
		}
		return validade;
	}
	
	
	public void Voltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("//gui/Tela_Nova_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}