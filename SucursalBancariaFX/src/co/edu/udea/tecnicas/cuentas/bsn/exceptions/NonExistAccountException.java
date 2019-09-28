package co.edu.udea.tecnicas.cuentas.bsn.exceptions;

public class NonExistAccountException extends Exception {
    @Override
    public String getMessage() {
        String message = "Cuenta de destino no existe o no está activa";
        return message;
    }
}
