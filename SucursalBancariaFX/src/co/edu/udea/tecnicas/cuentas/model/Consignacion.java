package co.edu.udea.tecnicas.cuentas.model;

import java.math.BigDecimal;

public class Consignacion {
    private Integer id;
    private BigDecimal monto;
    private Object origen;
    private Cuenta destino;

    public Consignacion(BigDecimal monto, Object origen, Cuenta destino) {
        this.monto = monto;
        this.origen = origen;
        this.destino = destino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Object getOrigen() {
        return origen;
    }

    public void setOrigen(Object origen) {
        this.origen = origen;
    }

    public Cuenta getDestino() {
        return destino;
    }

    public void setDestino(Cuenta destino) {
        this.destino = destino;
    }
}
