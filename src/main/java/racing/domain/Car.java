package racing.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void increasePosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
