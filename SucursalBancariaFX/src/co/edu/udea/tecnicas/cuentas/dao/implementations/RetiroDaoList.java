package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.RetiroDao;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import co.edu.udea.tecnicas.cuentas.model.Retiro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RetiroDaoList implements RetiroDao {

    private static List<Retiro> retiros = new ArrayList<>();

    @Override
    public void guardarRetiro(Retiro retiro) {
        retiro.setId(retiros.size() + 1);
        retiros.add(retiro);
    }

    public Integer contarRetirosEnElDia(Cuenta cuenta){
        Integer retirosAlDia = 0;

        for(Retiro retiro : retiros){
            if (retiro.getCuenta().equals(cuenta) && retiro.getFecha().equals(LocalDateTime.now())){
                retirosAlDia++;
            }
        }
        return retirosAlDia;
    }

    
}
