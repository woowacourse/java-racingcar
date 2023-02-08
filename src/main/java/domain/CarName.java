package domain;

public class CarName {

    public static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (name == null || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
