package uni.edu.pe.prestamo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.prestamo.dao.PrestamoDao;
import uni.edu.pe.prestamo.dto.PrestamoDetallado;
import java.util.List;
@Service
@Transactional
public class PrestamoServiceImp implements PrestamoService {
    @Autowired
    private PrestamoDao prestamoDao;
    @Override
    public List<PrestamoDetallado> obtenerPrestamoDetallado() {
        return prestamoDao.obtenerPrestamoDetallado();
    }
}
