package racingcar.view;

import racingcar.domain.Car;
import racingcar.enumType.ExceptionMessage;
import racingcar.exception.ConsoleException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readCarNames() {
        try {
            String[] names = bufferedReader.readLine().split(",");
            return Arrays.asList(names);
        } catch (IOException e) {
            throw new ConsoleException(String.format(ExceptionMessage.INPUT_MESSAGE.getValue(), e.getMessage()));
        }
    }

    public int readTryCount() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e) {
            throw new ConsoleException(String.format(ExceptionMessage.TYPE_MESSAGE.getValue(), e.getMessage()));
        } catch (IOException e) {
            throw new ConsoleException(String.format(ExceptionMessage.INPUT_MESSAGE.getValue(), e.getMessage()));
        }
    }

}
