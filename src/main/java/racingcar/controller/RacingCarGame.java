package racingcar.controller;

import java.io.IOException;
import racingcar.domain.Vehicles;
import racingcar.ui.InputView;

public class RacingCarGame {
    public void start() {
        try {
            Vehicles vehicles = Vehicles.from(InputView.readCarNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}