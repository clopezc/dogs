package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.entidad.Response;
import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceImplHelper {

    @Autowired
    private Response response;

    public ServiceImplHelper(Response response) {
        this.response = response;
    }

    Response procesarSalida(
            String breed,
            ServiceResponse subBreedList,
            ServiceResponse breedImage) {

        response.setBreed(breed);
        response.setSubBreeds(subBreedList.getMessage());
        response.setImages(breedImage.getMessage());
        return response;
    }

}
