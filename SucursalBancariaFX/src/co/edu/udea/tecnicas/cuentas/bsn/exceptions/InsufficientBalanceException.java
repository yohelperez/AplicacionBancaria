package co.edu.udea.tecnicas.cuentas.bsn.exceptions;

public class InsufficientBalanceException extends Exception {
    @Override
    public String getMessage() {
        String message = "Saldo insuficiente para realizar la transacción";
        return message;
    }
}
