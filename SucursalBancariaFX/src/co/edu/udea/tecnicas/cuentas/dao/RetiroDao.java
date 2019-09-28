package co.edu.udea.tecnicas.cuentas.dao;

import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import co.edu.udea.tecnicas.cuentas.model.Retiro;

import java.math.BigDecimal;

public interface RetiroDao {
    void guardarRetiro(Retiro retiro);
    Integer contarRetirosEnElDia(Cuenta cuenta);
    BigDecimal dineroRetiradoEnElDia(Cuenta cuenta);
}
