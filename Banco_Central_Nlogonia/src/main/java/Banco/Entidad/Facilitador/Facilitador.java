package Banco.Entidad.Facilitador;

public class Facilitador {
    private int IdFacilitador;
    private String nombreFcilitador;

    public Facilitador() {}
    public Facilitador(int IdFacilitador, String nombreFcilitador) {
        this.IdFacilitador = IdFacilitador;
        this.nombreFcilitador = nombreFcilitador;
    }

    public int getIdFacilitador() {
        return IdFacilitador;
    }

    public void setIdFacilitador(int idFacilitador) {
        IdFacilitador = idFacilitador;
    }

    public String getNombreFcilitador() {
        return nombreFcilitador;
    }

    public void setNombreFcilitador(String nombreFcilitador) {
        this.nombreFcilitador = nombreFcilitador;
    }
}
