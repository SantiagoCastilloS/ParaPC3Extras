package uni.edu.pe.prestamo.dto.rest;

import uni.edu.pe.prestamo.dto.PrestamoDetallado;
import uni.edu.pe.prestamo.dto.Publicaciones;

import java.util.List;

public class RespuestaPublicaciones {
    private List<Publicaciones> publicaciones;

    public RespuestaPublicaciones(List<Publicaciones> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public List<Publicaciones> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicaciones> publicaciones) {
        this.publicaciones = publicaciones;
    }

}
