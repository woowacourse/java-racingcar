package racingcar.domain;

import static racingcar.message.ErrorMessage.ERROR_WITH_CONTAIN_BLANK;
import static racingcar.message.ErrorMessage.ERROR_WITH_OVER_LENGTH;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int BOUND = 10;

    private final String name;
    private int position;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        validateCarName(name);
        this.numberGenerator = numberGenerator;
        this.name = name;
    }

    private void validateCarName(String name) {
        validateSpaceInName(name);
        validateLength(name);
    }

    private void validateSpaceInName(String name) {
        if(name.contains(" ")) {
            throw new IllegalArgumentException(ERROR_WITH_CONTAIN_BLANK);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_WITH_OVER_LENGTH);
        }
    }

    private boolean canMove(){
        int random = numberGenerator.generateNumber(BOUND);
        return random >= 4;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    public int comparePosition(int otherPosition){
        return Math.max(otherPosition, position);
    }

    public boolean matchesPosition(int otherPosition){
        return position == otherPosition;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }



}
