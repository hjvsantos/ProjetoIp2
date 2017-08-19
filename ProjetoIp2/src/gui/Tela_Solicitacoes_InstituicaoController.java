package gui;

import aplicacao.Fachada;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Tela_Solicitacoes_InstituicaoController extends Application{

	@FXML
	private ChoiceBox cb_tipoDoacao;
	@FXML
	TextField tf_quantidade;
	@FXML
	TextField tf_observacao;
	
	@FXML
	private Button bt_cadastrar;
	@FXML
	private Button bt_cancelar;
	
	private Fachada fachada;
	
	@FXML
	public void initialize(){
		fachada = fachada.getInstance();
	}
	
	Stage window;
	Scene scene;
	Button button;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Escolha do tipo de doação");
		
		
		//TODO Add o botão ok na tela
		button = new Button("OK");
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().add("Alimento");
		choiceBox.getItems().add("Diversos");
		choiceBox.getItems().add("Financeira");
		choiceBox.getItems().add("Higiene");
		choiceBox.getItems().add("Vestimenta");
		
		button.setOnAction(e -> getChoice(choiceBox));
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	private void getChoice(ChoiceBox<String> choiceBox){
		String escolha = choiceBox.getValue();
	}
	
	
	public void Cancelar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/gui/Tela_Principal_Instituicao.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/Tela_Solicitacoes_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
