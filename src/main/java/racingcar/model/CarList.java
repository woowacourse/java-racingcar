package racingcar.model;

import java.util.*;

public class CarList {
    private static final int START_POSITION = 0;
    private List<Car> carList = new ArrayList<>();

    public CarList(String[] carNames) {
        if (this.isOverlap(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    /* 테스트를 위한 생성자 */
    public CarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    private boolean isOverlap(String[] carNames) {
        Set<String> hashSet = new HashSet<>();
        for (String carName : carNames) {
            hashSet.add(carName.trim());
        }
        return carNames.length != hashSet.size();
    }

    public boolean isEqualCarList(List<Car> cars) {
        int index = 0;
        while (index < carList.size() && carList.get(index).equals(cars.get(index))) {
            index++;
        }
        return index == carList.size();
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
            winningCars.addWinners(car, maxPosition);
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
