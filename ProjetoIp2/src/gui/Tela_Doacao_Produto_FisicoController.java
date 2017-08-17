package gui;

import aplicacao.Fachada;
import hope.categoria.Categoria;
import hope.doacao.Doacao;
import hope.excecao.ErroDeNegocioExcecao;
import hope.instituicao.Instituicao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tela_Doacao_Produto_FisicoController {
	@FXML
	private Button bt_doar;
	
	@FXML ChoiceBox cb_tipoDoacao;
	
	@FXML Integer tf_quantidade;
	
	@FXML TextField tf_observacao; 
	
	private Fachada fachada;
	
	@FXML
	public void initialize() {
		fachada = this.fachada.getInstance();
	}
	
	Stage window;
	Scene scene;
	Button button;
	
	@FXML
	public void limparFields() {
		tf_quantidade.intValue();
		tf_observacao.setText(" ");
	}
	
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Escolha o tipo da sua doacao: ");
		button = new Button("OK");
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().add("Alimento");
		choiceBox.getItems().add("Diversos");
		choiceBox.getItems().add("Higiene");
		choiceBox.getItems().add("Vestimenta");
		Doacao doacao = new Doacao();
		choiceBox.getItems().addAll(this.fachada.buscarDoacao(doacao.getCodigo()) + getChoice(cb_tipoDoacao));
		
		button.setOnAction(e -> getChoice(choiceBox));
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	private String getChoice(ChoiceBox<String> choiceBox){
		String escolha = choiceBox.getValue();
		return escolha;
	}
	
	public void salvarDoacaoProduto() {
		fachada = Fachada.getInstance();
		String tipo = this.getChoice(cb_tipoDoacao);
		Integer quantidade = tf_quantidade.intValue();
		String observacao = tf_observacao.getText();
		if((tipo != null) && (quantidade != null)) 
			 {
			Doacao doacao = new Doacao(tipo,quantidade,observacao);
			try {
				fachada.cadastrarDoacao(doacao);
			} catch (ErroDeNegocioExcecao e) {
				e.printStackTrace();
			}
			limparFields();
			Alert alerta = new Alert(AlertType.CONFIRMATION);
   		 	alerta.setTitle("Cadastro realizado com sucesso!");
		}
		else
		{
			Alert alerta = new Alert(AlertType.ERROR);
   		 	alerta.setTitle("ERRO!");
		}
	}
	
	@FXML
	private Button bt_cancelar;
	
	public void cancelarDoacaoProduto(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Fisico.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Doacao_Produto_Fisico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
