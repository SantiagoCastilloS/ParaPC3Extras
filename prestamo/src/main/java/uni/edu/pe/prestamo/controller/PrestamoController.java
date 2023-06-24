package uni.edu.pe.prestamo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.edu.pe.prestamo.dao.PrestamoDao;
import uni.edu.pe.prestamo.dto.PrestamoDetallado;
import uni.edu.pe.prestamo.dto.rest.RespuestaPrestamoDetallado;
import uni.edu.pe.prestamo.service.PrestamoService;
import java.util.List;
@RestController
public class PrestamoController {
    @Autowired
    private PrestamoService service;
    @RequestMapping (value="/obtenerPrestamoDetallado", method = RequestMethod.GET)
    public RespuestaPrestamoDetallado obtenerPrestamoDetallado(){
        RespuestaPrestamoDetallado rpta = new RespuestaPrestamoDetallado(service.obtenerPrestamoDetallado());
        return rpta;
    }

}
