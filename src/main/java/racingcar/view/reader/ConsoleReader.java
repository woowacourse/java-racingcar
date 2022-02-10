package racingcar.view.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements DataReader {

	public String readLine() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			return bufferedReader.readLine() + " ";
		} catch (IOException exception) {
			throw new IllegalArgumentException();
		}
	}
}
