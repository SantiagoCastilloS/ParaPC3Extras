package uni.edu.pe.prestamo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionMaterial {
    private int idPublicacion;
    private String codigoPublicacion;
    private String titulo;
    private String autor;
    private String edicion;
    private String tipo;
    private int idMaterial;
    private String tipoContenido;
}
