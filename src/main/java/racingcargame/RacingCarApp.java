package racingcargame;

import static racingcargame.view.InputView.*;
import static racingcargame.view.OutputView.*;

import java.util.List;

import racingcargame.controller.RacingCarController;
import racingcargame.domain.MoveStrategy;
import racingcargame.domain.NumberGenerator;
import racingcargame.domain.RacingResult;
import racingcargame.domain.RepeatTimes;

public class RacingCarApp {
	public static void main(String[] args) {
		final String names = inputNames();
		final RepeatTimes repeatTimes = new RepeatTimes(inputRepeat());
		final MoveStrategy moveStrategy = new NumberGenerator();

		printRaceResultMessage();
		final RacingCarController game = new RacingCarController();
		final RacingResult racingResult = game.run(names, repeatTimes, moveStrategy);
		printRaceResult(racingResult);

		final List<String> winners = racingResult.getWinners();
		printWinner(winners);
	}
}
