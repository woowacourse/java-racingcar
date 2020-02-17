package racingcar.domain;

import racingcar.domain.Generator.CarMoveValueGenerator;

public class Car implements Comparable<Car> {
    private static final int FORWARD_NUMBER = 4;
    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public int movePosition(CarMoveValueGenerator carMoveValueGenerator) {
        if (carMoveValueGenerator.generateCarMoveValue() > FORWARD_NUMBER) {
            this.position++;
        }
        return position;
    }

    public boolean isMaxPosition(Car maxPositionCar) {
        return this.position == maxPositionCar.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
