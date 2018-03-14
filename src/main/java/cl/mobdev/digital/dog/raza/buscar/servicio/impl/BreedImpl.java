package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.servicio.IBreed;
import cl.mobdev.digital.dog.raza.buscar.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BreedImpl implements IBreed {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Utils utils;

    @Value("${prefixEndpoint}")
    private String prefixEndpoint;

    @Value("${breedListError}")
    private String breedListError;

    private String breedsList = "breeds/list";


    public BreedImpl(RestTemplate restTemplate, Utils utils) {
        this.restTemplate = restTemplate;
        this.utils = utils;
    }

    @Override
    public ServiceResponse findBreedList() {

        ServiceResponse breedList = restTemplate.getForObject(prefixEndpoint + breedsList, ServiceResponse.class);
        utils.validateResponse(breedList.getStatus(), breedListError);
        logger.info("breedList = {}", breedList);
        return breedList;
    }

}
