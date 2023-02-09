package racingcar.view;

import static racingcar.messsages.ExceptionMessage.*;
import static racingcar.messsages.InputViewMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import racingcar.dto.CarNamesRequest;
import racingcar.dto.GameRoundRequest;

public class InputView {
	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public CarNamesRequest inputCarName() {
		print(CAR_NAMES_INPUT_MESSAGE.getMessage());
		String carNames = null;
		try {
			carNames = bufferedReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(CAR_NAME_INPUT_EXCEPTION.getMessage());
		}
		return CarNamesRequest.from(carNames);
	}

	public GameRoundRequest inputGameRound() {
		print(GAME_ROUND_INPUT_MESSAGE.getMessage());
		String gameRound = null;
		try {
			gameRound = bufferedReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(GAME_ROUND_INPUT_EXCEPTION.getMessage());
		}
		return GameRoundRequest.from(gameRound);
	}

	private void print(String message) {
		System.out.print(message);
	}
}
