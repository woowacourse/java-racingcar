package racingcargame.model.car;

import racingcargame.dto.CarDto;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void moveCar(final int moveValue) {
        position.move(moveValue);
    }

    public boolean hasSamePosition(final Car winnerCar) {
        return position.compareTo(winnerCar.position) == 0;
    }

    public CarDto changeToDto() {
        return new CarDto(name.getName(), position.getPosition());
    }

    @Override
    public int compareTo(final Car otherCar) {
        if (this.position.getPosition() > otherCar.position.getPosition()) {
            return -1;
        } else if (this.position.getPosition() < otherCar.position.getPosition()) {
            return 1;
        }
        return 0;
    }
}

