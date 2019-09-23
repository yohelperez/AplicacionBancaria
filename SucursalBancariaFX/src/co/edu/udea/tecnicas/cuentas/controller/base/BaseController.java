package co.edu.udea.tecnicas.cuentas.controller.base;

import co.edu.udea.tecnicas.cuentas.controller.ContenedorPrincipalController;

public abstract class BaseController {
	
	protected ContenedorPrincipalController contenedorPadre;
	
	public abstract void procesarMensaje(Object mensaje);
	
	public void setContenedorPadre(ContenedorPrincipalController contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
	}
}
