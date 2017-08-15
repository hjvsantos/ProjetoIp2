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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela_Atualizar_InstituicaoController {
	
	Fachada fachada = Fachada.getInstance();
	private Mestre mestre;
	
	@FXML
	private Button bt_atualizar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML
	private TextField tx_cidade;
	
	@FXML
	private TextField tx_estado;
	
	@FXML
	private TextField tx_numero;
	
	@FXML
	private Label lb_nome;
	
	@FXML
	private Label lb_cpnj;
	
	@FXML
	private Label lb_codigo;
	
	@FXML
	private Label lb_senha;
	
	/*Instituicao inst = new Instituicao(lb_nome.toString(), lb_cpnj.toString(), tx_cidade.getText(), tx_estado.getText(), Double.valueOf(tx_numero.getText()), Integer.valueOf( lb_codigo.toString()), lb_senha.toString());
	
	public void editar(Action event){
		try{
			if (this.fachada.atualizarInstituicao(inst) == true) {
				Parent root;
				Stage stage;

				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Institução.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				}
			}catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
	
	public void Cancelar(ActionEvent event) {
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
