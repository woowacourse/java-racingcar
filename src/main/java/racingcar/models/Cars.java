package racingcar.models;

import racingcar.utils.RandomNumber;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String CAR_POSITION = "-";
    private static final String NAME_POSITION_SPLITTER = " : ";
    private final static String CAR_NAME_DISTRIBUTOR = ", ";

    private final List<Car> cars;
    private final RandomNumber randomNumber;

    public Cars(List<Car> cars) {
        this.randomNumber = RandomNumber.getInstance();
        this.cars = cars;
    }

    public void startOneTurn() {
        cars.forEach(car -> {
            int randomNumber = this.randomNumber.getRandomNumber();
            car.goForward(randomNumber);
        });
    }

    public String findWinners() {
        final int farthestPosition = findFarthestPosition();
        return getWinners(farthestPosition);
    }

    private int findFarthestPosition() {
        final List<Integer> sortedCars = cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .map(Car::getPosition)
                .collect(Collectors.toList());

        if (!sortedCars.isEmpty()) {
            return sortedCars.get(0);
        }
        return 0;
    }

    private String getWinners(final int farthestPosition) {
        return cars.stream()
                .filter((car) -> car.isWinner(farthestPosition))
                .map(Car::getName)
                .collect(Collectors.joining(CAR_NAME_DISTRIBUTOR));
    }

    public List<String> turnResult() {
        return cars.stream()
                .map(this::carTurnResult)
                .collect(Collectors.toList());
    }

    private String carTurnResult(Car car) {
        StringBuilder result = new StringBuilder();
        result.append(car.getName() + NAME_POSITION_SPLITTER);
        for (int i = 0; i < car.getPosition(); i++) {
            result.append(CAR_POSITION);
        }
        return result.toString();
    }
}
