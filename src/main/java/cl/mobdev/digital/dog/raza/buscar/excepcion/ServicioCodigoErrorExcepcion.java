package cl.mobdev.digital.dog.raza.buscar.excepcion;

public class ServicioCodigoErrorExcepcion extends RuntimeException {

    private final String codigo;
    private final String msg;

    public ServicioCodigoErrorExcepcion(String codigo, String msg) {
        this.codigo = codigo;
        this.msg = msg;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMsg() {
        return msg;
    }
}
