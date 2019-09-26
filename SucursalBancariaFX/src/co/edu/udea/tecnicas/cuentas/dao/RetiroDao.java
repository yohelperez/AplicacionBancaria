package co.edu.udea.tecnicas.cuentas.dao;

import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import co.edu.udea.tecnicas.cuentas.model.Retiro;

public interface RetiroDao {
    void guardarRetiro(Retiro retiro);
    Integer contarRetirosEnElDia(Cuenta cuenta);
}
