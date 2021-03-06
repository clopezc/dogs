package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.entidad.Response;
import cl.mobdev.digital.dog.raza.buscar.servicio.IBreed;
import cl.mobdev.digital.dog.raza.buscar.servicio.IBreedImage;
import cl.mobdev.digital.dog.raza.buscar.servicio.IService;
import cl.mobdev.digital.dog.raza.buscar.servicio.ISubBreed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements IService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceImplHelper serviceImplHelper;

    @Autowired
    private IBreed iBreed;

    @Autowired
    private ISubBreed iSubBreed;

    @Autowired
    private IBreedImage iBreedImage;

    public ServiceImpl(
            ISubBreed iSubBreed, IBreed iBreed,
            IBreedImage iBreedImage, ServiceImplHelper serviceImplHelper) {
        this.iBreed = iBreed;
        this.iSubBreed = iSubBreed;
        this.iBreedImage = iBreedImage;
        this.serviceImplHelper = serviceImplHelper;
    }

    @Override
    public Response findByBreed(String breed) {

        iBreed.findBreedList();
        ServiceResponse subBreedList = iSubBreed.findBySubBreed(breed);
        ServiceResponse breedImage = iBreedImage.findBreedImage(breed);
        return transformarSalida(breed, subBreedList, breedImage);

    }

    private Response transformarSalida(
            String breed, ServiceResponse subBreedList, ServiceResponse breedImage) {

        Response salida = serviceImplHelper.
                procesarSalida(breed, subBreedList, breedImage);
        logger.info("salida={}", salida);
        return salida;
    }

}
