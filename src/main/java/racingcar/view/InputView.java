package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String inputNames() throws IOException {
        return br.readLine();
    }

    public static int inputMoveCount() throws IOException {
        String moveCount = br.readLine();
        return Integer.parseInt(moveCount);
    }
}

