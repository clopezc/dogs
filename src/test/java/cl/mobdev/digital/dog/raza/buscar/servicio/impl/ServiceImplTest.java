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
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTest {

    @InjectMocks
    private ServiceImpl serviceImpl;

    @Mock
    private BreedImpl breedImpl;

    @Mock
    private SubBreedImpl subBreedImpl;

    @Mock
    private BreedImageImpl breedImageImpl;

    @Mock
    private ServiceImplHelper servicioImplHelper;

    @Test
    public void testFindByBreed() {

        when(breedImpl.findBreedList()).
                thenReturn(Datos.RESPONSE_BREED_LIST());

        when(subBreedImpl.findBySubBreed(anyString())).
                thenReturn(Datos.RESPONSE_SUB_BREED_LIST());

        when(breedImageImpl.findBreedImage(anyString())).
                thenReturn(Datos.RESPONSE_IMAGE_BREED_LIST());

        when(servicioImplHelper.procesarSalida(anyString(),anyObject(),anyObject())).
                thenReturn(Datos.RESPONSE_IMPL_HELPER());

        Response response = serviceImpl.findByBreed(Datos.BREED);

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

        assertThat(
                response.toString(),
                is(
                        "Response{breed=hound, subBreeds=3, images=3}"
                )
        );

    }
    
}
