package uni.edu.pe.prestamo.service;

import uni.edu.pe.prestamo.dto.PrestamoDetallado;
import uni.edu.pe.prestamo.dto.Publicaciones;

import java.util.List;

public interface PrestamoService {
    List<PrestamoDetallado> obtenerPrestamoDetallado();

}
