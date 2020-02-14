package racing;

import java.util.List;

import racing.controller.CarGenerator;
import racing.controller.Track;
import racing.domain.Car;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {
	public static void main(String[] args) {
		List<String> carNames = InputView.inputCarNames();
		CarGenerator carGenerator = new CarGenerator();
		List<Car> cars = carGenerator.generateCars(carNames);
		RacingGame racingGame = new RacingGame(cars);
		int roundNumber = InputView.inputRoundNumber();

		Track track = new Track();
		track.playRacingGame(roundNumber, racingGame);

		OutputView.printWinner(racingGame.findWinner());
	}
}
