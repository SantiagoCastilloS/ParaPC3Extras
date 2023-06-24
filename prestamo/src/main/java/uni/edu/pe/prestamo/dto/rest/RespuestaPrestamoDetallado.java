package uni.edu.pe.prestamo.dto.rest;

import uni.edu.pe.prestamo.dto.PrestamoDetallado;

import java.util.List;

public class RespuestaPrestamoDetallado {
    private List<PrestamoDetallado> prestamos;

    public RespuestaPrestamoDetallado(List<PrestamoDetallado> prestamos) {
        this.prestamos = prestamos;
    }

    public List<PrestamoDetallado> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<PrestamoDetallado> prestamos) {
        this.prestamos = prestamos;
    }
}
