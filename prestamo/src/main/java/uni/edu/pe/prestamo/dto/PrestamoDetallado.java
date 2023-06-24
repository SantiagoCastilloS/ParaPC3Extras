package uni.edu.pe.prestamo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDetallado {

    private int idPrestamo;
    private String titulo;
    private String autor;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String origen;
    private int idEjemplar;
    private String estado;
    private String codigoLector;
    private String apellidos;
    private String nombres;
    private String tipoLector;
    private String codigoReferencista;
    private String referencista;


}
