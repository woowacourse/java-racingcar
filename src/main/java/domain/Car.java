package domain;

import vo.Name;
import vo.Position;

public class Car {
    private final Name name;
    private Position position;

    public Car(Name name) {
        validateName(name);
        this.name = name;
        this.position = Position.of(0L);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber > 3) {
            position = position.plus();
        }
    }

    private void validateName(Name name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자 까지만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
