package racingCar;

import racingCar.domain.Deciders;
import racingCar.domain.Name;
import racingCar.domain.Players;
import racingCar.domain.StringParser;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        Players players = createGameManager();
        int roundInput = InputView.InputNumberOfRound();

        OutputView.printTitle();

        IntStream.rangeClosed(1, roundInput)
                .forEach((t) -> {
                    OutputView.printRound(t);
                    players.play(new Deciders(players));
                    OutputView.printEachRound(players.toString());
                });

        OutputView.printWinners(players.getWinners());
    }

    private static Players createGameManager() {
        String namesInput = InputView.InputUserNames();
        List<Name> names = StringParser.parseToNameList(namesInput);
        Players gameManager = new Players(names);
        while (gameManager.isEmpty()) {
            OutputView.printInvalidNameWarning();
            namesInput = InputView.InputUserNames();
            gameManager = new Players(names);
        }
        return gameManager;
    }
}
