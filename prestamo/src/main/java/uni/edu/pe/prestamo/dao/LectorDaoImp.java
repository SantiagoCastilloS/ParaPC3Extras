package uni.edu.pe.prestamo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.prestamo.dto.Lector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class LectorDaoImp implements LectorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection connection;
    private void obtenerConexion(){
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cerrarConexion() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Lector registrarLector(Lector lector) {
        try{
            obtenerConexion();
            String sql = "INSERT INTO lector(id_lector, codigo_lector, apellidos, nombres, tipo_lector, estado) VALUES (?,?,?,?,?,?);";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, lector.getIdLector());
            st.setString(2, lector.getCodigoLector());
            st.setString(3, lector.getApellidos());
            st.setString(4, lector.getNombres());
            st.setString(5, lector.getTipoLector());
            st.setString(6, lector.getEstado());
            st.executeUpdate();
            st.close();
            cerrarConexion();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return lector;
    }
}
