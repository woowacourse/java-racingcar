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
        //TODO 우승한 자동차들을 반환한다.
    }

    public List<Cars> getResult() {
        //TODO 결과를 반환한다.
    }

    private void playOneRound() {
        if (round.isPossibleToRacing()) {
            cars.moveEachCar();
        }
        result.add(cars);
    }

}
