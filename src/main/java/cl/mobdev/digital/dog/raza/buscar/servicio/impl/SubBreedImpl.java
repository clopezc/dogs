package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.servicio.ISubBreed;
import cl.mobdev.digital.dog.raza.buscar.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubBreedImpl implements ISubBreed {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Utils utils;

    @Value("${prefixEndpoint}")
    private String prefixEndpoint;

    @Value("${subbreederror}")
    private String subbreederror;

    public SubBreedImpl(RestTemplate restTemplate, Utils utils) {
        this.restTemplate = restTemplate;
        this.utils = utils;
    }

    @Override
    public ServiceResponse findBySubBreed(String breed) {

        String path = "breed/" + breed + "/list";
        ServiceResponse subBreed= restTemplate.getForObject(prefixEndpoint + path, ServiceResponse.class);
        utils.validateResponse(subBreed.getStatus(), subbreederror);
        logger.info("subBreed = {}", subBreed);
        return subBreed;
    }

}
