package co.edu.udea.tecnicas.cuentas.dao.exceptions;

public class DuplicatedKeyException extends Exception {
    @Override
    public String getMessage() {
        String message = "Error!, Llave duplicada.";
        return message;
    }
}
