package domain;

import utils.constants.ErrorMessages;
import utils.constants.GameRules;
import utils.constants.PrintSigns;

public class Car {
    private final String name;
    private Long position = 0L;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber > GameRules.MOVE_NUMBER.getValue()) {
            position++;
        }
    }

    private void validateName(String name) {
        if (name.length() > GameRules.NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH.getMessage());
        }
    }

    public Long getPosition() {
        return position;
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PrintSigns.POSITION.getSign());
        for (int i = 0; i < position; i++) {
            stringBuilder.append(PrintSigns.SEPARATOR.getSign());
        }
        return name + stringBuilder;
    }
}
