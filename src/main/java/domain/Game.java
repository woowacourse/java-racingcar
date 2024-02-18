package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Game {
    public final int MAX_NUM = 9;
    public final int THRESHOLD = 4;
    public final Car NONCANDIDATE_CAR = new Car("");

    public Game() {
    }

    public int setAttemptLimit(String attemptLimit) {
        return validateNumber(validateInputAttemptLimit(attemptLimit));
    }

    private int validateInputAttemptLimit(String attemptLimit) {
        try {
            return Integer.parseInt(attemptLimit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }

    private int validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수여야 합니다.");
        }
        return inputAttemptLimit;
    }

    public List<Car> setCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : separateCarName(carNames)) {
            cars.add(new Car(carName));
        }
        validateCar(cars);
        return cars;
    }

    private List<String> separateCarName(String carNames) {
        return List.of(carNames.split(","));
    }

    private void validateCar(List<Car> cars) {
        validateCarAmount(cars);
        validateDuplicateName(cars);
        validateFalseName(cars);
    }

    private void validateDuplicateName(List<Car> cars) {
        int duplication = 0;
        Set<String> validateCar = new HashSet<>();
        for (Car car:cars) {
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

    private void validateFalseName(List<Car> cars) {
        for (Car car : cars) {
            validateBlankName(car);
        }
    }

    private void validateBlankName(Car car) {
        if (car.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 이름은 사용할 수 없습니다.");
        }
    }

    private void validateCarAmount(List<Car> cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차를 두 대 이상 입력해주세요.");
        }
    }

    public List<String> getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(findWinner(car, getMaxPosition(cars)));
        }
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int max = -1;
        for (Car car : cars) {
            max = compareValue(car, max);
        }
        return max;
    }

    private String findWinner(Car car, int maxPosition) {
        if (car.isSamePosition(maxPosition)) {
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

    public void playRacing(List<Car> cars) {
        for (Car car : cars) {
            goOrStop(car, randomNumberGenerator());
        }
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }

    private void goOrStop(Car car, int randomNumber) {
        if (randomNumber >= THRESHOLD) {
            car.incLocation();
        }
    }
}
