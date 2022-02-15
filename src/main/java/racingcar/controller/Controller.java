package racingcar.controller;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.game.RacingGame;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.receiver.CarNamesReceiver;
import racingcar.receiver.TryCountReceiver;
import racingcar.view.View;

public class Controller {

    private final Scanner scanner = new Scanner(System.in);
    private final CarNamesReceiver carNamesReceiver;
    private final TryCountReceiver tryCountReceiver;
    private final View view;
    private final RacingGame racingGame;

    private String namesForGame = "init";
    private String tryCountForGame = "init";

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
            view.printMidtermResults(racingGame.getMidtermResult());
        }
        view.printWinnerResult(racingGame.getWinnersResult());
    }

    private List<String> enrollNames() {
        while (inputNames()) {
        }
        return carNamesReceiver.parseNames(namesForGame);
    }

    private boolean inputNames() {
        try {
            view.printInputNamesMessage();
            namesForGame = carNamesReceiver.validateCarNames(scanner.nextLine());
            return false;
        } catch (IllegalArgumentException exception) {
            view.printExceptionMessage(exception);
            return true;
        }
    }

    private int enrollTryCount() {
        while (inputTryCount()) {
        }
        return tryCountReceiver.parseTryCount(tryCountForGame);
    }

    private boolean inputTryCount() {
        try {
            view.printInputTryCountMessage();
            tryCountForGame = tryCountReceiver.validateTryCount(scanner.nextLine());
            return false;
        } catch (IllegalArgumentException exception) {
            view.printExceptionMessage(exception);
            return true;
        }
    }
}
