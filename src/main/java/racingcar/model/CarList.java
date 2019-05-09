package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<>();

    public CarList(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveCars() {
        for (Car car : carList) {
            car.move(Random.isEnableGo());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.toString()).append("\n");
        }
        return sb.toString();
    }
}
