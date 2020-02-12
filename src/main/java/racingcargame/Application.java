package racingcargame;

import racingcargame.domain.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.inputNameInstruction();
        final String userInputName = InputView.inputNames();

        OutputView.inputRepeatInstruction();
        final int userInputRepeat = InputView.inputRepeat();

        RacingCarGame game = new RacingCarGame();
        String winner = game.run(userInputName, userInputRepeat);

        OutputView.resultInstruction();
        OutputView.winnerInstruction(winner);
    }
}
