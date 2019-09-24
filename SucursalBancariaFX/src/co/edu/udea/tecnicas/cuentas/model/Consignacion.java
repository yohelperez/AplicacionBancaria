package co.edu.udea.tecnicas.cuentas.model;

import java.math.BigDecimal;

public class Consignacion {
    private Integer id;
    private BigDecimal monto;
    private Object origen;
    private Cuenta destino;

    public Consignacion(Integer id, BigDecimal monto, Object origen, Cuenta destino) {
        this.id = id;
        this.monto = monto;
        this.origen = origen;
        this.destino = destino;
    }
}
