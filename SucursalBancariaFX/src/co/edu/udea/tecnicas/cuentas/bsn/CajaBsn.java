package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.dao.CajaDao;
import co.edu.udea.tecnicas.cuentas.dao.exceptions.DuplicatedKeyException;
import co.edu.udea.tecnicas.cuentas.dao.implementations.CajaDaoList;
import co.edu.udea.tecnicas.cuentas.model.Caja;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

import java.math.BigDecimal;
import java.util.Optional;

public class CajaBsn {
    private CajaDao cajaDao;

    public CajaBsn() {
        this.cajaDao = new CajaDaoList();
    }

    public Caja loginCaja(Caja caja) {
        Optional<Caja> cajaOptional = Optional.of(cajaDao.loginCaja(caja));
        if (cajaOptional.isPresent()) {
            return cajaOptional.get();
        }
        return null;
    }

    public Boolean registrar(Caja caja) {
        try {
            cajaDao.guardarCaja(caja);
            return true;
        } catch (DuplicatedKeyException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
