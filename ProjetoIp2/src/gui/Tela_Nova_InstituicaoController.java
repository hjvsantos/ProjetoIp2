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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import aplicacao.Fachada;

public class Tela_Nova_InstituicaoController {

	@FXML
	TextField tf_nome;
	@FXML
	 TextField tf_cnpj;
	@FXML
	 TextField tf_cidade;
	@FXML
	 TextField tf_estado;
	@FXML
	 TextField tf_num_conta;
	@FXML
	 PasswordField ps_senha;	
	@FXML
	 Button bt_cadastrar;
	@FXML
	 Button bt_voltar;
	
	Fachada fachada  = Fachada.getInstance();
	private Mestre mestre;
	Instituicao insti;
	
	
	
	@FXML
	public void initialize(){
	}
	
	public void setMestre(Mestre mestre){
		this.mestre = mestre;
	}
	
		
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
				
				insti = new Instituicao(nome, cnpj, cidade, estado, numeroConta, x, senha);
				fachada.cadastrarI(insti);
				
				
				Tela_Principal_InstituicaoController tela = new Tela_Principal_InstituicaoController();
				tela.lb_cidade.setText(cidade);
				tela.lb_cnpj.setText(cnpj);
				tela.lb_estado.setText(estado);
				tela.lb_nome.setText(nome);
				tela.lb_num_conta.setText(numeroConta);
				tela.lb_codigo.setText(Integer.toString(x));
				
				
				tela.start(new Stage());
				
				/*stage = (Stage) bt_cadastrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Principal_Instituicao.fxml"));
				
				Scene scene = new Scene(root);
				stage.setScene(scene);*/
				
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
				alert.setHeaderText("teste");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				validade = true;
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Informacoes invalidas");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();
		}
		return validade;
	}
	
	@FXML
	public void buscar_Instituicao(){
	     try {
	    	 this.fachada = Fachada.getInstance();
	    	 this.fachada.buscarI(insti.getCodInstituicao());
	    	 if(insti != null) {
	    		 this.tf_nome.setText(insti.getNome());
	    		 this.tf_cnpj.setText(insti.getCnpj());
	    		 this.tf_cidade.setText(insti.getCidade());
	    		 this.tf_estado.setText(insti.getEstado());
	    		 this.tf_num_conta.setText(insti.getNumeroConta());
	    		 this.ps_senha.setText(insti.getSenha());
	    	 }
	    	 else
	    	 {
	    		 Alert alerta = new Alert(AlertType.ERROR);
	    		 alerta.setTitle("ERRO!");
	    		 alerta.setHeaderText("Erro Usu�rio");
	    		 alerta.setContentText("Usuario nao encontrado!");
	    		 alerta.showAndWait();
	    	 }
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
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