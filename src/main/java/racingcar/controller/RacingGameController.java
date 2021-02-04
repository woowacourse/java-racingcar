package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
    public void start() {
        RacingGame racingGame = new RacingGame();
        InputView inputView = new InputView(scanner);

        OutputView.output(INPUT_CARS_NAME_MSG);
        String input = inputView.nextLine();
        createCars(racingGame, input);

        OutputView.output(INPUT_NUMBER_OF_ROUNDS_MSG);
        int round = inputRound(inputView);

        OutputView.output(EXECUTE_RESULT_MSG);
        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            OutputView.printLeaderBoard(racingGame.getCarsResponseDto());
        }

        String winners = racingGame.decideWinner();

        OutputView.output(winners);
    }

    private void createCars(RacingGame racingGame) {
        List<String> names = Arrays.asList("포비","웨지","삭정");
        racingGame.makeCars(names);
    }
}
