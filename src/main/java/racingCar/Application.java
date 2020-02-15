package racingCar;

import racingCar.domain.*;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.List;

public class Application {
    public static final int ONE_ROUND = 1;

    public static void main(String[] args) {

        String nameInput = InputView.inputUserNames();
        List<Name> names = StringParser.parseToNameList(nameInput);

        while (names.isEmpty()) {
            OutputView.printInvalidNameWarning();
            nameInput = InputView.inputUserNames();
            names = StringParser.parseToNameList(nameInput);
        }
        Players players = new Players(names);
        int roundInput = InputView.InputNumberOfRound();

        OutputView.printResultTitle();
        for (int round = ONE_ROUND; round <= roundInput; round++) {
            OutputView.printRound(round);
            players.play(new Deciders(players));
            OutputView.printEachRound(players);
        }
        OutputView.printWinners(players);
    }
}
