package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import view.OutputView;

public class Service {
    public final Car NONCANDIDATE_CAR = new Car("");

    public Service() {
    }

    public List<String> separateCarName(String carNames) {
        return List.of(carNames.split(","));
    }

    public List<Car> setCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        validateDuplicateName(cars);
        validateFalseName(cars);
        return cars;
    }

    private void validateDuplicateName(List<Car> cars) {
        Set<Car> validateCar = new HashSet<>(cars);

        if (cars.size() != validateCar.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
        }
    }

    private void validateFalseName(List<Car> cars) {
        for (Car car : cars) {
            validateBlankName(car.getCarName());
        }
    }

    private void validateBlankName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 이름은 사용할 수 없습니다.");
        }
    }

    public void playGame(List<Car> cars, int attemptLimit) {
        OutputView.printHeadLine();
        int count = 0;
        while (count < attemptLimit) {
            playRacing(cars);
            OutputView.printResult(cars);
            count++;
        }
    }

    public List<String> getWinner(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(findWinner(car, maxPosition));
        }
        return winners;
    }

    public int getMaxPosition(List<Car> cars) {
        int max = -1;
        for (Car car : cars) {
            max = compareValue(car, max);
        }
        return max;
    }

    private String findWinner(Car car, int maxPosition) {
        if (car.getLocation() == maxPosition) {
            return car.getCarName();
        }
        return NONCANDIDATE_CAR.getCarName();
    }

    private int compareValue(Car car, int max) {
        if (max <= car.getLocation()) {
            max = car.getLocation();
        }
        return max;
    }


    private void playRacing(List<Car> cars) {
        for (Car car : cars) {
            goOrStop(car, randomNumberGenerator());
        }
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(9);
    }

    private void goOrStop(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.incLocation();
        }
    }
}