package uni.edu.pe.prestamo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.edu.pe.prestamo.dto.Publicaciones;
import uni.edu.pe.prestamo.dto.rest.RespuestaPrestamoDetallado;
import uni.edu.pe.prestamo.dto.rest.RespuestaPublicacionMaterial;
import uni.edu.pe.prestamo.dto.rest.RespuestaPublicaciones;
import uni.edu.pe.prestamo.service.PrestamoService;
import uni.edu.pe.prestamo.service.PublicacionesService;

@RestController
public class PublicacionesController {
    @Autowired
    private PublicacionesService service;
    @RequestMapping(value="/obtenerPublicaciones", method = RequestMethod.POST)
    public RespuestaPublicaciones obtenerPublicaciones(){
        RespuestaPublicaciones rpta = new RespuestaPublicaciones(service.obtenerPublicaciones());
        return rpta;
    }
    @RequestMapping(value="/obtenerPublicacionMaterial", method = RequestMethod.POST)
    public RespuestaPublicacionMaterial obtenerPublicacionMaterial(){
        RespuestaPublicacionMaterial  rptaM = new RespuestaPublicacionMaterial (service.obtenerPublicacionMaterial());
        return rptaM;
    }

}
