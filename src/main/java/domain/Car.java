package domain;

import java.util.Objects;

import utils.constants.GameRules;
import utils.constants.PrintSigns;

public class Car implements Comparable<Car>{
    private final String name;
    private Long position = 0L;

    public Car(String name) {
        GameRules.validateNameLength(name);
        this.name = name;
    }

    public void move(int number) {
        if (GameRules.canMove(number)) {
            position++;
        }
    }

    public String retrieveMoveResults() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PrintSigns.SEPARATOR.getSign());
        for (int i = 0; i < position; i++) {
            stringBuilder.append(PrintSigns.POSITION.getSign());
        }
        return name + stringBuilder;
    }

    @Override
    public int compareTo(Car compared) {
        return (int)(this.position - compared.position);
    }

    public boolean isSamePosition(Car compared) {
        return Objects.equals(this.position, compared.position);
    }

    public String getName() {
        return name;
    }

    public Long getPosition() {
        return position;
    }
}
