package uni.edu.pe.prestamo.service;

import uni.edu.pe.prestamo.dto.PublicacionMaterial;
import uni.edu.pe.prestamo.dto.Publicaciones;

import java.util.List;

public interface PublicacionesService {
    List<Publicaciones> obtenerPublicaciones();
    List <PublicacionMaterial> obtenerPublicacionMaterial();
}
