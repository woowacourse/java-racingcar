package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import racingcar.utils.CarNameValidator;
import racingcar.utils.RandomNumberGenerator;

public class Cars {
    public static final int START_POSITION = 0;
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars;

    public Cars(String[] carNames) {
        CarNameValidator.validateCarNames(carNames);
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, START_POSITION));
        }
    }

    public void startEachRace() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.makeRandom(RANDOM_NUMBER_BOUND));
        }
    }

    public void startEachRace(int bound) {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.makeRandom(bound));
        }
    }

    public void startEachRace(int bound, int multiple) {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.makeRandom(bound) * multiple);
        }
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winnerCars = new ArrayList<>();
        cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .forEach(winnerCars::add);
        return winnerCars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
