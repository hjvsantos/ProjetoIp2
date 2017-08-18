package gui;

import java.io.IOException;

import hope.instituicao.Instituicao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Mestre extends Application {
	
	private static Mestre instance;
	
	public static Mestre getInstance(){
		if(instance == null){
			instance = new Mestre();
		}
		return instance;
	}
	
	
	private Stage primaryStage;
	private Pane rootScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		instance = this;
		this.primaryStage = primaryStage;
		this.primaryStage.setResizable(false);
		this.primaryStage.setTitle("Menu Inicial HOPE");
		this.rootScene = new Pane();
		
		Scene scene = new Scene(this.rootScene, 900, 600);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		
		this.carregarTela();
		
	}
	
	
	private void carregarTela(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mestre.class.getResource("/gui/Tela_Menu_Inicial.fxml"));
			Pane pane = (Pane) loader.load();
			
			this.rootScene.getChildren().add(pane);
			Tela_Menu_InicialController controller = loader.getController();
			controller.setApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void changeStage(Stage stage){
		this.primaryStage = stage;
	}
	
	public Stage getPrimaryStage(){
		return this.primaryStage;
	}
	
	public Pane getRootScene(){
		return this.rootScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

