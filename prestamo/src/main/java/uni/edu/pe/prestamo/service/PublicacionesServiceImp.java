package uni.edu.pe.prestamo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.prestamo.dao.PublicacionesDao;
import uni.edu.pe.prestamo.dto.PublicacionMaterial;
import uni.edu.pe.prestamo.dto.Publicaciones;

import java.util.List;
@Service
@Transactional
public class PublicacionesServiceImp implements PublicacionesService {
    @Autowired
    private PublicacionesDao publicacionesDao;
    @Override
    public List<Publicaciones> obtenerPublicaciones() {
        return publicacionesDao.obtenerPublicaciones();
    }
    @Override
    public List<PublicacionMaterial> obtenerPublicacionMaterial() {
        return publicacionesDao.obtenerPublicacionMaterial();
    }

}
