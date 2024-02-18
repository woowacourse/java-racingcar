package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import view.OutputView;

public class Service {
    private final List<Car> cars;

    public Service() {
        this.cars = new ArrayList<>();
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
        int max = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(-1);

        return cars.stream()
                .filter(car -> car.getLocation() == max)
                .map(Car::getCarName)
                .collect(Collectors.toList());
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
