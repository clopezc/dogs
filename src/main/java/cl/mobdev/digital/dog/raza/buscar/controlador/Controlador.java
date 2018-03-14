package cl.mobdev.digital.dog.raza.buscar.controlador;

import cl.mobdev.digital.dog.raza.buscar.entidad.Response;
import cl.mobdev.digital.dog.raza.buscar.servicio.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IService servicio;

    public Controlador(IService servicio) {
        this.servicio = servicio;
    }

    @PostMapping(path = "/dog/{breedName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response buscar(@PathVariable(value = "breedName") String breedName) {
        logger.info(breedName);
        return servicio.findByBreed(breedName);
    }

}
