package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.dao.RetiroDao;
import co.edu.udea.tecnicas.cuentas.dao.implementations.RetiroDaoList;
import co.edu.udea.tecnicas.cuentas.model.Retiro;

public class RetiroBsn {
    private RetiroDao retiroDao;

    public RetiroBsn() {
        this.retiroDao = new RetiroDaoList();
    }

    public void registrarConsignacion(Retiro retiro){
        //todo logica y validacion registrar retiro
    }
}
