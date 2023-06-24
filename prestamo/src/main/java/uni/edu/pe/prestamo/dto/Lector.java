package uni.edu.pe.prestamo.dto;

public class Lector {
    private int idLector;
    private String codigoLector;
    private String apellidos;
    private String nombres;
    private String tipoLector;
    private String estado;

    public int getIdLector() {
        return idLector;
    }

    public void setIdLector(int idLector) {
        this.idLector = idLector;
    }

    public String getCodigoLector() {
        return codigoLector;
    }

    public void setCodigoLector(String codigoLector) {
        this.codigoLector = codigoLector;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipoLector() {
        return tipoLector;
    }

    public void setTipoLector(String tipoLector) {
        this.tipoLector = tipoLector;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Lector(int idLector, String codigoLector, String apellidos, String nombres, String tipoLector, String estado) {
        this.idLector = idLector;
        this.codigoLector = codigoLector;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.tipoLector = tipoLector;
        this.estado = estado;
    }

    public Lector() {
    }
}
