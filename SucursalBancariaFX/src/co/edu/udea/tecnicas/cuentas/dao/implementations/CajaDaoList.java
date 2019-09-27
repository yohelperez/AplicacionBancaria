package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.CajaDao;
import co.edu.udea.tecnicas.cuentas.dao.exceptions.DuplicatedKeyException;
import co.edu.udea.tecnicas.cuentas.dao.exceptions.EmptyListException;
import co.edu.udea.tecnicas.cuentas.model.Caja;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CajaDaoList implements CajaDao {


    private static List<Caja> cajas = new ArrayList<>();

    @Override
    public void guardarCaja(Caja caja) throws DuplicatedKeyException {
        for (Caja iterCaja : cajas){
            if (iterCaja.getIdentificacion().equals(caja.getIdentificacion())){
                throw new DuplicatedKeyException();
            }
        }
        caja.setId(cajas.size() + 1);
        cajas.add(caja);
    }

    @Override
    public Caja loginCaja(Caja cajaAuth) throws EmptyListException{
        Integer listSize = cajas.size(), sizeForException = 0;

        if (sizeForException.equals(listSize.compareTo(0))){
            throw new EmptyListException();
        }

        for(Caja caja : cajas){
            if (caja.getIdentificacion().equals(cajaAuth.getIdentificacion()) && caja.getPassword().equals(cajaAuth.getPassword())){
                return caja;
            }
        }
        return null;
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
