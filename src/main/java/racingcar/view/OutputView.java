package racingcar.view;

import static racingcar.messsages.OutputViewMessage.*;

import java.util.List;

import racingcar.domain.car.Car;
import racingcar.dto.GameWinnersResponse;
import racingcar.dto.RoundResultResponse;

public class OutputView {
	public void printResultMessage() {
		System.out.println(RESULT_MESSAGE.getMessage());
	}
	public void printRoundResult(final RoundResultResponse response) {
		final String roundResultMessage = createRoundResult(response);
		System.out.print(roundResultMessage);
	}

	public void printEndGameResult(final GameWinnersResponse response) {
		final String winnerNamesMessage = createWinnerResult(response);
		System.out.print(winnerNamesMessage + GAME_RESULT_MESSAGE.getMessage());
	}

	public void printErrorMessage(final String message) {
		System.out.println(message);
	}

	private String createWinnerResult(final GameWinnersResponse response) {
		return String.join(WINNER_DELIMITER.getMessage(), response.getWinnerNames());
	}

	private String createRoundResult(final RoundResultResponse roundResultDTO) {
		final StringBuilder resultBuilder = new StringBuilder();
		final List<Car> cars = roundResultDTO.getCars();
		for (final Car car : cars) {
			final int carPosition = car.getPositionValue();
			resultBuilder.append(car.getNameValue())
				.append(RESULT_SEPARATOR.getMessage())
				.append(PATH.getMessage().repeat(carPosition))
				.append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}
}
