package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import racingcar.dto.CarNamesDTO;
import racingcar.exception.ErrorMessages;

public class InputView {
	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public CarNamesDTO inputCarName() {
		System.out.println(CAR_NAMES_INPUT_MESSAGE);
		String carNames = null;

		try {
			carNames = bufferedReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(ErrorMessages.CAR_NAME_INPUT_EXCEPTION.getMessage());
		}
		return new CarNamesDTO(carNames);
	}


}
