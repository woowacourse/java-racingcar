package racingcar.view.input.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import racingcar.exception.WrongArgumentException;
import racingcar.exception.status.reader.ReaderExceptionStatus;

public class ConsoleReader implements Reader {

    public String readLine() {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new WrongArgumentException(ReaderExceptionStatus.READER_CANNOT_READ);
        }
    }

}
