package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.bsn.exceptions.InsufficientBalanceException;
import co.edu.udea.tecnicas.cuentas.bsn.exceptions.TransactionsExceededException;
import co.edu.udea.tecnicas.cuentas.dao.RetiroDao;
import co.edu.udea.tecnicas.cuentas.dao.implementations.RetiroDaoList;
import co.edu.udea.tecnicas.cuentas.model.Retiro;

import java.math.BigDecimal;

public class RetiroBsn {
    private RetiroDao retiroDao;

    public RetiroBsn() {
        this.retiroDao = new RetiroDaoList();
    }

    public Boolean retirar(Retiro retiro) throws InsufficientBalanceException, TransactionsExceededException {
        BigDecimal minValue = new BigDecimal("10000");
        if (retiroDao.contarRetirosEnElDia(retiro.getCuenta()).compareTo(7) < 0) {

            if (retiro.getCuenta().getSaldo().compareTo(retiro.getMonto()) >= 0 ||
                    retiro.getCuenta().getSaldo().compareTo(minValue) >= 0) {
                retiroDao.guardarRetiro(retiro);
                return true;
            } else throw new InsufficientBalanceException();//arroja excepción de saldo insuficiente.
        } else throw new TransactionsExceededException();//arroja excepción de transacciones excedidas.
    }
}
