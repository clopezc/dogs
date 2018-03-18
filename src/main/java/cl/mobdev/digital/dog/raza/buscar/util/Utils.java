package cl.mobdev.digital.dog.raza.buscar.util;

import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.excepcion.BreedNotFoundExcepcion;
import cl.mobdev.digital.dog.raza.buscar.excepcion.ServicioCodigoErrorExcepcion;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;

public class Utils {

    @Value("${exito}")
    private String exito;

    private ServiceResponse serviceResponse;

    public Utils(ServiceResponse serviceResponse) {
        this.serviceResponse = serviceResponse;
    }


    public void validateResponse(JSONObject obj, String code) {
        String status = (String)obj.get("status");
        if (!exito.equalsIgnoreCase(status)) {
            String msg = (String)obj.get("message");
            throw new ServicioCodigoErrorExcepcion(code,msg);
        }
    }

    public ServiceResponse returnResponse(JSONObject obj) {
        return (serviceResponse = new Gson().fromJson(obj.toJSONString(), ServiceResponse.class));
    }

    public void getValidBreed(ServiceResponse breedList, String breed) {
            if(!breedList.getMessage().contains(breed)){
                throw new BreedNotFoundExcepcion();
            }

    }
}
