package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tela_Doacao_Produto_JuridicoController {
	@FXML
	private Button bt_doar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML
	private ChoiceBox cb_tipoDoacao;
	
	@FXML
	private Integer tf_quantidade;
	
	@FXML
	private TextField tf_observacao; 
	
	private Fachada fachada;
	
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
	
	
	public void Cancelar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("gui/Tela_Principal_Doador_Juridico.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("gui/Tela_Doacao_Produto_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
