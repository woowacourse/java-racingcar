package racing.controller;

import java.io.IOException;

import racing.domain.CarGroup;
import racing.domain.RacingGame;
import racing.domain.RandomNumberGenerator;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() throws IOException {
        CarGroup carGroup = createCarGroup();
        int movingTrial = createMovingTrial();

        RacingGame racingGame = new RacingGame(carGroup, movingTrial, new RandomNumberGenerator());

        outputView.printNotice();
        raceWithHistory(movingTrial, racingGame);
        outputView.printWinner(racingGame.produceRacingResult().pickWinner());
    }

    private CarGroup createCarGroup() throws IOException {
        try {
            String[] carNames = inputView.readCarNames();
            return new CarGroup(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCarGroup();
        }
    }

    private int createMovingTrial() {
        try {
            return inputView.readMovingTrial();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
            return createMovingTrial();
        }
    }

    //TODO: movingTrial을 RacingGame으로 이동
    private void raceWithHistory(int movingTrial, RacingGame racingGame) {
        for (int i = 0; i < movingTrial; i++) {
            racingGame.race();

            outputView.printRacingResult(racingGame.produceRacingResult().getHistory());
        }
    }
}
