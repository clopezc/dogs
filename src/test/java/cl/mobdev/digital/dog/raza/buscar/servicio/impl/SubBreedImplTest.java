package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.configuracion.Datos;
import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubBreedImplTest {

    @InjectMocks
    private SubBreedImpl subBreedImpl;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private Utils utils;

    @Test
    public void testFindBySubBreed() {

        when(restTemplate.getForObject(anyString(), anyObject())).
                thenReturn(Datos.RESPONSE_SUB_BREED_LIST());

        ServiceResponse serviceResponse = subBreedImpl.findBySubBreed(Datos.BREED);

        assertThat(
                serviceResponse,
                is(
                        not(
                                nullValue()
                        )
                )
        );

        assertThat(
                serviceResponse.getMessage(),
                is(
                        Datos.GET_SUBBREED_LIST()
                )
        );

        assertThat(
                serviceResponse.getStatus(),
                is(
                        Datos.STATUS_OK
                )
        );

    }
    
}
