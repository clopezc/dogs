package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.servicio.ISubBreed;
import cl.mobdev.digital.dog.raza.buscar.util.Utils;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SubBreedImpl implements ISubBreed {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RestTemplate restTemplate;

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
        JSONObject obj = restTemplate.getForObject(prefixEndpoint + path, JSONObject.class);
        utils.validateResponse(obj, subbreederror);
        logger.info("subBreed = {}", obj.toJSONString());
        return utils.returnResponse(obj);
    }

}
