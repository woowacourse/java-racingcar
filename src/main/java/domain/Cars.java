package domain;

import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars createByNames(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    public void moveRandomly() {
        Random random = new Random();

        carList.forEach((car) -> {
            int randomInt = Math.abs(random.nextInt() % 10);
            car.move(randomInt >= 4);
        });
    }

    public List<Car> findWinner() {
        int maxPosition = carList.stream().mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
