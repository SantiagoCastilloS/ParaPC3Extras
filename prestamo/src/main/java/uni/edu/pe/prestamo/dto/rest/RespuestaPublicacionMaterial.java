package uni.edu.pe.prestamo.dto.rest;

import uni.edu.pe.prestamo.dto.PublicacionMaterial;

import java.util.List;

public class RespuestaPublicacionMaterial {
    public List<PublicacionMaterial> materiales;

    public RespuestaPublicacionMaterial(List<PublicacionMaterial> materiales) {
        this.materiales = materiales;
    }
}
