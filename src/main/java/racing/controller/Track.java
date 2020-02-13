package racing.controller;

import racing.domain.RacingGame;
import racing.view.OutputView;

public class Track {
	public void playRacingGame(int gameRounds, RacingGame playRacingGame) {
		for (int i = 0; i < gameRounds; i++) {
			playRacingGame.playRound();
			OutputView.printRoundPosition(playRacingGame);
		}
	}
}
