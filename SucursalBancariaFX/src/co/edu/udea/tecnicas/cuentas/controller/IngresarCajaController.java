package co.edu.udea.tecnicas.cuentas.controller;

import co.edu.udea.tecnicas.cuentas.bsn.CajaBsn;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import co.edu.udea.tecnicas.cuentas.model.Caja;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class IngresarCajaController extends BaseController {

	@FXML
	private TextField txtId;
	@FXML
	private TextField txtContrasenia;
	CajaBsn cajaBsn= new CajaBsn();
	
	public void btnAceptar_action() {
		String id=txtId.getText();
		String contrasenia= txtContrasenia.getText();
		boolean formularioValido=validarCampos(id, contrasenia);
		if(formularioValido) {
			ContenedorPrincipalController.cuentaCaja= new Caja(id, contrasenia);
			ContenedorPrincipalController.cuentaCaja=cajaBsn.loginCaja(ContenedorPrincipalController.cuentaCaja);
			if(ContenedorPrincipalController.cuentaCaja!= null) {
				contenedorPadre.cambiarVentana("menu-caja");
			}
			else {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setTitle("INGRESAR");
				alert.setHeaderText("Identificacion o Contraseña incorrectos");
				alert.setContentText("Verifique los campos por favor");
				alert.showAndWait();
				limpiarCampos();
			}
		}
		else {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.setTitle("INGRESAR");
			alert.setHeaderText("Usuario o Contraseña incorrectos");
			alert.setContentText("Verifique los campos por favor");
			alert.showAndWait();
			limpiarCampos();
		}
	}
	
	
	@Override
	public void procesarMensaje(Object mensaje) {
		// TODO Auto-generated method stub
		
	}
	
	private void limpiarCampos() {
		txtId.setText("");
		txtContrasenia.setText("");
	}
	
	private boolean validarCampos(String id, String contrasenia) {
		boolean valido=true;
		if(id==null || "".equals(id.trim())) {
			valido=false;
		}
		if("".equals(contrasenia)) {
			valido=false;
		}
		return valido;
	}
}
