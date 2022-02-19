package racingcar.domain;

import racingcar.controller.RacingCarController;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame implements Game {

    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorView errorView;

    public RacingCarGame(InputView inputView, OutputView outputView, ErrorView errorView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
    }

    @Override
    public void play(Rule rule) {
        RacingCarController controller = createController();
        runGame(controller, rule);
    }

    private RacingCarController createController() {
        try {
            String inputCarNames = inputView.inputCarNames();
            String inputRoundNumber = inputView.inputRoundNumber();
            return new RacingCarController(inputCarNames, inputRoundNumber);
        } catch (IllegalArgumentException e) {
            errorView.error(e);
            return createController();
        }
    }

    private void runGame(RacingCarController controller, Rule rule) {
        outputView.printProcessPrompt();
        while (controller.isRunnable()) {
            outputView.printCarsPosition(controller.run(rule.getMovementStrategy()));
        }
        outputView.printWinners(controller.end());
    }
}
