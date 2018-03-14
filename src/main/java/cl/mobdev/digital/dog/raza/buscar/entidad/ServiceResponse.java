package cl.mobdev.digital.dog.raza.buscar.entidad;

import java.util.List;

public class ServiceResponse {

    private List<String> message;
    private String status;

    public ServiceResponse() {
        super();

    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
