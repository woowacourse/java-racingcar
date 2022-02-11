package racingcar.view.input.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import racingcar.exception.reader.ReaderIoException;

public class ConsoleReader implements Reader {

	public String readLine() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			return bufferedReader.readLine();
		} catch (IOException exception) {
			throw new ReaderIoException();
		}
	}

}
