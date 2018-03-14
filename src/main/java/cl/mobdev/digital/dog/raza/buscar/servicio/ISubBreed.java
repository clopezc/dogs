package cl.mobdev.digital.dog.raza.buscar.servicio;

import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;

@FunctionalInterface
public interface ISubBreed {

    public ServiceResponse findBySubBreed(String breed);

}
