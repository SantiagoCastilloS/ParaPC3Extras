package uni.edu.pe.prestamo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publicaciones {
    private int idPublicacion;
    private String codigoPublicacion;
    private String titulo;
    private String autor;
    private int edicion;
    private String tema;
    private String estado;
    private String tipo;
}
