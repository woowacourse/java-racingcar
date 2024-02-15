package domain;

public class CarName {
    private String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("");
        }
    }

    public String getName() {
        return name;
    }
}
