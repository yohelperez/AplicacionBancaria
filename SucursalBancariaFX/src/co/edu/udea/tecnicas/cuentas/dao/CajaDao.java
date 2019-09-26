package co.edu.udea.tecnicas.cuentas.dao;

import co.edu.udea.tecnicas.cuentas.model.Caja;

import java.util.List;

public interface CajaDao {
    void guardarCaja(Caja caja);
    Boolean loginCaja(Caja cajaAuth);
}
