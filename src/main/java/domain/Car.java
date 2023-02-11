package domain;


import static utils.ErrorMessage.WRONG_NAME_LENGTH;

public class Car {

    private final int MOVING_STANDARD_NUM = 4;
    private final int ADD_POINT = 1;
    private final String POSITION_BAR = "-";


    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public void move(final int number) {
        if (isAllowedToMove(number)) {
            this.position += ADD_POINT;
        }
    }

    private boolean isAllowedToMove(final int number) {
        if (number >= MOVING_STANDARD_NUM) {
            return true;
        }
        return false;
    }

    public String getCarStatus() {
        return name.getName() + " : " + POSITION_BAR.repeat(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    private class Name {

        private final int MIN_NAME_SIZE = 0;
        private final int MAX_NAME_SIZE = 5;

        private final String name;

        private Name(String name) {
            validateCarNameLength(name.length());
            this.name = name;
        }

        private void validateCarNameLength(int length) {
            if (length <= MIN_NAME_SIZE || length > MAX_NAME_SIZE) {
                throw new IllegalArgumentException(WRONG_NAME_LENGTH.of());
            }
        }

        private String getName() {
            return name;
        }
    }
}
