package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static String getCarsNameInput() throws IOException {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		return getInput();
	}

	public static String getRaceCountInput() throws IOException {
		System.out.println("시도할 횟수는 몇 회인가요?");
		return getInput();
	}

	private static String getInput() throws IOException {
		return bufferedReader.readLine();
	}
}
