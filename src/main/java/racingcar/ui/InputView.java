package racingcar.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static String readCarNames() {
        System.out.println(OutputCommand.ASK_CAR_NAMES);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String readTryCount() {
        System.out.println(OutputCommand.ASK_TRY_COUNT);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
