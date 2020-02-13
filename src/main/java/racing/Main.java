package racing;

import java.util.Scanner;

import racing.controller.Track;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		Scanner input = inputView.input();
		RacingGame racingGame = new RacingGame(InputView.inputCarNames(input));
		int roundNumber = InputView.inputRoundNumber(input);

		Track track = new Track();
		track.playRacingGame(roundNumber, racingGame);

		OutputView.printWinner(racingGame.findWinner());
	}
}
