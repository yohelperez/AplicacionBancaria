package co.edu.udea.tecnicas.cuentas.controller;

import co.edu.udea.tecnicas.cuentas.controller.ContenedorPrincipalController.VentanasEnum;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IngresarUsuarioController extends BaseController {
 

	@FXML
	private TextField txtUsuario;
	@FXML
	private PasswordField txtContrasenia;
	
	public void btnAceptar_action() {
		String usuario=txtUsuario.getText();
		String contrasenia= txtContrasenia.getText();
		boolean formularioValido= validarCampos(usuario, contrasenia);
		if(formularioValido) {
			contenedorPadre.cambiarVentana("menu-usuario");
		}
		else {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.setTitle("INGRESAR");
			alert.setHeaderText("Hay Campos Vacios");
			alert.setContentText("Diligencie todos los campos por favor");
			alert.showAndWait();
		}
		
	}
	
	private boolean validarCampos(String usuario, String contrasenia) {
		boolean valido=true;
		if(usuario==null || "".equals(usuario.trim())) {
			valido=false;
		}
		if("".equals(contrasenia)) {
			valido=false;
		}
		return valido;
	}
	
	public void procesarMensaje(Object mensaje) {
		
	}

}
