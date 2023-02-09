package domain;

import utils.constants.ErrorMessages;
import utils.constants.GameRules;

public class Car {
    private final String name;
    private Long status = 0L;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber > GameRules.MOVE_NUMBER.getValue()) {
            status++;
        }
    }

    private void validateName(String name) {
        if (name.length() > GameRules.NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH.getMessage());
        }
    }

    public Long getStatus() {
        return status;
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" : ");
        for (int i = 0; i < status; i++) {
            stringBuilder.append("-");
        }
        return name + stringBuilder;
    }
}
