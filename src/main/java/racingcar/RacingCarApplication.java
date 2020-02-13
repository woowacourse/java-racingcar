package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.CarNameSplitter;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 프로그램 실행 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class RacingCarApplication {
	public static void main(String[] args) {
		try {
			RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
			String names = InputView.inputNames();
			Cars cars = new Cars(CarNameSplitter.split(names));
			Round round = new Round(InputView.inputRound());

			RacingGame racingGame = new RacingGame(cars, round, randomNumberGenerator);
			racingGame.run();
		} catch (IllegalArgumentException | NullPointerException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
	}
}
