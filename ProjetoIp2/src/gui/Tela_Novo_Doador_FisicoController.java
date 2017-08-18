package gui;


import java.io.IOException;
import java.util.Random;

import aplicacao.Fachada;
import hope.doador.DoadorPessoa;
import hope.excecao.ErroDeNegocioExcecao;
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

public class Tela_Novo_Doador_FisicoController {
	
	@FXML
	private Button bt_cadastro_doador_fisico;
	
	@FXML
	private Button bt_voltar;

	private Mestre mestre;
	
	Fachada fachada;
	
	public void initialize(){
		 fachada = Fachada.getInstance();
	}
	
	public void setMestre(Mestre mestre) {
		this.mestre = mestre;
	}

	@FXML private TextField tf_Nome_DoadorFisico;
	@FXML private TextField tf_Idade_DoadorFisico;
	@FXML private TextField tf_CPF_DoadorFisico;
	@FXML private TextField tf_RG_DoadorFisico;
	@FXML private TextField tf_Cidade_DoadorFisico;
	@FXML private TextField tf_Estado_DoadorFisico;
	@FXML private TextField tf_NumeroCartao_DoadorFisico;
	@FXML private TextField tf_CodigoCard_DoadorFisico;
	@FXML private TextField tf_CodDoador_DoadorFisico;
	@FXML private TextField tf_bandeiraCard_DoadorFisico;
	@FXML private TextField tf_ValidadeCard_DoadorFisico;
	@FXML private PasswordField ps_Senha_DoadorFisico;
	
	@FXML 
	private void cadastrarDoadorFisico() throws IOException {
		Parent root;
		Stage stage;
		
		if(validarCampos()) {
			try {
				String nome = tf_Nome_DoadorFisico.getText();
				String cpf = tf_CPF_DoadorFisico.getText();
				Integer idade = Integer.parseInt(tf_Idade_DoadorFisico.getText());
				Double RG = Double.parseDouble(tf_RG_DoadorFisico.getText());
				String cidade = tf_Cidade_DoadorFisico.getText();
				String estado = tf_Estado_DoadorFisico.getText();
				String numCard = tf_NumeroCartao_DoadorFisico.getText();
				String codCard = tf_CodigoCard_DoadorFisico.getText();
				Integer codDoador = Integer.parseInt(tf_CodDoador_DoadorFisico.getText());
				String bandeira = tf_bandeiraCard_DoadorFisico.getText();
				String validade = tf_ValidadeCard_DoadorFisico.getText();
				String senha = ps_Senha_DoadorFisico.getText();
		
				Random random = new Random();
				codDoador = random.nextInt(100);
		
				DoadorPessoa doador = new DoadorPessoa(nome, idade,cpf, RG,cidade,estado,numCard,codCard,codDoador,bandeira,validade,senha);
				fachada.cadastrarDoador(doador);
		
				stage = (Stage) bt_cadastro_doador_fisico.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Novo_Doador_Fisico.fxml"));
		
				Scene scene = new Scene(root);
				stage.setScene(scene);
			} catch(Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informacoes invalidas");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}
	}
	
	public boolean validarCampos() throws IOException {
		boolean valido = false;
		try {
			if (tf_Nome_DoadorFisico.getText().isEmpty() || tf_CPF_DoadorFisico.getText().isEmpty()
					|| tf_Idade_DoadorFisico.getText().isEmpty() ||tf_RG_DoadorFisico.getText().isEmpty() ||tf_Cidade_DoadorFisico.getText().isEmpty()
					|| tf_Estado_DoadorFisico.getText().isEmpty() || tf_NumeroCartao_DoadorFisico.getText().isEmpty()
					|| tf_NumeroCartao_DoadorFisico.getText().isEmpty() || tf_CodigoCard_DoadorFisico.getText().isEmpty() || tf_CodDoador_DoadorFisico.getText().isEmpty() 
					|| tf_bandeiraCard_DoadorFisico.getText().isEmpty() || tf_ValidadeCard_DoadorFisico.getText().isEmpty() || ps_Senha_DoadorFisico.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informacoes invalidas");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				valido = true;
			}
		}catch(NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informacoes invalidas");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();
		}
		return valido;
	}
	
	public void voltarDF(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Doador_Fisico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

