package co.edu.udea.tecnicas.cuentas.bsn;

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

    public void consignar(Consignacion consignacion) {

        if (consignacion.getOrigen() instanceof Caja) {
            if (consignacion.getMonto().compareTo(new BigDecimal("10000000.00")) < 0) {
                consignacionDao.guardarConsignacion(consignacion);
            }//todo exception for exceeded ammount available
        } else if (consignacion.getOrigen() instanceof Cuenta) {
            if (consignacion.getMonto().compareTo(new BigDecimal("99000000.00")) < 0) {
                consignacionDao.guardarConsignacion(consignacion);
            }//todo exception for exceeded ammount available from Cuenta
        }

    }
}
