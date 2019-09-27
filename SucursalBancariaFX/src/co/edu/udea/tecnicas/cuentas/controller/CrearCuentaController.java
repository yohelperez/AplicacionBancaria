package co.edu.udea.tecnicas.cuentas.controller;

import co.edu.udea.tecnicas.cuentas.bsn.CuentaBsn;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CrearCuentaController extends BaseController {
	
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtUsuario;
	@FXML
	private TextField txtContrasenia;
	
	private CuentaBsn cuentaBsn= new CuentaBsn();
	
	public void procesarMensaje(Object mensaje) {
		
	}
	public void btnAceptar_action() {
		String nombre=txtNombre.getText();
		String apellido=txtApellido.getText();
		String usuario=txtUsuario.getText();
		String contrasenia= txtContrasenia.getText();
		boolean formularioValido=validarCampos(nombre, apellido, usuario, contrasenia);
		if(formularioValido) {
			Cuenta cuenta= new Cuenta(nombre, apellido, usuario, contrasenia);
			cuentaBsn.registrar(cuenta); 
			Alert alert= new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Registro de Cuenta");
			alert.setHeaderText("Cuenta Creada Correctamente!");
			alert.setContentText("Nombre: " + cuenta.getNombre() + " " + cuenta.getApellido() +
					"\nUsuario: " + cuenta.getUsuario() +
					"\nNumero de Cuenta: " + cuenta.getId());
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
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtContrasenia.setText("");
	}
	
}
