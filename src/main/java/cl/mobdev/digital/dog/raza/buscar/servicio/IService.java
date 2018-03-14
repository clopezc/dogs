package cl.mobdev.digital.dog.raza.buscar.servicio;


import cl.mobdev.digital.dog.raza.buscar.entidad.Response;

@FunctionalInterface
public interface IService {

    Response findByBreed(String breed);

}
