package racingcar.domain;

import racingcar.domain.Generator.CarMoveValueGenerator;

public class Car implements Comparable<Car> {
    private static final int FORWARD_NUMBER = 4;
    private Name name;
    private int position;
    private CarMoveValueGenerator carMoveValueGenerator;

    public Car(Name name, CarMoveValueGenerator carMoveValueGenerator) {
        this.name = name;
        this.position = 0;
        this.carMoveValueGenerator = carMoveValueGenerator;
    }

    public int movePosition() {
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
