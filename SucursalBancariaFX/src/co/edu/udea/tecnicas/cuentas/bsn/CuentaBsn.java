package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.bsn.exceptions.NonExistAccountException;
import co.edu.udea.tecnicas.cuentas.dao.CuentaDao;
import co.edu.udea.tecnicas.cuentas.dao.exceptions.DuplicatedKeyException;
import co.edu.udea.tecnicas.cuentas.dao.exceptions.EmptyListException;
import co.edu.udea.tecnicas.cuentas.dao.implementations.CuentaDaoList;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Optional;

public class CuentaBsn {
    private CuentaDao cuentaDao;

    public CuentaBsn() {
        this.cuentaDao = new CuentaDaoList();
    }

    public boolean registrar(Cuenta cuenta) {
        try {
            cuentaDao.guardarCuenta(cuenta);
            return true;
        } catch (DuplicatedKeyException ex) {
            return false;//De lanzarse, el controlador debe informar que el nombre de usuario
            //está repetido.
        }
    }

    public boolean eliminar(Cuenta cuenta) {
        if (cuenta.getSaldo().equals(BigDecimal.ZERO)) {//Borra la cuenta si no tiene saldo
            return cuentaDao.eliminarCuenta(cuenta);
        }
        return false;
    }

    public Cuenta login(Cuenta cuenta) {
        Optional<Cuenta> cuentaOptional = Optional.empty();

        try {
            cuentaOptional = Optional.of(cuentaDao.loginAccount(cuenta));
        } catch (EmptyListException ex) {
            return null;
        }

        if (cuentaOptional.isPresent()) {
            return cuentaOptional.get();
        }
        return null;//si retorna null debe mostrar en vista el mensaje de user/pass incorrecto.
    }

    public Cuenta getCuentaTransaccional(Cuenta transAccount) throws NonExistAccountException {
        CuentaDaoList cuentaDaoList = new CuentaDaoList();
        Optional<Cuenta> cuentaOptional = Optional.empty();
        cuentaOptional = cuentaDaoList.buscarCuentaPorId(transAccount.getId());
        if (cuentaOptional.isPresent()){
            return cuentaOptional.get();
        }
        throw new NonExistAccountException(); //En caso de que no exista la cuenta de destino de la transaccion.
    }

}
