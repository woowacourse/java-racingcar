package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	public static void main(String[] args) {
		try {
			String inputNames = InputView.receiveNameInput();
			Cars cars = new Cars(inputNames);
			int count = InputView.receiveCountInput();

			OutputView.showResult();
			OutputView.showRace(RacingGame.showEachRaceResult(cars, count));
			OutputView.showWinner(cars.getWinners());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
