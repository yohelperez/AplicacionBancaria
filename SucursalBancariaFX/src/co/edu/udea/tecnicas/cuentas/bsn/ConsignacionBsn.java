package co.edu.udea.tecnicas.cuentas.bsn;

import co.edu.udea.tecnicas.cuentas.dao.ConsignacionDao;
import co.edu.udea.tecnicas.cuentas.dao.implementations.ConsignacionDaoList;
import co.edu.udea.tecnicas.cuentas.model.Consignacion;

public class ConsignacionBsn {
    private ConsignacionDao consignacionDao;

    public ConsignacionBsn() {
        this.consignacionDao = new ConsignacionDaoList();
    }

    public void registrarConsignacion(Consignacion consignacion){
        //todo logica y validacion registrar consignacion
    }
}
