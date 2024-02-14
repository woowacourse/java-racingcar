package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = validateName(name);
        this.position = 0;
    }

    private String validateName(String name) {
        if (name == null || name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return name;
    }

}
