package uni.edu.pe.prestamo.dao;

import uni.edu.pe.prestamo.dto.PrestamoDetallado;

import java.util.List;

public interface PrestamoDao {

    List<PrestamoDetallado> obtenerPrestamoDetallado();
}
