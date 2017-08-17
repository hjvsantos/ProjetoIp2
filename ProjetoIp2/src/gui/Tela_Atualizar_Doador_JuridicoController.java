package gui;

import aplicacao.Fachada;
import hope.doador.DoadorEmpresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela_Atualizar_Doador_JuridicoController {

	
	@FXML private TextField tf_Cidade_DoadorJuridico;
	@FXML private TextField tf_Estado_DoadorJuridico;
	@FXML private TextField tf_Senha_DoadorJuridico;
	@FXML private TextField tf_cardNnumber_DoadorJuridico;
	@FXML private TextField tf_codCard_DoadorJuridico;
	@FXML private Integer tf_codDoador_DoadorJuridico;
	@FXML private TextField tf_validadeCard_DoadorJuridico;
	@FXML private TextField tf_bandeiraCard_DoadorJuridico;
	@FXML private Label lb_nomeDoadorJuridico;
	@FXML private Label lb_cnpj; 
	private Button bt_atualizar;
	
	@FXML
	private Button bt_cancelar;
	
	@FXML
	private Button bt_buscar_DoadorFisico;
	
	private Fachada fachada;
	
	
	
	@FXML
	public void atualizarDoadorJuridico() {
		try {
			this.fachada = Fachada.getInstance();
			String cnpj = this.lb_cnpj.getText();
			String nome = this.lb_nomeDoadorJuridico.getText();
			Integer codDoador = this.tf_codDoador_DoadorJuridico;
			String cidade = this.tf_Cidade_DoadorJuridico.getText();
			String estado = this.tf_Estado_DoadorJuridico.getText();
			String numeroCard = this.tf_cardNnumber_DoadorJuridico.getText();
			String cod_cartao = this.tf_codCard_DoadorJuridico.getText();
			String bandeira = this.tf_bandeiraCard_DoadorJuridico.getText();
			String validade = this.tf_validadeCard_DoadorJuridico.getText();
			String senha = this.tf_Senha_DoadorJuridico.getText();
			DoadorEmpresa doadorJuridico = new DoadorEmpresa(nome,0, cnpj,codDoador, cidade,estado, numeroCard, cod_cartao,bandeira,validade,senha);
			doadorJuridico.setCnpj(cnpj);
			doadorJuridico.setNome(nome);
			doadorJuridico.setCidade(cidade);
			doadorJuridico.setEstado(estado);
			doadorJuridico.setNumeroCartao(numeroCard);
			doadorJuridico.setCodigoCartao(cod_cartao);
			doadorJuridico.setBandeira(bandeira);
			doadorJuridico.setValidade(validade);
			doadorJuridico.setSenha(senha);
			this.fachada.atualizarDoadorEmpresa(doadorJuridico);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void CancelarUpdateDJ(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_cancelar) {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("gui/Tela_Principal_Doador_Juridico.fxml"));
			} else {
				stage = (Stage) bt_cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Atualizar_Doador_Juridico.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
