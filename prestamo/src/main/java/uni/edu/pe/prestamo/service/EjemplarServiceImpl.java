package uni.edu.pe.prestamo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.prestamo.dao.EjemplarDao;
import uni.edu.pe.prestamo.dto.Ejemplar;

@Service
public class EjemplarServiceImpl implements EjemplarService {

    @Autowired
    private EjemplarDao ejemplarDao;
    @Override
    public Ejemplar actualizarEjemplar(Ejemplar ejemplar) {
        return ejemplarDao.actualizarEjemplar(ejemplar);
    }
}
