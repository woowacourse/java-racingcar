package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class RacingcarGame {

    private static final String SEPARATOR = ",";
    private static final int MINIMUM_PARTICIPANT = 2;

    private String carNames;
    private int tryCount;
    private Cars cars;

    public RacingcarGame(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public void run() {
        cars = makeCars(carNames);

        OutputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            OutputView.printResult(cars);
        }

        List<Car> winners = findWinner(cars);
        OutputView.printWinner(winners);
    }

    private Cars makeCars(String carNames) {
        String[] participants = carNames.split(SEPARATOR);
        validateCarCount(participants);

        return new Cars(Arrays.stream(participants)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private void validateCarCount(String[] names) {
        if (names.length < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 " + MINIMUM_PARTICIPANT + "명이 필요해요.");
        }
    }

    private List<Car> findWinner(Cars cars) {
        int winnerPosition = cars.findMaxPosition();

        return cars.findWinners(winnerPosition);
    }
}
