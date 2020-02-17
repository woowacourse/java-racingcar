package racingcar.domain;

import racingcar.domain.Generator.RandomGenerator;

public class Car implements Comparable<Car> {
    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public int movePosition(RandomGenerator randomGenerator) {
        if (randomGenerator.isMovable()) {
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
