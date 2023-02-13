package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private Cars cars;
    private Round round;
    private List<Cars> result;

    public RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
        this.result = new ArrayList<>();
    }

    public void playGame() {
        while(round.isPossibleToRacing()) {
            playOneRound();
            round.minusTrialCount();
        }
    }

    public List<String> getWinners() {
        return cars.getWinners().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<Cars> getResult() {
        return result;
    }

    private void playOneRound() {
        if (round.isPossibleToRacing()) {
            cars.moveEachCar();
        }
        result.add(cars);
    }

}
