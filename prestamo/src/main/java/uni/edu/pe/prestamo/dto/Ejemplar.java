package uni.edu.pe.prestamo.dto;

public class Ejemplar {
    private int idEjemplar;
    private String origen;
    private String modalidad;
    private String estado;
    private int idPublicacion;

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Ejemplar(int idEjemplar, String origen, String modalidad, String estado, int idPublicacion) {
        this.idEjemplar = idEjemplar;
        this.origen = origen;
        this.modalidad = modalidad;
        this.estado = estado;
        this.idPublicacion = idPublicacion;
    }

    public Ejemplar() {
    }
}
