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

public class Tela_Doacao_Financeira_JuridicoController {
	@FXML
	private Button bt_doar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML
	private Label lb_Doador;
	
	@FXML ChoiceBox instituicaoEscolhida;
	
	@FXML TextField tf_valorDoacao_Juridica;
	
	@FXML Label lb_cidadeDoacao;
	
	@FXML Label lb_estadoDoacao; 
	
	@FXML Label lb_numCard_DoadorJuridico;
	
	@FXML TextField tf_CodigoCard_DoadorJuridico;
	
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
		lb_Doador.setText(" ");
		tf_valorDoacao_Juridica.setText(" ");
		lb_cidadeDoacao.setText(" ");
		lb_estadoDoacao.setText(" ");
		lb_numCard_DoadorJuridico.setText(" ");
		tf_CodigoCard_DoadorJuridico.setText(" ");
	}
	
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Escolha a Instituicao que deseja doar: ");
		button = new Button("OK");
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		Instituicao instituicao = new Instituicao();
		choiceBox.getItems().addAll(this.fachada.buscarI(instituicao.getCodInstituicao()) + instituicao.getNome());
		
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
	
	public void salvarDoacaoJuridica() {
		fachada = Fachada.getInstance();
		String nome = lb_Doador.getText();
		String instituicao = this.getChoice(instituicaoEscolhida);
		Categoria categoria = Categoria.financeiro;
		String valor = tf_valorDoacao_Juridica.getText(); 
		String cidade = lb_cidadeDoacao.getText();
		String estado = lb_estadoDoacao.getText();
		String numCard = lb_numCard_DoadorJuridico.getText();
		String codCard = tf_CodigoCard_DoadorJuridico.getText();
		if((nome != null && nome != " ") && (instituicao != null && instituicao != " ") 
				&& (categoria != null) && (valor != null)
				&& (cidade != null && cidade != " ")
				&& (estado != null && estado != " ")
				&& (numCard != null && numCard != " ")
				&& (codCard != null && codCard != " "))
			 {
			Doacao doacao = new Doacao(nome,instituicao,categoria,valor,cidade,estado,numCard,codCard);
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
	
	public void cancelarDoacaoJuridica(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Juridico.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Doacao_Financeira_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
