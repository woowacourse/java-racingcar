package racingcargame;

import static racingcargame.view.InputView.*;
import static racingcargame.view.OutputView.*;

import java.util.List;

import racingcargame.controller.RacingCarController;
import racingcargame.domain.RepeatTimes;
import racingcargame.domain.RacingResult;

public class RacingCarApp {
	public static void main(String[] args) {
		final String names = inputNames();
		final RepeatTimes repeatTimes = new RepeatTimes(inputRepeat());

		printRaceResultMessage();
		final RacingCarController game = new RacingCarController();
		final RacingResult racingResult = game.run(names, repeatTimes);
		printRaceResult(racingResult);

		final List<String> winners = racingResult.getWinners();
		printWinner(winners);
	}
}
