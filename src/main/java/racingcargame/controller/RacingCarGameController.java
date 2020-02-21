package racingcargame.controller;

import java.util.List;

import racingcargame.utils.MovingConditionGenerator;
import racingcargame.utils.NumberGenerator;
import racingcargame.domain.RacingCarGame;
import racingcargame.domain.RacingCars;
import racingcargame.domain.Repeat;
import racingcargame.domain.car.Car;
import racingcargame.domain.car.Name;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class RacingCarGameController {

    public static void run() {
        List<Name> nameObjects = inputNames();
        Repeat repeat = inputRepeats();

        RacingCarGame racingCarGame = new RacingCarGame(new RacingCars(nameObjects));
        MovingConditionGenerator movingCondition = new NumberGenerator();
        List<Car> winners = racingCarGame.run(repeat, movingCondition);

        OutputView.printPlayResult();
        OutputView.printGameLog(racingCarGame.getGameLog());
        OutputView.printWinnerResult(winners);
    }

    private static Repeat inputRepeats() {
        try {
            OutputView.repeatInputInstruction();
            return InputView.inputRepeats();
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputRepeats();
        }
    }

    private static List<Name> inputNames() {
        try {
            OutputView.nameInputInstruction();
            return InputView.inputNames();
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputNames();
        }
    }
}
