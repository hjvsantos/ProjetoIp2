package gui;

import java.io.IOException;

import hope.administrador.Adm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Mestre extends Application {
	
	private Adm acesso = null;
	private Stage primaryStage;
	private BorderPane rootLayout;
	private static Mestre instancia;
	
	public static Mestre getInstance(){
		if (instancia == null) {
			instancia = new Mestre();
		}
		return instancia;
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("HOPE");
		this.primaryStage.setResizable(false);
		
		initRootLayout();
		if(acesso == null){
			showLogin();
		}
	}
	
	private void initRootLayout(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mestre.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showLogin(){
		try{
			FXMLLoader loader = new FXMLLoader();
			//TODO conferir se o path ta correto!!
			loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Login.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();

			rootLayout.setCenter(Login);
			Tela_LoginController controller = loader.getController();
			controller.setMestre(this);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void showLoginAdm(){
		try{
			FXMLLoader loader = new FXMLLoader();
			//TODO conferir se o path ta correto!!
			loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Login_Adm.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();

			rootLayout.setCenter(Login);
			Tela_LoginController controller = loader.getController();
			controller.setMestre(this);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void Tela_Menu_Inicial(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Menu_Inicial.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			//TODO tem que ver se o da gnt ta no anchorPane tb
			
			rootLayout.setCenter(Login);
			Tela_LoginController controller = loader.getController();
			controller.setMestre(this);
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public void Tela_Login() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Login.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();

			rootLayout.setCenter(Login);
			Tela_LoginController controller = loader.getController();
			controller.setMestre(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Tela_Login_Adm() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Login_Adm.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();

			rootLayout.setCenter(Login);
			Tela_LoginController controller = loader.getController();
			controller.setMestre(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastroAdministrador() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Novo_Adm.fxml"));
			AnchorPane cadastro = (AnchorPane) loader.load();

			rootLayout.setCenter(cadastro);
			Tela_LoginController controller = loader.getController();
			controller.setMestre(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastroInstituicao(){
		try{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Nova_Instituicao.fxml"));
		AnchorPane cadastro = (AnchorPane) loader.load();

		rootLayout.setCenter(cadastro);
		Tela_Nova_InstituicaoController controller = loader.getController();
		controller.setMestre(this);

	} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	public void cadastroDoadorPessoa(){
		try{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Novo_Doador_Fisico.fxml"));
		AnchorPane cadastro = (AnchorPane) loader.load();

		rootLayout.setCenter(cadastro);
		Tela_Novo_Doador_FisicoController controller = loader.getController();
		controller.setMestre(this);

	} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	public void cadastroDoadorEmpresa(){
		try{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Mestre.class.getResource("/ProjetoIp2/src/gui/Tela_Novo_Doador_Juridico.fxml"));
		AnchorPane cadastro = (AnchorPane) loader.load();

		rootLayout.setCenter(cadastro);
		Tela_Novo_Doador_JuridicoController controller = loader.getController();
		controller.setMestre(this);

	} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
	
	
}

