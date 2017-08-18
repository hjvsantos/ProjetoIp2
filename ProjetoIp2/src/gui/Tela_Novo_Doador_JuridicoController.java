package gui;

import java.io.IOException;
import java.util.Random;

import aplicacao.Fachada;
import hope.doador.DoadorEmpresa;
import hope.excecao.ErroDeNegocioExcecao;
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

public class Tela_Novo_Doador_JuridicoController {
	
	@FXML
	private Button bt_proximo;
	
	@FXML
	private Button bt_voltar;
	
	@FXML
	PasswordField ps_senha;
	
	@FXML
	TextField tx_nome;
	
	@FXML
	TextField tx_cnpj;
	
	@FXML
	TextField tx_cidade;
	
	@FXML
	TextField tx_estado;
	
	@FXML
	TextField tx_ano_fundacao;
	
	@FXML
	TextField tx_ncartao;
	
	@FXML
	TextField tx_codcartao;
	
	@FXML 
	TextField tx_bandeira;
	
	@FXML 
	TextField tx_validade;
	
	
	Fachada fachada = Fachada.getInstance();;
	private Mestre mestre;
	
	
	public void initialize(){
		
	}

	public void setMestre(Mestre mestre) {
		this.mestre = mestre;
	}

		
	public void cadastrarDoadorJuridico(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		
		if(validarCampos()){
		
			try {
				String nome, cnpj, cidade, estado,  numerocartao, senha, bandeira, codigo, validade;
				int codUsuario, anoFunda;
				
				nome = tx_nome.getText();
				cnpj = tx_cnpj.getText();
				cidade = tx_cidade.getText();
				estado = tx_estado.getText();
				anoFunda = Integer.parseInt(tx_ano_fundacao.getText());
				
				numerocartao = tx_ncartao.getText();
				senha = ps_senha.getText();
				bandeira = tx_bandeira.getText();
				codigo = tx_codcartao.getText();
				validade = tx_validade.getText();
				
				int codDoador;
				Random random = new Random();
				codDoador = random.nextInt(100);
				
				DoadorEmpresa doador = new DoadorEmpresa(nome, anoFunda, cnpj, codDoador, cidade, estado, numerocartao, codigo, bandeira, validade, senha);
				fachada.cadastrarDoadorEmpresa(doador);
								
				
				
				stage = (Stage) bt_proximo.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Principal_Doador_Juridico.fxml"));
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				
		} catch (NumberFormatException e){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informa��es inv�lidas");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (ErroDeNegocioExcecao e1){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informa��es inv�lidas");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		}
	}
	}
	
	private boolean validarCampos() throws IOException {
		boolean validade = false;
		try {
			if (tx_cnpj.getText().isEmpty() || tx_nome.getText().isEmpty() || ps_senha.getText().isEmpty() ||
					tx_cidade.getText().isEmpty() || tx_estado.getText().isEmpty()
					|| tx_codcartao.getText().isEmpty() || tx_bandeira.getText().isEmpty() || tx_ncartao.getText().isEmpty() || tx_ano_fundacao.getText().isEmpty() || tx_validade.getText().isEmpty()) {
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
				root = FXMLLoader.load(getClass().getClassLoader().getResource("/gui/Tela_Principal_Doador_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

