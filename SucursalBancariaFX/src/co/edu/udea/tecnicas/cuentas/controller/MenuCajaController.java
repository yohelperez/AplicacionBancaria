package co.edu.udea.tecnicas.cuentas.controller;

import co.edu.udea.tecnicas.cuentas.bsn.ConsignacionBsn;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MenuCajaController extends BaseController {

	@FXML
	private TextField txtIdentificacion;
	@FXML
	private TextField txtNumeroCuenta;
	
	
	public void btnMostrarDatos_action() {
		txtIdentificacion.setText(ContenedorPrincipalController.cuentaCaja.getIdentificacion());
		txtNumeroCuenta.setText(ContenedorPrincipalController.cuentaCaja.getId().toString());
	}
	
	
	public void btnRetirar_action() {
		
	}
	
	public void btnConsignar_action() {
		ConsignacionBsn consignacionBsn= new ConsignacionBsn();
	}
	
	@Override
	public void procesarMensaje(Object mensaje) {
		// TODO Auto-generated method stub
		
	}

}
