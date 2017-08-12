package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tela_Principal_AdmController {
	
	@FXML
	private Button bt_atualizar;
	
	@FXML
	private Button bt_excluirConta;
	
	@FXML
	private Button bt_excluirDoador;
	
	@FXML
	private Button bt_excluirInstituicao;
	
	@FXML
	private Button bt_listarDoadorFisico;
	
	@FXML
	private Button bt_listarDoadorJuridico;
	
	@FXML
	private Button bt_listarInstituicoes;
	
	@FXML
	private Button bt_novoCadastro;
	
	@FXML
	private Button bt_sair;
	
	private void fecharTelaAction(){
	    Stage stage = (Stage) bt_sair.getScene().getWindow(); 
	    stage.close(); 
	}
	
	public void AtualizarAdm(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_atualizar) {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Atualizar_Adm.fxml"));
			} else {
				stage = (Stage) bt_atualizar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ExcluirContaAdm(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_excluirConta) {
				stage = (Stage) bt_excluirConta.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Confirma_Remocao_Usuario.fxml"));
			} else {
				stage = (Stage) bt_excluirConta.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ExcluirContaDoador(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_excluirDoador) {
				stage = (Stage) bt_excluirDoador.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Remover_Usuarios.fxml"));
			} else {
				stage = (Stage) bt_excluirDoador.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ExcluirContaInstituicao(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_excluirInstituicao) {
				stage = (Stage) bt_excluirInstituicao.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Remover_Usuarios.fxml"));
			} else {
				stage = (Stage) bt_excluirInstituicao.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ListarDoadorFisico(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_listarDoadorFisico) {
				stage = (Stage) bt_listarDoadorFisico.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Lista_Doador_Pessoa.fxml"));
			} else {
				stage = (Stage) bt_listarDoadorFisico.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ListarDoadorJuridico(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_listarDoadorJuridico) {
				stage = (Stage) bt_listarDoadorJuridico.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Lista_Doador_Empresa.fxml"));
			} else {
				stage = (Stage) bt_listarDoadorJuridico.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ListarInstituicoes(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_listarInstituicoes) {
				stage = (Stage) bt_listarInstituicoes.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Lista_Instituicoes.fxml"));
			} else {
				stage = (Stage) bt_listarInstituicoes.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void NovoCadastroAdm(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == bt_novoCadastro) {
				stage = (Stage) bt_novoCadastro.getScene().getWindow();
				root = FXMLLoader.load(
						getClass().getResource("/ProjetoIp2/src/gui/Tela_Novo_Adm.fxml"));
			} else {
				stage = (Stage) bt_novoCadastro.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/ProjetoIp2/src/gui/Tela_Principal_Adm.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
