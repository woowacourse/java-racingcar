package racingcar.view;

import static racingcar.messsages.OutputViewMessage.*;

import java.util.List;

import racingcar.dto.CarDto;
import racingcar.dto.GameResultResponse;
import racingcar.dto.RoundResultResponse;

public class OutputView {
	public void printResultMessage() {
		print(RESULT_MESSAGE.getMessage());
	}
	public void printRoundResult(final RoundResultResponse roundResultDTO) {
		final String roundResultMessage = createRoundResult(roundResultDTO);
		print(roundResultMessage);
	}

	public void printEndGameResult(final GameResultResponse gameResultDTO) {
		final String winnerNamesMessage = createWinnerResult(gameResultDTO);
		print(winnerNamesMessage + GAME_RESULT_MESSAGE.getMessage());
	}

	public void printErrorMessage(final String message) {
		System.out.println(message);
	}

	private String createWinnerResult(final GameResultResponse gameResultDTO) {
		return String.join(WINNER_DELIMITER.getMessage(), gameResultDTO.getWinnerNames());
	}

	private String createRoundResult(final RoundResultResponse roundResultDTO) {
		final StringBuilder resultBuilder = new StringBuilder();
		final List<CarDto> carDTOs = roundResultDTO.getRoundResult();
		for (final CarDto carDTO : carDTOs) {
			final int carPosition = carDTO.getCarPosition();
			resultBuilder.append(carDTO.getCarName())
				.append(RESULT_SEPARATOR.getMessage())
				.append(PATH.getMessage().repeat(carPosition))
				.append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}

	private void print(final String message) {
		System.out.print(message);
	}
}
