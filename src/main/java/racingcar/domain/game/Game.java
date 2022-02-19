package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.movement.Movement;
import racingcar.domain.trialcount.TrialCount;
import racingcar.dto.CarDto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;

    private final Cars cars;
    private final TrialCount trialCount;
    private final Movement movementStrategy;
    private final int numberOfCars;
    private final Random random = new Random();

    public Game(final List<String> carNames, final int trialCount, final Movement movementStrategy) {
        this.cars = new Cars(carNames);
        this.trialCount = new TrialCount(trialCount);
        this.movementStrategy = movementStrategy;
        numberOfCars = carNames.size();
    }

    public void playOneRound() {
        final List<Integer> randomNumbers = generateRandomNumbers();
        cars.move(movementStrategy.getMovementValues(randomNumbers));
        trialCount.decrease();
    }

    private List<Integer> generateRandomNumbers() {
        return IntStream.generate(() -> random.nextInt(RANDOM_NUMBER_BOUNDARY))
                .limit(numberOfCars)
                .boxed()
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isNotOver() {
        return trialCount.isHigherThanZero();
    }

    public List<CarDto> getRoundResult() {
        return cars.getCarInfos();
    }

    public List<CarDto> getWinners() {
        return cars.getFarthestCar();
    }
}
