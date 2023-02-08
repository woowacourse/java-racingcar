package domain;

class Car {

    private static final int CAR_NAME_LOWER_BOUND = 0;
    private static final int CAR_NAME_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "차의 이름은 1자 이상 ~ 5자 이하여야 합니다.";

    public Car(String name) {
        validate(name);
    }

    private void validate(String name) {
        if (CAR_NAME_LOWER_BOUND == name.length() || CAR_NAME_UPPER_BOUND < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }
}
