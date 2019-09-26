package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.CuentaDao;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CuentaDaoList implements CuentaDao {
    private static List<Cuenta> cuentas = new ArrayList<>();

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        cuenta.setId(cuentas.size() + 1);
        cuentas.add(cuenta);
    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
        Optional<Cuenta> respuesta = buscarCuentaPorId(cuenta.getId());
        if (respuesta.isPresent()) {
            cuentas.remove(respuesta.get());
        }
    }

    private Optional<Cuenta> buscarCuentaPorId(Integer id) {
        Optional<Cuenta> cuentaOptional = Optional.empty();
        for (Cuenta cuenta : cuentas) {
            if (id.equals(cuenta.getId())) {
                cuentaOptional = Optional.of(cuenta);
                break;
            }
        }
        return cuentaOptional;
    }
}
