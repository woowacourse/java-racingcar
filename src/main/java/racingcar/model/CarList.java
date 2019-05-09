package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<>();
    private final int numberOfTry;

    public CarList(String[] carNames, int numberOfTry) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        this.numberOfTry=numberOfTry;
    }

    public void moveCarsByNumberOfTry() {
        for (int i = 0; i < this.numberOfTry; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : carList) {
            car.move(Random.isEnableGo());
        }
    }
}
