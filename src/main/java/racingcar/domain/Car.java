package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final Position position
            ;

    public Car(String carName) {
        this.name = new CarName(carName);
        this.position
                = new Position();
    }

    public void move(CarMovement movement) {
        if(movement.isMove()){
            this.position
                    .increasePosition();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPos() {
        return position
                .getValue();
    }

    @Override
    public int compareTo(Car o) {
        return this.position
                .compareTo(o.position
                );
    }

    public static class CarManager {
        private List<Car> cars;

        public CarManager(List<Car> cars) {
            this.cars = cars;
        }

        public void moveCarsRandomly() {
            this.cars.forEach(car -> car.move(makeRandomCarMove()));
        }

        public List<Car> getCars() {
            return this.cars;
        }

        public List<Car> getWinners() {
            Car maxCar = Collections.max(cars);
            return cars.stream()
                    .filter(car -> car.compareTo(maxCar) == 0)
                    .collect(Collectors.toList());
        }

        private CarMovement makeRandomCarMove() {
            int moveCount = (int) (Math.random() * 10);
            return new CarMovement(moveCount);
        }
    }
}
