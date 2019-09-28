package co.edu.udea.tecnicas.cuentas.controller;

import java.math.BigDecimal;

import co.edu.udea.tecnicas.cuentas.bsn.ConsignacionBsn;
import co.edu.udea.tecnicas.cuentas.bsn.CuentaBsn;
import co.edu.udea.tecnicas.cuentas.bsn.RetiroBsn;
import co.edu.udea.tecnicas.cuentas.bsn.exceptions.IllegalTransactionException;
import co.edu.udea.tecnicas.cuentas.bsn.exceptions.InsufficientBalanceException;
import co.edu.udea.tecnicas.cuentas.bsn.exceptions.NonExistAccountException;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import co.edu.udea.tecnicas.cuentas.model.Consignacion;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import co.edu.udea.tecnicas.cuentas.model.Retiro;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MenuCajaController extends BaseController {

	@FXML
	private TextField txtIdentificacion;
	@FXML
	private TextField txtNumeroCuenta;
	@FXML
	private TextField txtCuentaRetiro;
	@FXML
	private TextField txtMontoRetiro;
	@FXML
	private TextField txtCuentaConsignacion;
	@FXML
	private TextField txtMontoConsignacion;
	
	
	public void btnMostrarDatos_action() {
		txtIdentificacion.setText(ContenedorPrincipalController.cuentaCaja.getIdentificacion());
		txtNumeroCuenta.setText(ContenedorPrincipalController.cuentaCaja.getId().toString());
	}
	private CuentaBsn cuentaBsn= new CuentaBsn();
	
	public void btnRetirar_action() {
		RetiroBsn retiroBsn=new RetiroBsn();
		String cuentaRetiro=txtCuentaRetiro.getText();
		String monto= txtMontoRetiro.getText();
		boolean formularioValido= validarCampos(cuentaRetiro, monto);
		if(formularioValido) {
			Cuenta cuenta=new Cuenta(Integer.parseInt(cuentaRetiro));
			try {
				cuenta=cuentaBsn.getCuentaTransaccional(cuenta);
			}catch (NonExistAccountException ex) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setTitle("RESULTADO DE LA CONSIGNACION");
				alert.setHeaderText(ex.getMessage());
				alert.showAndWait();
				return;
			}
			BigDecimal valor= new BigDecimal(monto);
			Retiro retiro= new Retiro(cuenta, valor);
			
			
			
		}
	}
	
	public void btnConsignar_action() {
		ConsignacionBsn consignacionBsn= new ConsignacionBsn();
		String numeroCuenta=txtCuentaConsignacion.getText();
		String monto= txtMontoConsignacion.getText();
		boolean formularioValido=validarCampos(numeroCuenta, monto);
		if(formularioValido) {
			Cuenta cuenta=new Cuenta(Integer.parseInt(numeroCuenta));
		
			try {
				cuenta=cuentaBsn.getCuentaTransaccional(cuenta);
			}catch (NonExistAccountException ex) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setTitle("RESULTADO DE LA CONSIGNACION");
				alert.setHeaderText(ex.getMessage());
				alert.showAndWait();
				return;
			}
			
			BigDecimal valor= new BigDecimal(monto);
			Consignacion consignacion= new Consignacion(valor, ContenedorPrincipalController.cuentaCaja, cuenta);
			try {
				boolean resultado=consignacionBsn.consignar(consignacion);
			}catch (IllegalTransactionException | InsufficientBalanceException ex) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setTitle("RESULTADO DE LA CONSIGNACION");
				alert.setHeaderText(ex.getMessage());
				alert.showAndWait();
				return;
			}
			
			Alert alert= new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("RESULTADO DE LA CONSIGNACION");
			alert.setHeaderText("Consignacion Realizada Correctamente!");
			alert.showAndWait();
		}
	}
	
	@Override
	public void procesarMensaje(Object mensaje) {
		// TODO Auto-generated method stub
		
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

}
