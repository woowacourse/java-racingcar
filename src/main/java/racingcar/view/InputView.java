package racingcar.view;

import static racingcar.messsages.ExceptionMessage.*;
import static racingcar.messsages.InputViewMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarNamesRequest;
import racingcar.dto.GameRoundRequest;

public class InputView {
	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public CarNamesRequest inputCarNames() {
		print(CAR_NAMES_INPUT_MESSAGE.getMessage());
		final List<String> carNames;
		try {
			final String inputCarNames = bufferedReader.readLine();
			carNames = splitByComma(inputCarNames);
		} catch (IOException e) {
			throw new RuntimeException(CAR_NAME_INPUT_EXCEPTION.getMessage());
		}
		return CarNamesRequest.from(carNames);
	}

	public GameRoundRequest inputGameRound() {
		print(GAME_ROUND_INPUT_MESSAGE.getMessage());
		int totalGameRound;
		try {
			String inputGameRound = bufferedReader.readLine();
			validateBlank(inputGameRound);
			validateNotStartZero(inputGameRound);
			validateInteger(inputGameRound);
			totalGameRound = Integer.parseInt(inputGameRound);
		} catch (IOException e) {
			throw new RuntimeException(GAME_ROUND_INPUT_EXCEPTION.getMessage());
		}
		return GameRoundRequest.from(totalGameRound);
	}

	private List<String> splitByComma(String carNames) {
		String[] splitCarNames = carNames.split("\\s*,\\s*");
		return Arrays.stream(splitCarNames).collect(Collectors.toList());
	}

	private void print(String message) {
		System.out.print(message);
	}

	private void validateBlank(String gameRound) {
		if (gameRound.isBlank()) {
			throw new IllegalArgumentException(GAME_ROUND_INPUT_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateInteger(String gameRound) {
		boolean isDigit = gameRound.chars().allMatch(Character::isDigit);
		if (!isDigit) {
			throw new IllegalArgumentException(GAME_ROUND_INPUT_FORMAT_DIGIT_EXCEPTION.getMessage());
		}
	}

	private void validateNotStartZero(String gameRound) {
		if (gameRound.charAt(0) == '0') {
			throw new IllegalArgumentException(GAME_ROUND_INPUT_FORMAT_ZERO_EXCEPTION.getMessage());
		}
	}
}
