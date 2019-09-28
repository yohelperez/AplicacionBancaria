package co.edu.udea.tecnicas.cuentas.bsn.exceptions;

public class IllegalTransactionException extends Exception{
    @Override
    public String getMessage() {
        String message = "Cuenta de destino no puede ser igual a la cuenta de origen de la consignación!";
        return message;
    }
}
