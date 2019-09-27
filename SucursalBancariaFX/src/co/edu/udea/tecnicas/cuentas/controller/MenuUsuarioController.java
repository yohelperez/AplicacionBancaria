package co.edu.udea.tecnicas.cuentas.controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import co.edu.udea.tecnicas.cuentas.bsn.CuentaBsn;
import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
import co.edu.udea.tecnicas.cuentas.model.Consignacion;
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
		String numeroCuenta=txtNumeroCuentaTransferir.getText();
		String monto= txtMontoTransferir.getText();
		boolean formularioValido=validarCampos(numeroCuenta, monto);
		CuentaBsn cuentaBsn= new CuentaBsn();
		Cuenta cuentaDestino;
		
		if(formularioValido) {
			//if(cuentaBsn.buscarCuentaPorId(Integer.parseInt(numeroCuenta))!=null) {
				//cuentaDestino=cuentaBsn.buscarCuentaPorId(Integer.parseInt(numeroCuenta));
			//}
			BigDecimal valor= new BigDecimal(monto);
			//nsignacion consignacion= new Consignacion(valor, contenedorPadre.cuentaUsuario.getId(), );
		}
	}
	
	public void btnEliminarCuenta_action() {
		
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
