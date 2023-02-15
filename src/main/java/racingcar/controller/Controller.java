package racingcar.controller;

import racingcar.domain.Positions;
import racingcar.domain.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Controller {
    public static Scanner scanner;

    private final RandomNumberPicker randomNumberPicker;
    private Positions positions;

    public Controller(RandomNumberPicker randomNumberPicker) {
        this.scanner = new Scanner(System.in);
        this.randomNumberPicker = randomNumberPicker;
    }

    public void game() {
        String carNames = inputCarNames();
        createCars(carNames);
        int gameCount = inputTryCount();

        raceTracks(gameCount);
        printWinner();
    }

    private String inputCarNames() {
        InputView.printInputCarNameGuide();
        return scanner.nextLine();
    }

    private void createCars(String carNames) {
        positions = new Positions(carNames, randomNumberPicker);
    }

    private int inputTryCount() {
        InputView.printInputTryCountGuide();

        return validateInputTryCount();
    }

    private static int validateInputTryCount() {
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(InputView.printInputTryCountError());
        }
    }


    private void printWinner() {
        OutputView.printWinner(positions.findWinner());
    }

    private void getCarName(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getCarName(runnable);
        }
    }

    private void raceTracks(int gameCount) {
        OutputView.printPositionGuide();

        raceTrack(gameCount);
    }

    private void raceTrack(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            positions.moveCars();
            OutputView.printPositions(positions.getCars());
        }
    }
}
