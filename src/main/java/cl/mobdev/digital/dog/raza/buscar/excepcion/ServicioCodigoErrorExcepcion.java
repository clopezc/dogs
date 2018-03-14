package cl.mobdev.digital.dog.raza.buscar.excepcion;

public class ServicioCodigoErrorExcepcion extends RuntimeException {

    private final String codigo;

    public ServicioCodigoErrorExcepcion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
