package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private static final int START_POSITION = 0;
    private List<Car> carList = new ArrayList<>();

    public CarList(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    /* 테스트를 위한 생성자 */
    public CarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveCars() {
        for (Car car : carList) {
            car.move(Random.createRandomNumber());
        }
    }

    public WinningCars getWinnerCars() {
        int maxPosition = START_POSITION;
        WinningCars winningCars = new WinningCars();
        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
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
