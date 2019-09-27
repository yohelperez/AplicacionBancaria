package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.ConsignacionDao;
import co.edu.udea.tecnicas.cuentas.model.Consignacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsignacionDaoList implements ConsignacionDao {
    private static List<Consignacion> consignaciones = new ArrayList<>();

    @Override
    public void guardarConsignacion(Consignacion consignacion) {
        consignacion.setId(consignaciones.size() + 1);
        consignaciones.add(consignacion);
    }

}
