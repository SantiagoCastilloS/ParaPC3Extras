package uni.edu.pe.prestamo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.prestamo.dto.PublicacionMaterial;
import uni.edu.pe.prestamo.dto.Publicaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PublicacionesDaoImp implements PublicacionesDao {
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
    public List<Publicaciones> obtenerPublicaciones() {
        List<Publicaciones> publicaciones = new ArrayList<>();
        try {
            obtConeccion();
            String sql = "SELECT * FROM publicacion;";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Publicaciones p = new Publicaciones(
                        rs.getInt("id_publicacion"),
                        rs.getString("codigo_publicacion"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("edicion"),
                        rs.getString("tema"),
                        rs.getString("estado"),
                        rs.getString("tipo")
                );
                publicaciones.add(p);
            }
            st.close();
            rs.close();
            cerrConeccion();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return publicaciones;
    }
    @Override
    public List<PublicacionMaterial> obtenerPublicacionMaterial() {
        List<PublicacionMaterial> publicacionMaterials = new ArrayList<>();
        try{
            obtConeccion();
            String sql = "SELECT p.id_publicacion, p.codigo_publicacion, p.titulo, p.autor, p.edicion, p.tipo, m.id_material, m.tipo_contenido FROM publicacion p INNER JOIN material_adicional m ON (p.id_publicacion = m.id_publicacion);";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                PublicacionMaterial pm = new PublicacionMaterial(
                        rs.getInt("id_publicacion"),
                        rs.getString("codigo_publicacion"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("edicion"),
                        rs.getString("tipo"),
                        rs.getInt("id_material"),
                        rs.getString("tipo_contenido")
                );
                publicacionMaterials.add(pm);
            }
            st.close();
            rs.close();
            cerrConeccion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return publicacionMaterials;
    }
}
