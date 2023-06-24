package uni.edu.pe.prestamo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uni.edu.pe.prestamo.dto.Ejemplar;
import uni.edu.pe.prestamo.service.EjemplarService;

@Controller
public class EjemplarController {
    @Autowired
    private EjemplarService ejemplarService;
        @RequestMapping (value = "/actualizarEjemplar", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Ejemplar actualizarEjemplar(@RequestBody Ejemplar ejemplar){
        return ejemplarService.actualizarEjemplar(ejemplar);
    }
}
