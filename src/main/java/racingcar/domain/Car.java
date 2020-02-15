package racingcar.domain;

import javax.crypto.MacSpi;

public class Car {
    public static final int INIT_POSITION = 0;

    private final Name name;
    private int position;

    public Car(Name name) {
        if (RaceResult.EMPTY.equals(name.getName())) {
            throw new IllegalArgumentException("입력이 없는 이름이 있습니다.");
        }

        this.name = name;
        this.position = INIT_POSITION;
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return name.getName();
    }
}