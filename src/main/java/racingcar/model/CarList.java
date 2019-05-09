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

    public WinningCars getWinnerCars() {
        int maxPosition = 0;
        WinningCars winningCars = new WinningCars();
        for (Car car : carList) {
            maxPosition = Integer.max(maxPosition, car.getPosition());
        }
        for (Car car : carList) {
            car.addWinners(winningCars.getWinningCarNames(), maxPosition);
        }
        return winningCars;
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
