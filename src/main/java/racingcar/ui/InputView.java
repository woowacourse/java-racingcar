package racingcar.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static String readCarNames() throws IOException {
        System.out.println(OutputCommand.ASK_CAR_NAMES);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}
