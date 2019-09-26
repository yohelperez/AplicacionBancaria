package co.edu.udea.tecnicas.cuentas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Retiro {
    private Integer id;
    private BigDecimal  monto;
    private LocalDateTime fecha;
    private Cuenta cuenta;

    public Retiro(Cuenta cuenta, BigDecimal monto) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
