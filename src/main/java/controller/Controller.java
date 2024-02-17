package controller;

import domain.Car;
import domain.Game;

import java.util.List;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Controller {
    //Git Sync Test
    private final Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public void run() {
        List<Car> cars = inputCarName();
        int inputAttemptLimit = inputValue();
        playGame(cars, inputAttemptLimit);
        List<String> winners = game.getWinner(cars, game.getMaxPosition(cars));
        OutputView.printWinners(winners);
    }

    private void playGame(List<Car> cars, int attemptLimit) {
        OutputView.printHeadLine();
        while (attemptLimit!=0) {
            game.playRacing(cars);
            OutputView.printResult(cars);
            attemptLimit--;
        }
    }

    private List<Car> inputCarName() {
        try {
            InputView.requestCarName();
            Scanner scanner = new Scanner(System.in);
            return game.setCars(game.separateCarName(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputCarName();
        }
    }

    private int inputValue() {
        InputView.requestAttemptLimit();
        Scanner scanner = new Scanner(System.in);
        return validateNum(scanner.nextLine());
    }

    private int validateNum(String inputValue) {
        try {
            int inputAttemptLimit = validateInputAttemptLimit(inputValue);
            validateNumber(inputAttemptLimit);
            return inputAttemptLimit;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputValue();
        }
    }

    public int validateInputAttemptLimit(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }

    public void validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수여야 합니다.");
        }
    }
}
