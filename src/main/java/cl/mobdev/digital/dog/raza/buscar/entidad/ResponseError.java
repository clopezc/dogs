package cl.mobdev.digital.dog.raza.buscar.entidad;

public class ResponseError {

    private String codigo;
    private String message;

    public ResponseError(String codigo, String message) {
        super();
        this.codigo = codigo;
        this.message = message;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResponseError{"
                + "codigo='" + codigo + '\''
                + ", message='" + message + '\''
                + '}';
    }
}
