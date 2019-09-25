package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.dao.CuentaDao;
import co.edu.udea.tecnicas.cuentas.dao.implementations.CuentaDaoList;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

import java.math.BigDecimal;

public class CuentaBsn {
    private CuentaDao cuentaDao;

    public CuentaBsn() {
        this.cuentaDao = new CuentaDaoList();
    }

    public void registrar(Cuenta cuenta){
        //todo validacion y logica registrar
    }

    public void eliminar(Cuenta cuenta){
        //todo logica y validacion eliminar
    }

    public void consignar(Cuenta cuenta, BigDecimal monto){
     //todo logica y validacion consignar
    }

}
