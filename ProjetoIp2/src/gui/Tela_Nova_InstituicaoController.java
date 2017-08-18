package gui;

import hope.excecao.ErroDeNegocioExcecao;
import hope.instituicao.ControladorInstituicao;
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
import javafx.scene.control.PasswordField;
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
	private PasswordField ps_senha;
	
	@FXML
	private Button bt_cadastrar;
	@FXML
	private Button bt_voltar;
	
	Fachada fachada;
	//private ControladorInstituicao rep;
	private Mestre mestre;
	
	
	@FXML
	public void initialize(){
		fachada = fachada.getInstance();
	}
	
	public void setMestre(Mestre mestre){
		this.mestre = mestre;
	}
	
	/*
	private void CadastrarInstituicao() throws ErroDeNegocioExcecao{
		rep = ControladorInstituicao.getInstance();
		String nome = tf_nome.getText();
		String cnpj = tf_cnpj.getText();
		String cidade = tf_cidade.getText();
		String estado = tf_estado.getText();
		String numeroConta = tf_num_conta.getText();
		String senha = tf_senha.getText();
		
		if(nome != null && nome != "" && cnpj != null && cnpj != ""
				&& cidade != null && cidade != "" && estado != null
				&& estado != "" && numeroConta != null && numeroConta != ""
				&& senha != null && senha != ""){
		
		Random rand = new Random();
		int x = rand.nextInt(100);
		
		Instituicao i = new Instituicao(nome, cnpj, cidade, estado, numeroConta, x, senha);
		rep.cadastrarI(i);
		tf_nome.setText("");
		tf_cnpj.setText("");
		tf_cidade.setText("");
		tf_estado.setText("");
		tf_num_conta.setText("");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sucesso");
		alert.setHeaderText("Cadastro Instituicao");
		alert.setContentText("Instituicao cadastrada com sucesso");
		alert.showAndWait();
	}else{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Informações inválidas");
		alert.setContentText("Informações fornecidas são inválidas");
		alert.showAndWait();
	}	
}
	
	private void setApp(Mestre app){
		this.mestre = app;
	}
	*/
	
	public void CadastrarInstituicao(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		
		if(validarCampos()){
		
			try {
				String nome, cnpj, cidade, estado, numeroConta, senha;
				
				nome = tf_nome.getText();
				cnpj = tf_cnpj.getText();
				cidade = tf_cidade.getText();
				estado = tf_estado.getText();
				numeroConta = tf_num_conta.getText();
				senha = ps_senha.getText();
				
				Random rand = new Random();
				int x = rand.nextInt(100);
				
				//senha = ps_senha.getText(); aqui vai ser a senha 
				
				Instituicao insti = new Instituicao(nome, cnpj, cidade, estado, numeroConta, x, senha);
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
			if ((tf_nome.getText().isEmpty() || tf_cnpj.getText().isEmpty()
					|| tf_cidade.getText().isEmpty() || tf_estado.getText().isEmpty()
					|| tf_num_conta.getText().isEmpty() || ps_senha.getText().isEmpty())) {
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
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Nova_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}