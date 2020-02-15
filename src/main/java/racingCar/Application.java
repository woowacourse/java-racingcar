package racingCar;

import racingCar.domain.*;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.List;

public class Application {
    public static final int ONE_ROUND = 1;
    private static final int ZERO = 0;

    public static void main(String[] args) {
        Players players = createPlayers();
        int roundInput = InputView.InputNumberOfRound();
        OutputView.printResultTitle();
        proceedRounds(players, roundInput);
        OutputView.printWinners(players);
    }

    private static Players createPlayers() {
        String nameInput = InputView.inputUserNames();
        List<Name> names = StringParser.parseToNameList(nameInput);

        while (names.isEmpty()) {
            OutputView.printInvalidNameWarning();
            nameInput = InputView.inputUserNames();
            names = StringParser.parseToNameList(nameInput);
        }

        return new Players(names);
    }

    private static void proceedRounds(Players players, int roundInput) {
        OutputView.printRoundResultWithRoundNum(ZERO, players);
        for (int round = ONE_ROUND; round <= roundInput; round++) {
            players.play(new Deciders(players));
            OutputView.printRoundResultWithRoundNum(round, players);
        }
    }
}
