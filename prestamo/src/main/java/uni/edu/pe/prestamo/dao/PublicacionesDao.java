package uni.edu.pe.prestamo.dao;

import uni.edu.pe.prestamo.dto.PublicacionMaterial;
import uni.edu.pe.prestamo.dto.Publicaciones;

import java.util.List;

public interface PublicacionesDao {
    List <Publicaciones> obtenerPublicaciones();
    List <PublicacionMaterial> obtenerPublicacionMaterial();
}
