package uni.edu.pe.prestamo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.prestamo.dto.Ejemplar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class EjemplarDaoImp implements EjemplarDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection connection;
    private void obtenerConexion(){
        try{
            connection = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void cerrarConexion(){
        try{
            connection.close();
            connection = null;
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public Ejemplar actualizarEjemplar(Ejemplar ejemplar) {
        try{
            obtenerConexion();
            String sql = "UPDATE ejemplar ej SET ej.estado = ? WHERE ej.id_ejemplar = ?;";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ejemplar.getEstado());
            st.setInt(2, ejemplar.getIdEjemplar());
            st.executeUpdate();
            st.close();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ejemplar;
    }
}
