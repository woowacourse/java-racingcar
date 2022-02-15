package racingcar.client;

import java.util.Scanner;

public class ConsoleInputClient implements InputClient {

	private final Scanner sc = new Scanner(System.in);
	private final OutputClient outputClient;

	public ConsoleInputClient(OutputClient outputClient) {
		this.outputClient = outputClient;
	}

	public String input(String prompt) {
		outputClient.output(prompt);
		return sc.nextLine();
	}
}
