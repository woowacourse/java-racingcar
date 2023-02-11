package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Racing {

    private static final String STICK = "-";
    public static final String CAR_RESULT = "%s : %s\n";

    public static final int RANDOM_NUMBER_GENERATE_UPPER_BOUND = 10;
    public static final int START_POSITION = 0;
    public static final int CAR_MOVE_DISTANCE = 1;

    private Map<Car, Integer> distanceByEachCar;
    private int winnerDistance;
    private RandomNumberGenerator randomNumberGenerator;


    public Racing(List<String> carNames, RandomNumberGenerator randomNumberGenerator) {
        distanceByEachCar = new LinkedHashMap<>();
        winnerDistance = START_POSITION;
        this.randomNumberGenerator = randomNumberGenerator;
        carsGenerate(carNames);
    }

    private void carsGenerate(List<String> carNames) {
        carNames.forEach(carName -> distanceByEachCar.put(new Car(carName), START_POSITION));
    }

    public void moveAllCars() {
        distanceByEachCar.keySet().forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        boolean isPossibleToMove = car.move(randomNumberGenerator.generate(RANDOM_NUMBER_GENERATE_UPPER_BOUND));

        if (isPossibleToMove) {
            int distance = distanceByEachCar.get(car) + CAR_MOVE_DISTANCE;
            updateWinnerDistance(distance);
            distanceByEachCar.put(car, distance);
        }
    }

    private void updateWinnerDistance(int distance) {
        winnerDistance = Math.max(winnerDistance, distance);
    }

    private String carResultToString(Car car) {
        return String.format(CAR_RESULT, car.toString(), STICK.repeat(distanceByEachCar.get(car)));
    }

    public List<Car> winner() {
        return distanceByEachCar.keySet()
                .stream()
                .filter(car -> distanceByEachCar.get(car) == winnerDistance)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return distanceByEachCar.keySet()
                .stream()
                .map(this::carResultToString)
                .collect(Collectors.joining());
    }
}
