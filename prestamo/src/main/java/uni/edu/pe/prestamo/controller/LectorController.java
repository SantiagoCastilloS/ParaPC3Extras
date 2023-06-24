package uni.edu.pe.prestamo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.edu.pe.prestamo.dto.Lector;
import uni.edu.pe.prestamo.service.LectorService;

@RestController
public class LectorController {
    @Autowired
    private LectorService lectorService;
    @RequestMapping ( value="/registrarLector", method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
    public Lector registrarLector(@RequestBody Lector lector){
        return lectorService.registrarLector(lector);
    }
}
