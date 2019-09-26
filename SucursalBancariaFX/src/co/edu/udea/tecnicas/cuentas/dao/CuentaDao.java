package co.edu.udea.tecnicas.cuentas.dao;

import co.edu.udea.tecnicas.cuentas.model.Cuenta;

public interface CuentaDao {
    public void guardarCuenta(Cuenta cuenta);
    public void eliminarCuenta(Cuenta cuenta);
}
