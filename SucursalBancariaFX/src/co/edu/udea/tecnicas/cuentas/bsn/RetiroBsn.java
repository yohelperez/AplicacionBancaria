package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.dao.RetiroDao;
import co.edu.udea.tecnicas.cuentas.dao.implementations.RetiroDaoList;
import co.edu.udea.tecnicas.cuentas.model.Retiro;

public class RetiroBsn {
    private RetiroDao retiroDao;

    public RetiroBsn() {
        this.retiroDao = new RetiroDaoList();
    }

    public Boolean retirar(Retiro retiro){
        if (retiroDao.contarRetirosEnElDia(retiro.getCuenta()).compareTo(7)<0){
            retiroDao.guardarRetiro(retiro);
            return true;
        }//todo limit exceeded exception
        return false;
    }
}
