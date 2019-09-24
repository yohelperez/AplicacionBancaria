package co.edu.udea.tecnicas.cuentas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Retiro {
    private Integer id;
    private BigDecimal  monto;
    private LocalDateTime fecha;

    public Retiro(Integer id, BigDecimal monto) {
        this.id = id;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }
}
