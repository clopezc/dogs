package cl.mobdev.digital.dog.raza.buscar.entidad;

import java.util.List;

public class Response {

    private String breed;
    private List<String> subBreeds;
    private List<String> images;

    public Response() {
        super();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<String> getSubBreeds() {
        return subBreeds;
    }

    public void setSubBreeds(List<String> subBreeds) {
        this.subBreeds = subBreeds;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Response{"
                + "breed=" + breed
                + ", subBreeds=" + subBreeds.size()
                + ", images=" + images.size()
                + '}';
    }
}
