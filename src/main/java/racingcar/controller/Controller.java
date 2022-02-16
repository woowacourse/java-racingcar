package racingcar.controller;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.game.RacingGame;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.domain.receiver.CarNamesReceiver;
import racingcar.domain.receiver.TryCountReceiver;
import racingcar.view.View;

public class Controller {

    private final Scanner scanner = new Scanner(System.in);
    private final CarNamesReceiver carNamesReceiver;
    private final TryCountReceiver tryCountReceiver;
    private final View view;
    private final RacingGame racingGame;

    private String receivedNamesForGame = "init";
    private String receivedTryCountForGame = "init";

    public Controller(RandomNumberGenerator randomNumberGenerator) {
        this.carNamesReceiver = new CarNamesReceiver();
        this.tryCountReceiver = new TryCountReceiver();
        this.view = new View();
        this.racingGame = new RacingGame(enrollNames(), enrollTryCount(), randomNumberGenerator);
    }

    public void runGame() {
        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResults(racingGame.getGameLog(), racingGame.getTryCount().getCurrentTryCount());
        }
        view.printWinnersResult(racingGame.getGameLog(), racingGame.getTryCount().getTotalTryCount());
    }

    private List<String> enrollNames() {
        while (inputNames()) {
        }
        return carNamesReceiver.parseNames(receivedNamesForGame);
    }

    private boolean inputNames() {
        try {
            view.printInputNamesMessage();
            receivedNamesForGame = carNamesReceiver.validateCarNames(scanner.nextLine());
            return false;
        } catch (IllegalArgumentException exception) {
            view.printExceptionMessage(exception);
            return true;
        }
    }

    private int enrollTryCount() {
        while (inputTryCount()) {
        }
        return tryCountReceiver.parseTryCount(receivedTryCountForGame);
    }

    private boolean inputTryCount() {
        try {
            view.printInputTryCountMessage();
            receivedTryCountForGame = tryCountReceiver.validateTryCount(scanner.nextLine());
            return false;
        } catch (IllegalArgumentException exception) {
            view.printExceptionMessage(exception);
            return true;
        }
    }
}
