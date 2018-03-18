package cl.mobdev.digital.dog.raza.buscar.excepcion;

import cl.mobdev.digital.dog.raza.buscar.entidad.ResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControladorGeneralDeExcepciones {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${breedNotFound}")
    private String breedNotFound;

    public ControladorGeneralDeExcepciones() {
        super();
    }

    @ExceptionHandler(value = ServicioCodigoErrorExcepcion.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseError gestionBuscarExcepcion(Exception ex) {

        ServicioCodigoErrorExcepcion gbe = (ServicioCodigoErrorExcepcion) ex;
        logger.error("ERROR = {}",gbe.getCodigo());
        return new ResponseError(gbe.getCodigo(), gbe.getMsg());
    }

    @ExceptionHandler(value = BreedNotFoundExcepcion.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseError breedNotFound() {
        logger.error("ERROR = {}", breedNotFound);
        return new ResponseError(breedNotFound, "Breed not found in list");
    }

}
