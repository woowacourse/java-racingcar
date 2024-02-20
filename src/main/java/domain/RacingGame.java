package domain;

import utils.PowerGenerator;
import utils.RandomPowerGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> carGroup;
    private final PowerGenerator powerGenerator;

    private String result = "";


    public RacingGame(final String[] carNames) {
        this.carGroup = makeCarGroup(carNames);
        this.powerGenerator = new RandomPowerGenerator();
    }

    RacingGame(final String[] carNames, final PowerGenerator powerGenerator) {
        this.carGroup = makeCarGroup(carNames);
        this.powerGenerator = powerGenerator;
    }

    public String race(final RacingGame racingGame, final Attempts attempts) {
        while (!attempts.isEnd()) {
            racingGame.move();
            attempts.decrease();
        }
        return result;
    }

    public void move() {
        carGroup.forEach(car -> {
            car.move(powerGenerator.getNumber());
            addResult(car);
        });
        result += "\n";
    }

    private void addResult(Car car) {
        result += car.getName() + " : " + "-".repeat(car.getPosition()) + "\n";
    }

    public List<Car> getAllCars() {
        return carGroup;
    }

    public List<Car> getWinners() {
        final int positionMax = getPositionMax();

        if (positionMax == 0) {
            return List.of();
        }

        return carGroup.stream()
                .filter(car -> car.isPositionedAt(positionMax))
                .toList();
    }

    private List<Car> makeCarGroup(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getPositionMax() {
        return carGroup.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
