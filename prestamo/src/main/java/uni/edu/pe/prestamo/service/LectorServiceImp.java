package uni.edu.pe.prestamo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.prestamo.dao.LectorDao;
import uni.edu.pe.prestamo.dto.Lector;

@Service
public class LectorServiceImp implements LectorService {
    @Autowired
    private LectorDao lectorDao;
    @Override
    public Lector registrarLector(Lector lector) {
        return lectorDao.registrarLector(lector);
    }

}
