package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.CajaDao;
import co.edu.udea.tecnicas.cuentas.model.Caja;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CajaDaoList implements CajaDao {


    private static List<Caja> cajas = new ArrayList<>();

    @Override
    public void guardarCaja(Caja caja) {
        caja.setId(cajas.size() + 1);
        cajas.add(caja);
    }

    @Override
    public Boolean loginCaja(Caja cajaAuth) {
        for(Caja caja : cajas){
            if (caja.getIdentificacion().equals(cajaAuth.getIdentificacion()) && caja.getPassword().equals(cajaAuth.getPassword())){
                return true;
            }
        }
        return false;
    }

    private Optional<Caja> buscarCajasPorId(Integer id) {
        Optional<Caja> cajaOptional = Optional.empty();
        for (Caja caja : cajas) {
            if (id.equals(caja.getId())) {
                cajaOptional = Optional.of(caja);
                break;
            }
        }
        return cajaOptional;
    }
}
