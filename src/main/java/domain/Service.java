package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import view.OutputView;

public class Service {
    private final List<Car> cars = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public Service() {
    }

    public List<String> separateCarName(String carNames) {
        return List.of(carNames.split(","));
    }

    public List<Car> setCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        validateCar();
        return cars;
    }

    private void validateCar() {
        validateCarAmount();
        validateDuplicateName();
    }

    private void validateDuplicateName() {
        int duplication = 0;
        Set<String> validateCar = new HashSet<>();
        for (Car car : cars) {
            duplication = validateDuplication(car.getCarName(), validateCar);
        }

        if (cars.size() != duplication) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
        }
    }

    private int validateDuplication(String carName, Set<String> validateCar) {
        validateCar.add(carName);
        return validateCar.size();
    }

    private void validateCarAmount() {
        if (cars.size() == 1) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차를 두 대 이상 입력해주세요.");
        }
    }

    public void playGame(int attemptLimit) {
        OutputView.printHeadLine();
        int count = 0;
        while (count < attemptLimit) {
            playRacing();
            OutputView.printResult(cars);
            count++;
        }
    }

    public List<String> getWinnerName() {
        int max = -1;
        for (Car car : cars) {
            int location = car.getLocation();
            max = updateWinner(max, location, car);
        }

        return winners;
    }

    private int updateWinner(int max, int location, Car car) {
        if (max == location) {
            winners.add(car.getCarName());
        }

        if (max < location) {
            max = location;
            winners.clear();
            winners.add(car.getCarName());
        }
        return max;
    }

    private void playRacing() {
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

    public List<Car> getCars() {
        return cars;
    }
}
