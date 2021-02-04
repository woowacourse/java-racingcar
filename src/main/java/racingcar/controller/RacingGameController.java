package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameController {
    public void play(Scanner scanner) {
        ArrayList<Car> carsInGame = InputView.getUserCarInput(scanner);
        int trialNumber = InputView.getUserTrialNumberInput(scanner);
    }
}
