package racingcar.view;

import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

	private static final String ASK_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ASK_ROUND_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String LINE_SEPARATOR = System.lineSeparator();

	private final BufferedReader bufferedReader;
	public final InputStreamReader inputStreamReader;

	{
		inputStreamReader = new InputStreamReader(in);
		bufferedReader = new BufferedReader(inputStreamReader);
	}

	public String inputCarNames() throws IOException {
		out.println(ASK_CAR_NAME_INPUT_MESSAGE);
		return bufferedReader.readLine();
	}

	public String inputRoundNumber() throws IOException {
		out.println(ASK_ROUND_NUMBER_INPUT_MESSAGE);
		return bufferedReader.readLine();
	}

	public void printErrorMessage(final Exception exception) {
		out.println(exception.getMessage() + LINE_SEPARATOR);
	}

	public void terminateScanner() {
		try {
			inputStreamReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
