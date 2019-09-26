package co.edu.udea.tecnicas.cuentas.model;

public class Caja {
    private Integer id;
    private String identificacion,password;

    public Caja(String identificacion, String password) {
        this.identificacion = identificacion;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
