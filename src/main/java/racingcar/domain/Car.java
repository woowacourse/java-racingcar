package racingcar.domain;

public class Car {
    private static final String BLANK_REGEX = "\\s*";
    private static final int RANDOM_NUM_SCOPE = 10;
    private static final int MIN_NUM_TO_ACCELERATE = 4;
    public static final int MAX_NUM_OF_CAR_NAME = 5;

    private String name;
    private int position = 0;

    public Car(String name) {
        checkLengthOfName(name);
        checkBlank(name);
        this.name = name;
    }

    private void checkLengthOfName(String name) {
        if (name.length() > MAX_NUM_OF_CAR_NAME) {
            throw new IllegalArgumentException(MAX_NUM_OF_CAR_NAME + "자 이하의 자동차 이름을 입력하세요");
        }
    }

    private void checkBlank(String name) {
        if (name.matches(BLANK_REGEX)) {
            throw new IllegalArgumentException("자동차 이름을 공백으로 입력하지마세요");
        }
    }

    public void accelerate() {
        int numToAccelerate = (int) (Math.random() * RANDOM_NUM_SCOPE);
        if (numToAccelerate >= MIN_NUM_TO_ACCELERATE) {
            position++;
        }
    }
}
