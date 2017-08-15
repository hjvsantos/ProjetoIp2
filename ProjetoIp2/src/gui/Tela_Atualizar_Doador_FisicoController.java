package gui;

import aplicacao.Fachada;
import hope.doador.DoadorPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Tela_Atualizar_Doador_FisicoController {
	
	@FXML private TextField tf_Nome_DoadorFisico;
	@FXML private TextField tf_Idade_DoadorFisico;
	@FXML private TextField tf_CPF_DoadorFisico;
	@FXML private TextField tf_Cidade_DoadorFisico;
	@FXML private TextField tf_Estado_DoadorFisico;
	@FXML private TextField tf_Senha_DoadorFisico;
	@FXML private TextField tf_cardNnumber_DoadorFisico;
	@FXML private TextField tf_codCard_DoadorFisico;
	@FXML private TextField tf_codDoador_DoadorFisico;
	@FXML private TextField tf_validadeCard_DoadorFisico;
	@FXML private TextField tf_bandeiraCard_DoadorFisico;
	
	@FXML
	private Button bt_atualizar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML
	private Button bt_buscar_DoadorFisico;
	
	private Fachada fachada;
		
		
		@FXML
		public void buscar_DoadorFisico() {
			try {
		    	 this.fachada = Fachada.getInstance();
		    	 Integer codDoador = Integer.valueOf(tf_codDoador_DoadorFisico.getText());
		    	 DoadorPessoa doador = this.fachada.buscarDoadorPessoa(codDoador);
		    	 if(doador != null) {
		    		 this.tf_codDoador_DoadorFisico.setEditable(false);
		    		 this.tf_CPF_DoadorFisico.setText(doador.getCpf());
		    		// this.tf_Idade_DoadorFisico.setText(doador.getIdade());
		    		 this.tf_Nome_DoadorFisico.setText(doador.getNome());
		    		 this.tf_Cidade_DoadorFisico.setText(doador.getCidade());
		    		 this.tf_Estado_DoadorFisico.setText(doador.getEstado());
		    		 this.tf_Senha_DoadorFisico.setText(doador.getSenha());
		    		 this.tf_bandeiraCard_DoadorFisico.setText(doador.getBandeira());
		    		 this.tf_validadeCard_DoadorFisico.setText(doador.getValidade());
		    		 this.tf_cardNnumber_DoadorFisico.setText(doador.getNumeroCartao());
		    		 this.tf_codCard_DoadorFisico.setText(doador.getCodigoCartao());
		    	 }
		    	 else
		    	 {
		    		 this.tf_CPF_DoadorFisico.setEditable(false);
		    		 this.tf_Nome_DoadorFisico.setEditable(false);
		    		 this.tf_Cidade_DoadorFisico.setEditable(false);
		    		 this.tf_Estado_DoadorFisico.setEditable(false);
		    		 this.tf_Senha_DoadorFisico.setEditable(false);
		    		 this.tf_bandeiraCard_DoadorFisico.setEditable(false);
		    		 this.tf_validadeCard_DoadorFisico.setEditable(false);
		    		 this.tf_cardNnumber_DoadorFisico.setEditable(false);
		    		 this.tf_codCard_DoadorFisico.setEditable(false);
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
		public void atualizarDoadorFisico() {
			try {
				this.fachada = Fachada.getInstance();
				String cpf = this.tf_CPF_DoadorFisico.getText();
				Integer idade = Integer.valueOf(tf_Idade_DoadorFisico.getText());
				String nome = this.tf_Nome_DoadorFisico.getText();
				String cidade = this.tf_Cidade_DoadorFisico.getText();
				String estado = this.tf_Estado_DoadorFisico.getText();
				String numeroCard = this.tf_cardNnumber_DoadorFisico.getText();
				String cod_cartao = this.tf_codCard_DoadorFisico.getText();
				Integer codDoador = Integer.valueOf(tf_codDoador_DoadorFisico.getText());
				String bandeira = this.tf_bandeiraCard_DoadorFisico.getText();
				String validade = this.tf_validadeCard_DoadorFisico.getText();
				String senha = this.tf_Senha_DoadorFisico.getText();
				DoadorPessoa doadorFisico = new DoadorPessoa(cpf, idade, nome, 0, cidade, estado, numeroCard, cod_cartao, codDoador , bandeira, validade, senha);
				doadorFisico.setCpf(cpf);
				doadorFisico.setIdade(Integer.valueOf(tf_Idade_DoadorFisico.getText()));
				doadorFisico.setNome(nome);
				doadorFisico.setCidade(cidade);
				doadorFisico.setEstado(estado);
				doadorFisico.setNumeroCartao(numeroCard);
				doadorFisico.setCodigoCartao(cod_cartao);
				doadorFisico.setBandeira(bandeira);
				doadorFisico.setValidade(validade);
				doadorFisico.setSenha(senha);
				this.fachada.atualizarDoadorPessoa(doadorFisico);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public void CancelarUptadeDF(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Doador_Fisico.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Atualizar_Doador_Fisico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
