package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.servicio.IBreedImage;
import cl.mobdev.digital.dog.raza.buscar.util.Utils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BreedImageImpl implements IBreedImage {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Utils utils;

    @Value("${prefixEndpoint}")
    private String prefixEndpoint;

    @Value("${imageBreedError}")
    private String imageBreedError;

    public BreedImageImpl(RestTemplate restTemplate, Utils utils) {
        this.restTemplate = restTemplate;
        this.utils = utils;
    }


    @Override
    public ServiceResponse findBreedImage(String breed) {

        String path = "breed/" + breed + "/images";
        JSONObject obj = restTemplate.getForObject(prefixEndpoint + path, JSONObject.class);
        utils.validateResponse(obj,imageBreedError );
        logger.info("breedImage = {}", obj.toJSONString());
        return utils.returnResponse(obj);
    }

}
