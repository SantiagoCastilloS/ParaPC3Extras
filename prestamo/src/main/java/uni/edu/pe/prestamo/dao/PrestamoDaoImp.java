package uni.edu.pe.prestamo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.prestamo.dto.PrestamoDetallado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PrestamoDaoImp implements PrestamoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection connection;
    private void obtConeccion() {
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void cerrConeccion(){
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<PrestamoDetallado> obtenerPrestamoDetallado() {
        List<PrestamoDetallado> prestamoDetallados = new ArrayList<>();
        try{
            obtConeccion();
            String sql = "SELECT p.id_prestamo, pb.titulo, pb.autor, p.fecha_prestamo, p.fecha_devolucion, e.origen, e.id_ejemplar, e.estado, l.codigo_lector, l.apellidos, l.nombres, l.tipo_lector, r.codigo_referencista, r.nombre_completo 'referencista' FROM prestamo p INNER JOIN ejemplar e ON (p.id_ejemplar = e.id_ejemplar) INNER JOIN lector l ON (p.id_lector = l.id_lector) INNER JOIN referencista r ON (p.id_referencista = r.id_referencista) INNER JOIN publicacion pb ON (e.id_publicacion = pb.id_publicacion) WHERE e.estado LIKE 'H';\n";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                PrestamoDetallado pd = new PrestamoDetallado(rs.getInt("id_prestamo"),rs.getString("titulo"),rs.getString("autor"),rs.getString("fecha_prestamo"),rs.getString("fecha_devolucion"),rs.getString("origen"),rs.getInt("id_ejemplar"),rs.getString("estado"),rs.getString("codigo_lector"),rs.getString("apellidos"),rs.getString("nombres"),rs.getString("tipo_lector"),rs.getString("codigo_referencista"),rs.getString("referencista"));
                prestamoDetallados.add(pd);
            }
            rs.close();
            st.close();
            cerrConeccion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return prestamoDetallados;
    }
}
