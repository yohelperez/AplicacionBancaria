package co.edu.udea.tecnicas.cuentas.controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Optional;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import co.edu.udea.tecnicas.cuentas.bsn.ConsignacionBsn;
import co.edu.udea.tecnicas.cuentas.bsn.CuentaBsn;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import co.edu.udea.tecnicas.cuentas.dao.implementations.CuentaDaoList;
import co.edu.udea.tecnicas.cuentas.model.Consignacion;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
	private CuentaBsn cuentaBsn= new CuentaBsn();
	
	public void btnMostrarDatos_action() {
		txtNombres.setText(ContenedorPrincipalController.cuentaUsuario.getNombre() + " " + ContenedorPrincipalController.cuentaUsuario.getApellido());
		txtNumeroCuenta.setText(ContenedorPrincipalController.cuentaUsuario.getId().toString());
		txtSaldo.setText(ContenedorPrincipalController.cuentaUsuario.getSaldo().toString());
		
	}
	public void btnConsignar_action() {
		ConsignacionBsn consignacionBsn= new ConsignacionBsn();
		String numeroCuenta=txtNumeroCuentaTransferir.getText();
		String monto= txtMontoTransferir.getText();
		boolean formularioValido=validarCampos(numeroCuenta, monto);
		Optional<Cuenta>cuenta= CuentaDaoList.buscarCuentaPorId(Integer.parseInt(numeroCuenta));
		if(formularioValido) {
			if(cuenta.isPresent()) {
				Cuenta cuentaDestino=cuenta.get();
				BigDecimal valor= new BigDecimal(monto);
				Consignacion consignacion= new Consignacion(valor, contenedorPadre.cuentaUsuario, cuentaDestino);
				boolean resultado=consignacionBsn.consignar(consignacion);
				if(resultado) {
					Alert alert= new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("RESULTADO DE LA CONSIGNACION");
					alert.setHeaderText("Consignacion Realizada Correctamente!");
					alert.showAndWait();
				}
				else {
					Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setTitle("RESULTADO DE LA CONSIGNACION");
					alert.setHeaderText("ERROR:\nEl monto a consignar excede el valor maximo");
					alert.showAndWait();
				}
			}
			else {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setTitle("RESULTADO DE LA CONSIGNACION");
				alert.setHeaderText("ERROR:\nLa cuenta no existe");
				alert.showAndWait();
			}
		}
	}
	
	public void btnEliminarCuenta_action() {
		boolean eliminado= cuentaBsn.eliminar(contenedorPadre.cuentaUsuario);
		if(eliminado) {
			Alert alert= new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Cuenta Eliminada");
			alert.showAndWait();
			
			contenedorPadre.cambiarVentana("crear-cuenta");
		}
		else {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("No Posible Eliminar La Cuenta");
			alert.setContentText("Para eliminar su cuenta, el saldo debe ser $0");
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
	
	
	@Override
	public void procesarMensaje(Object mensaje) {
		// TODO Auto-generated method stub
		
	}
	
	private void limpiarCampos() {
		txtMontoTransferir.setText("");
	}

}
