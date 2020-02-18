package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";
    private static final String OUT_OF_CARS_INDEX = "자동차 배열에 잘못된 접근입니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = cars;
    }

    private void validateDuplicateNames(List<Car> cars) {
        boolean isDuplicated = cars.stream()
                .map(Car::getName)
                .distinct()
                .count() != cars.size();
        if (isDuplicated) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    public int getSize() {
        return cars.size();
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    public List<Car> findByPosition(int position) {
        return cars.stream()
                .filter(car -> car.isSamePosition(position))
                .collect(Collectors.toList());
    }

    public RacingResults moveCars() {
        RacingResults racingResults = new RacingResults();
        int carsSize = cars.size();
        for (int count = 0; count < carsSize; count++) {
            cars.get(count).move(RandomNumber.getRandomNumber());
            racingResults.add(new RacingResult(cars.get(count).getName(), cars.get(count).getPosition()));
        }
        return racingResults;
    }

    public Car get(int index) {
        if (index < 0 || index > cars.size())
            throw new ArrayIndexOutOfBoundsException(OUT_OF_CARS_INDEX);
        return cars.get(index);
    }
}
