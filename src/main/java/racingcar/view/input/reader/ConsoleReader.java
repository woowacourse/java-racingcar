package racingcar.view.input.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import racingcar.exception.reader.ReaderExceptionStatus;
import racingcar.exception.reader.WrongReaderException;

public class ConsoleReader implements Reader {

    public String readLine() {
        try {
            final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new WrongReaderException(ReaderExceptionStatus.READER_CANNOT_READ);
        }
    }

}
