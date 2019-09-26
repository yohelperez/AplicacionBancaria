package co.edu.udea.tecnicas.cuentas.model;

import java.math.BigDecimal;

public class Cuenta {
    private Integer id;
    private String nombre,apellido,usuario,password;
    private BigDecimal saldo;
    private Boolean estado;//true -> cuenta activa, inactiva en otro caso.

    public Cuenta(String nombre, String apellido, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.saldo = BigDecimal.ZERO;
        this.estado = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
