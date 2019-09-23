package co.edu.udea.tecnicas.cuentas.controller;

import java.io.IOException;

import co.edu.udea.tecnicas.cuentas.controller.base.BaseController;
//import co.edu.udea.tecnicas.cuentas.controller.ContenedorPrincipalController.VentanasEnum
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ContenedorPrincipalController {
	private static final String VIEWS_PATH= "../view/";
	
	@FXML
    private BorderPane contenedorPrincipal;
	
	@FXML
	private void mnuSalir_action() {
		System.exit(0);
		System.out.print("gonorrea");
	}
	
	@FXML
	private void mnuCuentaUsuario_action() {
		
	}
	
	@FXML
	private void mnuCuentaCaja_action() {
		
	}

	@FXML
	private void mnuCrearCuenta_action() {
		cambiarVentana(VentanasEnum.CREAR_CUENTA.nombre);
	}
	
	public void cambiarVentana(String nombreVista) {
        cambiarVentana(nombreVista, null);
    }
	
	public void cambiarVentana(String nombreVista, Object mensaje) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    VIEWS_PATH + nombreVista + ".fxml"));
            AnchorPane view = loader.load();
            contenedorPrincipal.setCenter(view);
            BaseController controller = loader.getController();
            controller.setContenedorPadre(this);
            controller.procesarMensaje(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public enum VentanasEnum{
		CREAR_CUENTA("crear-cuenta");
		
		private String nombre;
		
		VentanasEnum(String nombre){
			this.nombre=nombre;
		}
		
		public String getNombre() {
			return this.nombre;
		}
	}

}