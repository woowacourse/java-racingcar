package domain;

public class CarName {

    private String name;

    public CarName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
