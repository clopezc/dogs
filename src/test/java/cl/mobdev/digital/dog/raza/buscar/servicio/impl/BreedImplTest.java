package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.configuracion.Datos;
import cl.mobdev.digital.dog.raza.buscar.entidad.Response;
import cl.mobdev.digital.dog.raza.buscar.entidad.ServiceResponse;
import cl.mobdev.digital.dog.raza.buscar.excepcion.ServicioCodigoErrorExcepcion;
import cl.mobdev.digital.dog.raza.buscar.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BreedImplTest {

    @InjectMocks
    private BreedImpl breedImpl;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private Utils utils;

    @Mock
    ServicioCodigoErrorExcepcion servicioCodigoErrorExcepcion;

    @Test
    public void testFindBreedListSucces() {

        when(restTemplate.getForObject(anyString(), anyObject())).
                thenReturn(Datos.RESPONSE_BREED_LIST());

        breedImpl.findBreedList();

    }
    
}
