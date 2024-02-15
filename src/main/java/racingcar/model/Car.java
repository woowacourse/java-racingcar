package racingcar.model;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = validateName(name);
        this.position = 0;
    }

    public int move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private String validateName(String name) {
        if (name == null || name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}
