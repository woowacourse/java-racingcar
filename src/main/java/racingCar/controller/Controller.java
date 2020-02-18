package racingCar.controller;

import racingCar.domain.*;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class Controller {

	private Controller() {
	}

	public static void run() {
		RacingCar racingCar = initRacingCar();
		DeciderFactory deciderFactory = new RandomDeciderFactory();

		OutputView.printResultTitle();

		progress(racingCar, deciderFactory);

		OutputView.printWinners(racingCar.getWinners());
	}

	private static void progress(RacingCar racingCar, DeciderFactory deciderFactory) {
		OutputView.printEachRound(racingCar.getRound(),
				racingCar.getPlayerNames(), racingCar.getPlayerPositions());

		while (!racingCar.isEnd()) {
			racingCar.race(deciderFactory);
			OutputView.printEachRound(racingCar.getRound(),
					racingCar.getPlayerNames(), racingCar.getPlayerPositions());
		}
	}

	private static RacingCar initRacingCar() {
		Players players = PlayersFactory.create(InputView.inputUserNames());
		while (!players.isReady()) {
			OutputView.printInvalidNameWarning();
			players = PlayersFactory.create(InputView.inputUserNames());
		}
		int totalRound = InputView.inputNumberOfRound();

		return new RacingCar(players, totalRound);
	}
}
