package cl.mobdev.digital.dog.raza.buscar.excepcion;

import cl.mobdev.digital.dog.raza.buscar.configuracion.Datos;
import cl.mobdev.digital.dog.raza.buscar.entidad.ResponseError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ControladorGeneralDeExcepcionesTest {

    @InjectMocks
    Exception exception;

    @InjectMocks
    ServicioCodigoErrorExcepcion servicioCodigoErrorExcepcion;

    @InjectMocks
    ControladorGeneralDeExcepciones controladorGeneralDeExcepciones;

    @Before
    public void configure() {
        ReflectionTestUtils.setField(controladorGeneralDeExcepciones,
                "breedNotFound",
                "4");
    }

    @Test
    public void testControladorExcepcionesServiceError() {

        exception = new ServicioCodigoErrorExcepcion(Datos.RESPUESTA_CODIGO_ERROR,Datos.RESPUESTA_MSJ_ERROR);

        ResponseError responseError
                = controladorGeneralDeExcepciones.gestionBuscarExcepcion(exception);

        assertThat(responseError,
                not(
                        nullValue()
                )
        );

        assertThat(responseError.getMessage(),
                is(
                        Datos.RESPUESTA_MSJ_ERROR
                )
        );

        assertThat(responseError.getCodigo(),
                is(
                        Datos.RESPUESTA_CODIGO_ERROR
                )
        );

        assertThat(responseError.toString(),
                is(
                        "ResponseError{codigo='1', message='Error with DOG api'}"
                )
        );

    }

    @Test
    public void testControladorExcepcionesBreedNotFound() {

        ResponseError responseError
                = controladorGeneralDeExcepciones.breedNotFound();

        assertThat(responseError,
                not(
                        nullValue()
                )
        );

        assertThat(responseError.getMessage(),
                is(
                        "Breed not found in list"
                )
        );

        assertThat(responseError.getCodigo(),
                is(
                        Datos.RESPUESTA_CODIGO_ERROR_NOT_FOUD
                )
        );

        assertThat(responseError.toString(),
                is(
                        "ResponseError{codigo='4', message='Breed not found in list'}"
                )
        );

    }

}
