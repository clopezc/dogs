package cl.mobdev.digital.dog.raza.buscar.util;

import cl.mobdev.digital.dog.raza.buscar.excepcion.ServicioCodigoErrorExcepcion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Utils {

    @Value("${exito}")
    private String exito;

    public Boolean validateResponse(String status, String code) {
        if (!exito.equalsIgnoreCase(status)) {
            return Boolean.TRUE;
        }
        throw new ServicioCodigoErrorExcepcion(code);
    }
}
