package racingcar.view;

import static racingcar.view.OutputCommand.COMMA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {
    }

    public static List<String> readCarNames() {
        System.out.println(OutputCommand.ASK_CAR_NAMES);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Arrays.stream(bufferedReader.readLine().split(COMMA))
                    .map(String::trim)
                    .toList();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int readTryCount() {
        System.out.println(OutputCommand.ASK_TRY_COUNT);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
