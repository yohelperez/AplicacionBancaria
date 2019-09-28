package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.RetiroDao;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;
import co.edu.udea.tecnicas.cuentas.model.Retiro;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RetiroDaoList implements RetiroDao {

    private static List<Retiro> retiros = new ArrayList<>();

    @Override
    public void guardarRetiro(Retiro retiro) {
        retiro.setId(retiros.size() + 1);
        retiro.getCuenta().setSaldo(retiro.getCuenta().getSaldo().subtract(retiro.getMonto()));
        retiros.add(retiro);
    }

    public Integer contarRetirosEnElDia(Cuenta cuenta){
        Integer retirosAlDia = 0;
        LocalDateTime today = LocalDateTime.now();

        for(Retiro retiro : retiros){

            if (retiro.getCuenta().equals(cuenta) && retiro.getFecha().isAfter(today.minusDays(1))&&
                    retiro.getFecha().isBefore(today.plusDays(1))){
                retirosAlDia++;
            }
        }
        return retirosAlDia;
    }

    @Override
    public BigDecimal dineroRetiradoEnElDia(Cuenta cuenta) {
        BigDecimal retirosAlDia = BigDecimal.ZERO;
        LocalDateTime today = LocalDateTime.now();

        for(Retiro retiro : retiros){

            if (retiro.getCuenta().equals(cuenta) && retiro.getFecha().isAfter(today.minusDays(1))&&
                    retiro.getFecha().isBefore(today.plusDays(1))){
                retirosAlDia = retirosAlDia.add(retiro.getMonto());
            }
        }
        return retirosAlDia;
    }


}
