package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.ConsignacionDao;
import co.edu.udea.tecnicas.cuentas.model.Consignacion;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsignacionDaoList implements ConsignacionDao {
    private static List<Consignacion> consignaciones = new ArrayList<>();

    @Override
    public void guardarConsignacion(Consignacion consignacion) {
        consignacion.setId(consignaciones.size() + 1);
        //retira dinero de cuenta de origen
        if (consignacion.getOrigen() instanceof Cuenta){
            ((Cuenta) consignacion.getOrigen()).setSaldo(((Cuenta) consignacion.getOrigen()).getSaldo().subtract(consignacion.getMonto()));
        }

        //Carga dinero en destino
        consignacion.getDestino().setSaldo(consignacion.getDestino().getSaldo().add(consignacion.getMonto()));

        consignaciones.add(consignacion);
    }

}
