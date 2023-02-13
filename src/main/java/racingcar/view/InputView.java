package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BufferedReader bufferedReader;
    
    public InputView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(Runnable runnable) {
        try {
            runnable.run();
            return bufferedReader.readLine();
        } catch (IOException ioException) {
            return readLine(runnable);
        }
    }
}
