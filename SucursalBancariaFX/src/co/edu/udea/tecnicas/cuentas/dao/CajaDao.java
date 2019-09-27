package co.edu.udea.tecnicas.cuentas.dao;

import co.edu.udea.tecnicas.cuentas.dao.exceptions.DuplicatedKeyException;
import co.edu.udea.tecnicas.cuentas.model.Caja;

import java.util.List;

public interface CajaDao {
    void guardarCaja(Caja caja) throws DuplicatedKeyException;
    Caja loginCaja(Caja cajaAuth);
}
