package co.edu.udea.tecnicas.cuentas.bsn.exceptions;

public class ExceededAmmountException extends Exception {
    @Override
    public String getMessage() {
        String message = "Monto excedido para esta transacción!";
        return message;
    }
}
