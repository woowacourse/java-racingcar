package racingcargame.view;

import static racingcargame.view.InputView.*;
import static racingcargame.view.OutputView.*;

import java.util.List;

import racingcargame.controller.RacingCarController;
import racingcargame.domain.CarStatus;
import racingcargame.domain.RepeatTimes;

public class RacingCarApp {
	public static void main(String[] args) {
		final String names = inputNames();
		final int repeat = parseStringToInt(inputRepeat());
		final RepeatTimes repeatTimes = new RepeatTimes(repeat);

		printRaceResultMessage();
		final RacingCarController game = new RacingCarController();
		final List<CarStatus> racingResult = game.run(names, repeatTimes);
		printRaceResult(racingResult);

		final List<String> winners = game.winners;
		printWinner(winners);
	}

	private static int parseStringToInt(String inputRepeat) {
		try {
			return Integer.parseInt(inputRepeat);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("정수를 입력해주세요.");
		}
	}

}
