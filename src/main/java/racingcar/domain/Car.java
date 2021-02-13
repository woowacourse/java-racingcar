package racingcar.domain;

import javafx.util.Pair;
import utils.RandomUtils;

public class Car {

    private static final int MINIMUM_RANDOM_RPM = 0;
    private static final int MAXIMUM_RANDOM_RPM = 9;
    private static final int MOVABLE_MINIMUM_RPM = 3;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public void move(int rpm) {
        if (rpm > MOVABLE_MINIMUM_RPM) {
            position++;
        }
    }

    public Pair<String, Integer> racing() {
        move(RandomUtils.nextInt(MINIMUM_RANDOM_RPM, MAXIMUM_RANDOM_RPM));
        return new Pair<>(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(
                "자동차 이름은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하로 입력해주세요.");
        }
    }
}
