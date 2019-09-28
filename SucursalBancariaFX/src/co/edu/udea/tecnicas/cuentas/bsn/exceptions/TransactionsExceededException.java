package co.edu.udea.tecnicas.cuentas.bsn.exceptions;

public class TransactionsExceededException extends Exception {
    @Override
    public String getMessage() {
        String message = "Número de trasacciones excedidas por día";
        return message;
    }
}
