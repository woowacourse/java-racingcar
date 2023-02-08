package racingcar.view;

import static racingcar.exception.ErrorMessages.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import racingcar.dto.CarNamesDTO;
import racingcar.dto.GameRoundDTO;

public class InputView {
	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String GAME_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public CarNamesDTO inputCarName() {
		System.out.println(CAR_NAMES_INPUT_MESSAGE);
		String carNames = null;

		try {
			carNames = bufferedReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(CAR_NAME_INPUT_EXCEPTION.getMessage());
		}
		return new CarNamesDTO(carNames);
	}

	public GameRoundDTO inputGameRound() {
		System.out.println(GAME_ROUND_INPUT_MESSAGE);
		String gameRound = null;

		try {
			gameRound = bufferedReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(GAME_ROUND_INPUT_EXCEPTION.getMessage());
		}

		return new GameRoundDTO(gameRound);
	}
}
