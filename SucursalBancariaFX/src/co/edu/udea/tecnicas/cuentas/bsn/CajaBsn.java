package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.dao.CajaDao;
import co.edu.udea.tecnicas.cuentas.dao.implementations.CajaDaoList;
import co.edu.udea.tecnicas.cuentas.model.Caja;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

import java.math.BigDecimal;

public class CajaBsn {
    private CajaDao cajaDao;

    public CajaBsn() {
        this.cajaDao = new CajaDaoList();
    }

    public void registrar(Caja caja){
        //todo logica y validacion registrar caja
    }

    public void ingresarDinero(Cuenta cuenta, BigDecimal monto){
        //todo logica y validacion ingresar dinero
    }

    public void retirarDinero(Cuenta cuenta, BigDecimal monto){
        //todo logica y validacion retirar efectivo
    }

}
