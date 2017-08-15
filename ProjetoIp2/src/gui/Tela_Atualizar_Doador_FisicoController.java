package gui;

import aplicacao.Fachada;
import hope.doador.DoadorPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela_Atualizar_Doador_FisicoController {
	
	@FXML private TextField tf_Nome_DoadorFisico;
	@FXML private TextField tf_CPF_DoadorFisico;
	@FXML private TextField tf_Cidade_DoadorFisico;
	@FXML private TextField tf_Estado_DoadorFisico;
	@FXML private TextField tf_Senha_DoadorFisico;
	@FXML private TextField tf_cardNnumber_DoadorFisico;
	@FXML private TextField tf_codCard_DoadorFisico;
	@FXML private TextField tf_validadeCard_DoadorFisico;
	@FXML private TextField tf_bandeiraCard_DoadorFisico;
	
	@FXML
	private Button bt_atualizar;
	
	@FXML
	private Button bt_cancelar;
	
	private Fachada fachada;
		@FXML
		public void atualizarDoadorFisico() {
			try {
				this.fachada = Fachada.getInstance();
				String cpf = this.tf_CPF_DoadorFisico.getText();
				String nome = this.tf_Nome_DoadorFisico.getText();
				String cidade = this.tf_Cidade_DoadorFisico.getText();
				String estado = this.tf_Estado_DoadorFisico.getText();
				String numeroCard = this.tf_cardNnumber_DoadorFisico.getText();
				String cod_cartao = this.tf_codCard_DoadorFisico.getText();
				String bandeira = this.tf_bandeiraCard_DoadorFisico.getText();
				String validade = this.tf_validadeCard_DoadorFisico.getText();
				String senha = this.tf_Senha_DoadorFisico.getText();
				DoadorPessoa doadorFisico = new DoadorPessoa(cpf, 0, nome, 0, cidade, estado, numeroCard, cod_cartao, null , bandeira, validade, senha);
				doadorFisico.setCpf(cpf);
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
