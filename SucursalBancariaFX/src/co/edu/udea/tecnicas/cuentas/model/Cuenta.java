package co.edu.udea.tecnicas.cuentas.model;

import java.math.BigDecimal;

public class Cuenta {
    private Integer id;
    private String nombre,apellido,usuario,password;
    private BigDecimal saldo;
    private Boolean estado;//true -> cuenta activa, inactiva en otro caso.

    public Cuenta(Integer id, String nombre, String apellido, String usuario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.saldo = BigDecimal.ZERO;
        this.estado = true;
    }
}
