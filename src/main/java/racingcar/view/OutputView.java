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
	public void printRoundResult(RoundResultResponse roundResultDTO) {
		String roundResultMessage = createRoundResult(roundResultDTO);
		print(roundResultMessage);
	}

	public void printEndGameResult(GameResultResponse gameResultDTO) {
		String winnerNamesMessage = createWinnerResult(gameResultDTO);
		print(winnerNamesMessage + GAME_RESULT_MESSAGE.getMessage());
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}

	private String createWinnerResult(GameResultResponse gameResultDTO) {
		return String.join(WINNER_DELIMITER.getMessage(), gameResultDTO.getWinnerNames());
	}

	private String createRoundResult(RoundResultResponse roundResultDTO) {
		StringBuilder resultBuilder = new StringBuilder();
		List<CarDto> carDTOs = roundResultDTO.getRoundResult();
		for (CarDto carDTO : carDTOs) {
			int carPosition = carDTO.getCarPosition();
			resultBuilder.append(carDTO.getCarName())
				.append(RESULT_SEPARATOR.getMessage())
				.append(PATH.getMessage().repeat(carPosition))
				.append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}

	private void print(String message) {
		System.out.print(message);
	}
}
