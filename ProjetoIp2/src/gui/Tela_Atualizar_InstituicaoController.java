package gui;

import javax.swing.Action;

import hope.administrador.Adm;
import hope.instituicao.Instituicao;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import aplicacao.Fachada;
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

public class Tela_Atualizar_InstituicaoController {
	
	Fachada fachada = Fachada.getInstance();
	private Mestre mestre;
	
	@FXML
	private Button bt_atualizar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML
	private TextField tx_cidade_Instituicao;
	
	@FXML
	private TextField tx_estado_Instituicao;
	
	@FXML
	private TextField tx_numeroConta_Instituicao;
	
	@FXML
	private Label lb_nome;
	
	@FXML
	private Label lb_cpnj;
	
	@FXML
	private Label lb_codigo;
	
	@FXML
	private PasswordField ps_senha_Instituicao;

	public void initialize() {
		 this.tx_cidade_Instituicao.setEditable(false);
		 this.tx_estado_Instituicao.setEditable(false);
		 this.tx_numeroConta_Instituicao.setEditable(false);
	}
	
	@FXML
	public void buscar_Instituicao(){
	     try {
	    	 this.fachada = Fachada.getInstance();
	    	 int codInstituicao = this.lb_codigo.getOffset();
	    	 Instituicao insti = this.fachada.buscarI(codInstituicao);
	    	 if(insti != null) {
	    		 this.tx_cidade_Instituicao.setText(insti.getCidade());
	    		 this.tx_estado_Instituicao.setText(insti.getEstado());
	    		 this.tx_numeroConta_Instituicao.setText(insti.getNumeroConta());
	    		 this.ps_senha_Instituicao.setText(insti.getSenha());
	    	 }
	    	 else
	    	 {
	    		 this.tx_cidade_Instituicao.setEditable(false);
	    		 this.tx_estado_Instituicao.setEditable(false);
	    		 this.tx_numeroConta_Instituicao.setEditable(false);
	    		 this.ps_senha_Instituicao.setEditable(false);
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
	public void atualizar_Instituicao() {
		try {
			this.fachada = Fachada.getInstance();
			String codInsti = this.lb_codigo.toString();
			buscar_Instituicao();
			String cnpj = this.lb_cpnj.toString();
			String nome = this.lb_nome.toString();
			String cidade = this.tx_cidade_Instituicao.getText();
			String estado = this.tx_estado_Instituicao.getText();
			String numeroConta = this.tx_numeroConta_Instituicao.getText();
			String senha = this.ps_senha_Instituicao.getText();
			Instituicao novaInsti = new Instituicao(cnpj, nome, cidade, estado, numeroConta, codInsti, senha);
			novaInsti.setCidade(cidade);
			novaInsti.setEstado(estado);
			novaInsti.setNumeroConta(numeroConta);
			novaInsti.setSenha(senha);
			this.fachada.atualizarInstituicao(novaInsti);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void cancelar_Instituicao(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Instituicao.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Atualizar_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
