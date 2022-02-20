package racingcargame.model.car;

import racingcargame.dto.CarDto;
import racingcargame.model.car.vo.CarName;
import racingcargame.model.car.vo.CarPosition;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(final String name) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition();
    }

    public void moveCar(final int moveValue) {
        carPosition.move(moveValue);
    }

    public boolean hasSamePosition(final Car winnerCar) {
        return carPosition.compareTo(winnerCar.carPosition) == 0;
    }

    public CarDto changeToDto() {
        return new CarDto(carName.getName(), carPosition.getPosition());
    }

    @Override
    public int compareTo(final Car otherCar) {
        if (this.carPosition.getPosition() > otherCar.carPosition.getPosition()) {
            return -1;
        } else if (this.carPosition.getPosition() < otherCar.carPosition.getPosition()) {
            return 1;
        }
        return 0;
    }
}

