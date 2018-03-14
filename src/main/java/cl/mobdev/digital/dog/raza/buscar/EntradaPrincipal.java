package cl.mobdev.digital.dog.raza.buscar;

import cl.mobdev.digital.dog.raza.buscar.entidad.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EntradaPrincipal {

    public EntradaPrincipal() {
        super();
    }

    public static void main(String[] args) {
        SpringApplication.run(EntradaPrincipal.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Response response() {
        return new Response();
    }

}
