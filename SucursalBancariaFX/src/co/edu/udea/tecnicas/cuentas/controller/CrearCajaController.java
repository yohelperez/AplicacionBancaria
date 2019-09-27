package co.edu.udea.tecnicas.cuentas.controller;

import co.edu.udea.tecnicas.cuentas.bsn.CajaBsn;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import co.edu.udea.tecnicas.cuentas.model.Caja;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CrearCajaController extends BaseController{
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtContrasenia;
	
	private CajaBsn cajaBsn= new CajaBsn();
	
	public void btnAceptar_action() {
		String id=txtId.getText();
		String contrasenia=txtContrasenia.getText();
		boolean formularioValido=validarCampos(id, contrasenia);
		if(formularioValido) {
			Caja caja= new Caja(id,contrasenia);
			cajaBsn.registrar(caja); 
			Alert alert= new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("REGISTRO DE CAJA");
			alert.setHeaderText("Cuenta Creada Correctamente!");
			alert.setContentText("IDENTIFICACION: " + caja.getIdentificacion());
			alert.showAndWait();
			limpiarCampos();
		}
		else {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.setTitle("REGISTRO DE CUENTA");
			alert.setHeaderText("Hay Campos Vacios");
			alert.setContentText("Diligencie todos los campos por favor");
			alert.showAndWait();
		}
	}
	
	private boolean validarCampos(String... campos) {
		boolean valido= true;
		for(String campo:campos) {
			if(campo==null || "".equals(campo.trim())){
				valido=false;
				break;
			}
		}
		return valido;
	}
	
	private void limpiarCampos() {
		txtId.setText("");
		txtContrasenia.setText("");
	}
	
	public void procesarMensaje(Object mensaje) {
		
	}


}
