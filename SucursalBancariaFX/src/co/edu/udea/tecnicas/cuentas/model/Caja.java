package co.edu.udea.tecnicas.cuentas.model;

public class Caja {
    private Integer id;
    private String identificacion,password;

    public Caja(Integer id, String identificacion, String password) {
        this.id = id;
        this.identificacion = identificacion;
        this.password = password;
    }

}
