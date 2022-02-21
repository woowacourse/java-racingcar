package racingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.utils.ErrorMassage;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private static final String CAR_NAME_PATTERN_REGEX = "^[a-zA-Z]*$";

    private static final Pattern CAR_NAME_PATTERN = Pattern.compile(CAR_NAME_PATTERN_REGEX);

    private final String name;
    private int position;
    private final MoveCondition moveCondition;

    public Car(String name, MoveCondition moveCondition) {
        checkName(name);
        this.name = name;
        this.position = START_POSITION;
        this.moveCondition = moveCondition;
    }

    public void movePosition() {

        if (moveCondition.isMovable()) {
            position++;
        }

    }

    public boolean isSamePosition(int number) {
        return position == number;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void checkName(String name) {

        checkLength(name);
        checkValidPattern(name);

    }

    private void checkLength(String name) {

        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMassage.NOT_ALLOW_LENGTH_ERROR);
        }

    }

    private void checkValidPattern(String name) {

        Matcher matcher = CAR_NAME_PATTERN.matcher(name);

        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMassage.NOT_ALPHA_ERROR);
        }

    }

}


