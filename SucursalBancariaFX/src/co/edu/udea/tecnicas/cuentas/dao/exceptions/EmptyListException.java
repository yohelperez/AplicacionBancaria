package co.edu.udea.tecnicas.cuentas.dao.exceptions;

public class EmptyListException extends Exception {
    @Override
    public String getMessage() {
        String message = "Lista vacía!";
        return message;
    }
}
