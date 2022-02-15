package racingcar.client;

public class ConsoleErrorClient implements ErrorClient {

	private static final String PREFIX = "[ERROR] ";

	@Override
	public void error(String message) {
		System.out.print(PREFIX + message);
	}
}
