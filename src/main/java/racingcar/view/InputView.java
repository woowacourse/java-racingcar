package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BufferedReader bufferedReader;
    
    public InputView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String readCorrectLine(Runnable runnable) {
        try {
            return readLine(runnable);
        } catch (IOException e) {
            return readCorrectLine(runnable);
        }
    }

    private String readLine(Runnable printGuide) throws IOException {
        printGuide.run();
        return bufferedReader.readLine();
    }
}
