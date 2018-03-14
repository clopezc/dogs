package cl.mobdev.digital.dog.raza.buscar.excepcion;

import cl.mobdev.digital.dog.raza.buscar.configuracion.Datos;
import cl.mobdev.digital.dog.raza.buscar.entidad.ResponseError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
                "errorGeneral",
                "3");
    }

    @Test
    public void testControladorExcepcionesServiceError() {

        exception = new ServicioCodigoErrorExcepcion(Datos.RESPUESTA_CODIGO_ERROR);

        ResponseError responseError
                = controladorGeneralDeExcepciones.gestionBuscarExcepcion(exception);

        assertThat(responseError,
                not(
                        nullValue()
                )
        );

        assertThat(responseError.getMessage(),
                is(
                        "Error with DOG api"
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
    public void testControladorExcepcionesHttpMessage() {

        //exception = new HttpMessageNotReadableException(Datos.RESPUESTA_CODIGO_ERROR_GENERAL);

        ResponseError responseError
                = controladorGeneralDeExcepciones.httpMessageNotReadableException();

        assertThat(responseError,
                not(
                        nullValue()
                )
        );

        assertThat(responseError.getMessage(),
                is(
                        "Breed not found"
                )
        );

        assertThat(responseError.getCodigo(),
                is(
                        Datos.RESPUESTA_CODIGO_ERROR_GENERAL
                )
        );

        assertThat(responseError.toString(),
                is(
                        "ResponseError{codigo='3', message='Breed not found'}"
                )
        );

    }

}
