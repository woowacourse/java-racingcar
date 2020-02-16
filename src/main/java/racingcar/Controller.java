package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.utils.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	public static void main(String[] args) {

		String inputNames = InputView.receiveNameInput();
		Cars cars = new Cars(inputNames);
		int count = InputView.receiveCountInput();
		RacingGame racingGame = new RacingGame(cars, count);
		RandomGenerator randomGenerator = new RandomGenerator();

		OutputView.showResult();
		while (!racingGame.isEnd()) {
			racingGame.race(randomGenerator);
			OutputView.showRace(racingGame.getCars());
		}
		OutputView.showWinner(cars.getWinners());
	}
}
