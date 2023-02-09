package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.";

    private String name;
    private int position;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.position = 0;
        this.numberGenerator = numberGenerator;
    }

    public int getPosition() {
        return this.position;
    }

    public String getMovePosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public String getName() {
        return this.name;
    }

    public void goForward() {
        if (numberGenerator.generate() >= MOVABLE_MIN_NUMBER) {
            position++;
        }
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position == otherCar.position;
    }

    // 자동차 이름의 길이를 검증하는 메소드
    private void validateName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return otherCar.position - this.position;
    }
}
