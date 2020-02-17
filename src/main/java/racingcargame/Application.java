package racingcargame;

import racingcargame.domain.EachRaceResultDto;
import racingcargame.domain.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            OutputView.inputNameInstruction();
            final String userInputName = InputView.inputNames();
            OutputView.inputRepeatInstruction();
            final int userInputRepeat = InputView.inputRepeat();

            RacingCarGame game = new RacingCarGame();
            List<EachRaceResultDto> carStatus = game.run(userInputName, userInputRepeat);
            OutputView.resultInstruction();
            for (EachRaceResultDto eachRaceResultDto : carStatus) {
                OutputView.printEachRaceStatus(eachRaceResultDto);
            }
            OutputView.winnerInstruction(game.getWinner());
        }
        catch (Exception e) {
            OutputView.errorMessage(e.getMessage());
        }
    }
}
