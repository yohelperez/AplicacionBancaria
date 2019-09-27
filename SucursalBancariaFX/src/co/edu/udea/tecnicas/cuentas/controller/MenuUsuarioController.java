package co.edu.udea.tecnicas.cuentas.controller;

import java.awt.Button;
import java.awt.event.ActionEvent;

import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MenuUsuarioController extends BaseController {

	@FXML
	private TextField txtNombres;
	@FXML 
	private TextField txtNumeroCuenta; 
	@FXML
	private TextField txtSaldo;
	@FXML
	private TextField txtNumeroCuentaTransferir;
	@FXML
	private TextField txtMontoTransferir;
	
	public void asignarDatos() {
		txtNombres.setText(ContenedorPrincipalController.cuentaUsuario.getNombre() + " " + contenedorPadre.cuentaUsuario.getApellido());
		txtNumeroCuenta.setText(contenedorPadre.cuentaUsuario.getId().toString());
		txtSaldo.setText(contenedorPadre.cuentaUsuario.getSaldo().toString());
		
	}
	public void btnConsignar_action() {
		asignarDatos();
	}
	
	public void btnEliminarCuenta_action() {
		
	}
	
	@Override
	public void procesarMensaje(Object mensaje) {
		// TODO Auto-generated method stub
		
	}
	
	private void limpiarCampos() {
		txtMontoTransferir.setText("");
		
	}

}
