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
        cuentaDao.guardarCuenta(cuenta);
    }

    public void eliminar(Cuenta cuenta){
        if (cuenta.getSaldo().equals(BigDecimal.ZERO)){//Borra la cuenta si no tiene saldo
            cuentaDao.eliminarCuenta(cuenta);
        }//todo lanzar excepcion en caso de no poder borrar la cuenta
    }

    public boolean login(Cuenta cuenta){
        if (cuentaDao.loginAccount(cuenta)){
            return true;
        }
        return false;//si retorna false debe mostrar en vista el mensaje de user/pass incorrecto.
    }

}
