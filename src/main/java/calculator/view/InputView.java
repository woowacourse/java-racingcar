package calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
    }

    public static String askInput() throws IOException {
        return bufferedReader.readLine().replace("\\n", "\n");
    }
}
