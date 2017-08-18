package gui;

import hope.doador.DoadorEmpresa;
import hope.instituicao.Instituicao;

import java.awt.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import aplicacao.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Tela_Novo_Doador_JuridicoController {
	
	@FXML
	private Button bt_proximo;
	
	@FXML
	private Button bt_voltar;
	
	@FXML
	private PasswordField ps_senha;
	
	@FXML
	private TextField tx_nome;
	
	@FXML
	private TextField tx_cnpj;
	
	@FXML
	private TextField tx_cidade;
	
	@FXML
	private TextField tx_estado;
	
	@FXML
	private TextField tx_ano_fundacao;
	
	private TextField tx_ncartao;
	
	@FXML
	private TextField tx_codcartao;
	
	@FXML 
	private TextField tx_bandeira;
	
	@FXML 
	private TextField tx_validade;
	
	
	Fachada fachada;
	private Mestre mestre;
	
	
	public void setMestre(Mestre mestre) {
		this.mestre = mestre;
	}

	public void initialize(){
		fachada = fachada.getInstance();
	}
	
	public void cadastrarDoadorJuridico(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		
		if(validarCampos()){
		
			try {
				String nome, cnpj, cidade, estado, ano, numerocartao, senha, bandeira, codigo, validade;
				int codUsuario;
				
				nome = tx_nome.getText();
				cnpj = tx_cnpj.getText();
				cidade = tx_cidade.getText();
				estado = tx_estado.getText();
				ano	= tx_ano_fundacao.getText();
				numerocartao = tx_ncartao.getText();
				senha = ps_senha.getText();
				bandeira = tx_bandeira.getText();
				codigo = tx_codcartao.getText();
				validade = tx_validade.getText();
				
				
				DoadorEmpresa doador = new DoadorEmpresa(nome, 0, cnpj, 0, cidade, estado, numerocartao, codigo, bandeira, validade, senha);
				fachada.cadastrarDoadorEmpresa(doador);
								
				
				
				stage = (Stage) bt_proximo.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Login.fxml"));
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				
		} catch (Exception e){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informa��es inv�lidas");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	}
	
	private boolean validarCampos() throws IOException {
		boolean validade = false;
		try {
			if (tx_ano_fundacao.getText().isEmpty() || tx_cnpj.getText().isEmpty()
					|| tx_cidade.getText().isEmpty() || tx_estado.getText().isEmpty()
					|| tx_codcartao.getText().isEmpty() || tx_bandeira.getText().isEmpty() || tx_ncartao.getText().isEmpty()  || tx_validade.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informa��es inv�lidas");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				validade = true;
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informa��es inv�lidas");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();
		}
		return validade;
	}
	
	public void VoltarDJ(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_voltar) {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getClassLoader().getResource("/gui/Tela_Novo_Cadastro_Geral.fxml"));
			} else {
				stage = (Stage) bt_voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getClassLoader().getResource("/gui/Tela_Novo_Doador_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

