package racingcar.domain;

import racingcar.domain.Car;

public class MockCar extends Car {

    private int position = 0;

    public MockCar() {
        super("name");
    }

    public MockCar(int position) {
        super("name");
        this.position = position;
    }

    @Override
    public void move(boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public int getPosition() {
        return position;
    }
}
