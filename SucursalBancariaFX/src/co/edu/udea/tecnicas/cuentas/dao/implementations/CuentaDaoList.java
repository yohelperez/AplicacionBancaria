package co.edu.udea.tecnicas.cuentas.dao.implementations;

import co.edu.udea.tecnicas.cuentas.dao.CuentaDao;
import co.edu.udea.tecnicas.cuentas.dao.exceptions.DuplicatedKeyException;
import co.edu.udea.tecnicas.cuentas.dao.exceptions.EmptyListException;
import co.edu.udea.tecnicas.cuentas.model.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CuentaDaoList implements CuentaDao {
    private static List<Cuenta> cuentas = new ArrayList<>();

    @Override
    public void guardarCuenta(Cuenta cuenta) throws DuplicatedKeyException {
        for (Cuenta iterCuenta : cuentas){
            if (iterCuenta.getUsuario().equals(cuenta.getUsuario())){
                throw new DuplicatedKeyException();
            }
        }
        cuenta.setId(cuentas.size() + 1);
        cuentas.add(cuenta);
        return;
    }

    @Override
    public Boolean eliminarCuenta(Cuenta cuenta) {
        Optional<Cuenta> respuesta = buscarCuentaPorId(cuenta.getId());
        if (respuesta.isPresent()) {
            respuesta.get().setEstado(false);//Borrado lógico de la cuenta. Por seguridad.
            return true;
        }
        return false;
    }

    @Override
    public Cuenta loginAccount(Cuenta cuentaAuth) throws EmptyListException {
        Integer listActiveSize, sizeForException = 0;
        List<Cuenta> activesAccounts = new ArrayList<Cuenta>();

        for (Cuenta cuenta : cuentas){
            if (cuenta.getEstado()){
                activesAccounts.add(cuenta);
            }
        }

        listActiveSize = activesAccounts.size();

        if (sizeForException.equals(listActiveSize.compareTo(0))){
            throw new EmptyListException();
        }

        for(Cuenta cuenta : activesAccounts){
            if (cuenta.getUsuario().equals(cuentaAuth.getUsuario()) && cuenta.getPassword().equals(cuentaAuth.getPassword())
                && cuenta.getEstado()){
                return cuenta;
            }
        }
        return null;
    }

    public Optional<Cuenta> buscarCuentaPorId(Integer id) {
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
