package racingcar.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String readCarNames() {
        System.out.println(OutputCommand.ASK_CAR_NAMES);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String readTryCount() {
        System.out.println(OutputCommand.ASK_TRY_COUNT);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
