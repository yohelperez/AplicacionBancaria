package co.edu.udea.tecnicas.cuentas.dao;

import co.edu.udea.tecnicas.cuentas.model.Cuenta;

public interface CuentaDao {
    void guardarCuenta(Cuenta cuenta);
    void eliminarCuenta(Cuenta cuenta);
    Boolean loginAccount(Cuenta cuentaAuth);

}
