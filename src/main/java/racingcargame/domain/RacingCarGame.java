package racingcargame.domain;

import racingcargame.view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    public String run(String userInputName, int userInputRepeat) {
        final RacingCars cars = new RacingCars(userInputName);
        processGame(userInputRepeat, cars);
        return cars.getWinner();
    }

    private void processGame(int repeat, RacingCars cars) {
        OutputView.newLine();
        OutputView.resultInstruction();
        for (int i = 0; i < repeat; i++) {
            cars.processOneTime();
            OutputView.newLine();
        }
    }
}
