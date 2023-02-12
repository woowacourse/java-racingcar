package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenerator;
import racingcar.exception.DuplicateException;
import racingcar.util.InputUtil;
import racingcar.util.NumberGenerator;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController implements Controller {

    private final InputUtil inputUtil = new InputUtil();
    private final NumberGenerator numberGenerator = new RaceNumberGenerator();

    @Override
    public void process() {
        Race race = setUpGame();
        playGame(race);
    }


    private Race setUpGame() {
        try {
            List<String> carNames = inputUtil.getUserInput(inputUtil::getCarNames);
            int tryCount = inputUtil.getUserInput(inputUtil::getTryCount);
            Cars cars = Cars.of(makeCars(carNames));
            return Race.of(cars, tryCount);
        } catch (IllegalArgumentException | DuplicateException e) {
            OutputView.printMessage(e.getMessage());
            return setUpGame();
        }
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream().map(Car::of).collect(Collectors.toList());
    }

    private void playGame(Race race) {
        OutputView.printHeadResult(race.getRoundResults());
        for (int i = 0; i < race.getTryCount(); i++) {
            OutputView.printRoundResult(race.playRound(numberGenerator));
        }
        OutputView.printFinalResult(race.findWinnersName());
    }
}
