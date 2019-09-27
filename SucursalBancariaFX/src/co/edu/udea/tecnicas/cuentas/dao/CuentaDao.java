package co.edu.udea.tecnicas.cuentas.dao;

import co.edu.udea.tecnicas.cuentas.dao.exceptions.DuplicatedKeyException;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

public interface CuentaDao {
    void guardarCuenta (Cuenta cuenta) throws DuplicatedKeyException;
    Boolean eliminarCuenta(Cuenta cuenta);
    Cuenta loginAccount(Cuenta cuentaAuth);

}
