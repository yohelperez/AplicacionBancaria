package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.bsn.exceptions.ExceededAmmountException;
import co.edu.udea.tecnicas.cuentas.bsn.exceptions.IllegalTransactionException;
import co.edu.udea.tecnicas.cuentas.bsn.exceptions.InsufficientBalanceException;
import co.edu.udea.tecnicas.cuentas.dao.ConsignacionDao;
import co.edu.udea.tecnicas.cuentas.dao.implementations.ConsignacionDaoList;
import co.edu.udea.tecnicas.cuentas.model.Caja;
import co.edu.udea.tecnicas.cuentas.model.Consignacion;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.math.BigDecimal;

public class ConsignacionBsn {
    private ConsignacionDao consignacionDao;

    public ConsignacionBsn() {
        this.consignacionDao = new ConsignacionDaoList();
    }

    public Boolean consignar(Consignacion consignacion) throws IllegalTransactionException, InsufficientBalanceException,
            ExceededAmmountException {

        //validacion autoconsignación.
        if (consignacion.getOrigen().equals(consignacion.getDestino())){
            throw new IllegalTransactionException();
        }

        if (consignacion.getOrigen() instanceof Caja) {
            if (consignacion.getMonto().compareTo(new BigDecimal("10000000.00")) < 0) {
                consignacionDao.guardarConsignacion(consignacion);
                return true;
            }throw new ExceededAmmountException();
        } else if (consignacion.getOrigen() instanceof Cuenta) {

            //validación saldo suficiente
            if (((Cuenta) consignacion.getOrigen()).getSaldo().compareTo(consignacion.getMonto())<0){
                throw new InsufficientBalanceException();
            }
            //validación limite permitido por consignación desde cuenta.
            if (consignacion.getMonto().compareTo(new BigDecimal("99000000.00")) < 0) {
                consignacionDao.guardarConsignacion(consignacion);
                return true;
            }throw new ExceededAmmountException();
        }
        return false;
    }
}
