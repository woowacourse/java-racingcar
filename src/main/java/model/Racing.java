package model;

import message.Constant;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Racing {

    private Map<Car, Integer> distanceByEachCar;
    private int winnerDistance;
    private RandomNumberGenerator randomNumberGenerator;

    public Racing(List<String> carNames, RandomNumberGenerator randomNumberGenerator) {
        distanceByEachCar = new LinkedHashMap<>();
        winnerDistance = Constant.START_POSITION;
        this.randomNumberGenerator = randomNumberGenerator;
        carsGenerate(carNames);
    }

    private void carsGenerate(List<String> carNames) {
        carNames.forEach(carName -> distanceByEachCar.put(new Car(carName), Constant.START_POSITION));
    }

    public void moveAllCars() {
        distanceByEachCar.keySet().forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        boolean isPossibleToMove = car.move(randomNumberGenerator.generate(Constant.RANDOM_NUMBER_GENERATE_UPPER_BOUND));

        if (isPossibleToMove) {
            int distance = distanceByEachCar.get(car) + Constant.CAR_MOVE_DISTANCE;
            updateWinnerDistance(distance);
            distanceByEachCar.put(car, distance);
        }
    }

    private void updateWinnerDistance(int distance) {
        winnerDistance = Math.max(winnerDistance, distance);
    }

    private String carResultToString(Car car) {
        return String.format(Constant.CAR_RESULT, car.toString(), Constant.STICK.repeat(distanceByEachCar.get(car)));
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
