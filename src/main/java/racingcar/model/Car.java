package racingcar.model;

import racingcar.utils.RandomUtils;

public class Car {

    private final String name;
    private int position;
    public static final String CAR_NAME_INVALID = "자동차 이름이 유효하지 않습니다.";

    public Car(String name) {
        validateCarName(name.trim());
        this.name = name;
        this.position = 0;
    }

    public void validateCarName(String name) {
        if(name.length() > 5 || name.length() <= 0){
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }

    public void movePosition(int number) {
        if(number >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMaxPosition(int max) {
        return max == position;
    }
}
