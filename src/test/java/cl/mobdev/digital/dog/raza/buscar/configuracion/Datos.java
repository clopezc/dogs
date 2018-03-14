package cl.mobdev.digital.dog.raza.buscar.configuracion;


import cl.mobdev.digital.dog.raza.buscar.entidad.Response;
import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;

import java.util.ArrayList;
import java.util.List;

public class Datos {


    public static final String STATUS_OK = "succes";
    public static final String BREED = "hound";
    public static final String RESPUESTA_CODIGO_ERROR = "1";
    public static final String RESPUESTA_CODIGO_ERROR_GENERAL = "3";


    public static ServiceResponse RESPONSE_BREED_LIST() {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage(GET_BREED_LIST());
        serviceResponse.setStatus(STATUS_OK);
        return serviceResponse;
    }

    public static List<String> GET_BREED_LIST() {
        List<String> breeds = new ArrayList<>();
        breeds.add("affenpinscher");
        breeds.add("african");
        breeds.add("appenzeller");
        return breeds;
    }

    public static ServiceResponse RESPONSE_SUB_BREED_LIST() {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage(GET_SUBBREED_LIST());
        serviceResponse.setStatus(STATUS_OK);
        return serviceResponse;
    }

    public static List<String> GET_SUBBREED_LIST() {
        List<String> subBreeds = new ArrayList<>();
        subBreeds.add("Ibizan");
        subBreeds.add("afghan");
        subBreeds.add("basset");
        return subBreeds;
    }

    public static ServiceResponse RESPONSE_IMAGE_BREED_LIST() {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage(GET_IMAGE_BREED_LIST());
        serviceResponse.setStatus(STATUS_OK);
        return serviceResponse;
    }

    public static List<String> GET_IMAGE_BREED_LIST() {
        List<String> imegeBreed = new ArrayList<>();
        imegeBreed.add("https://dog.ceo/api/img/boxer/n02108089_1.jpg");
        imegeBreed.add("https://dog.ceo/api/img/boxer/n02108089_1003.jpg");
        imegeBreed.add("https://dog.ceo/api/img/boxer/n02108089_10229.jpg");
        return imegeBreed;
    }

    public static Response RESPONSE_IMPL_HELPER() {
        Response response = new Response();
        response.setImages(GET_IMAGE_BREED_LIST());
        response.setSubBreeds(GET_SUBBREED_LIST());
        response.setBreed(BREED);
        return response;
    }
}
