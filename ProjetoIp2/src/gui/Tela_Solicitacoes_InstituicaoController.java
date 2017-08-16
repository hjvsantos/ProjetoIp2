package gui;


import aplicacao.Fachada;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceBoxBuilder;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("deprecation")
public class Tela_Solicitacoes_InstituicaoController extends Application{

	@FXML
	private ChoiceBox cb_tipoDoacao;
	@FXML
	private TextField tf_quantidade;
	@FXML
	private TextField tf_observacao;
	
	@FXML
	private Button bt_cadastrar;
	@FXML
	private Button bt_cancelar;
	
	private Fachada fachada;
	
	@FXML
	public void initialize(){
		fachada = fachada.getInstance();
	}
	
	
	
	
	 ObservableList cursors = FXCollections.observableArrayList(
			 Cursor.DEFAULT);
	 /*
			 Cursor.ALIMENTO,
			 Cursor.HIGIENE,
			 Cursor.DIVERSOS,
			 Cursor.FINANCEIRA);
	*/
	
	 @Override
	    public void start(Stage stage) {
	      ChoiceBox choiceBoxRef = ChoiceBoxBuilder.create().items(cursors).build();
	          
	        VBox box = new VBox();
	        box.getChildren().add(choiceBoxRef);
	        final Scene scene = new Scene(box,300, 250);
	        scene.setFill(null);
	        stage.setScene(scene);
	        stage.show();
	        scene.cursorProperty().bind(choiceBoxRef.getSelectionModel().selectedItemProperty());
	    }
	 public static void main(String[] args) {
	        launch(args);
	    }
	
	/*
	public void TipoDoacao(ActionEvent event){
		
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
			    "Alimento", "Higiene", "Diversos", "Vestimenta", "Financeiro"));
		
	}
	*/
	
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
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Solicitacoes_Instituicao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
