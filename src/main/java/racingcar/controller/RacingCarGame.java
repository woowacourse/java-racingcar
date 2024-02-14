package racingcar.controller;

import java.io.IOException;
import racingcar.ui.InputView;

public class RacingCarGame {
    public void start() {
        try {
            String userInput = InputView.readCarNames();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}