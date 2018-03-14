package cl.mobdev.digital.dog.raza.buscar.servicio.impl;

import cl.mobdev.digital.dog.raza.buscar.configuracion.Datos;
import cl.mobdev.digital.dog.raza.buscar.entidad.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplHelperTest {

    @InjectMocks
    private ServiceImplHelper serviceImplHelper;

    @Test
    public void testProcesarSalida() {

        serviceImplHelper = new ServiceImplHelper(new Response());
        Response response =serviceImplHelper.procesarSalida(Datos.BREED,Datos.RESPONSE_SUB_BREED_LIST(),
                Datos.RESPONSE_IMAGE_BREED_LIST());

        assertThat(
                response,
                is(
                        not(
                                nullValue()
                        )
                )
        );

        assertThat(
                response.getBreed(),
                is(
                        Datos.BREED
                )
        );

        assertThat(
                response.getImages().size(),
                is(
                        Datos.GET_IMAGE_BREED_LIST().size()
                )
        );

        assertThat(
                response.getSubBreeds().size(),
                is(
                        Datos.GET_SUBBREED_LIST().size()
                )
        );


    }
    
}
