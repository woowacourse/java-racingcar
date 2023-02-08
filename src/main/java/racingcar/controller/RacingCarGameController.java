package racingcar.controller;

import racingcar.domain.*;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void run() {
        List<String> parsedCarNames = getParsedCarNames();
        // validator
        String tryCount = getTryCount();
        // validator

        RacingCarGame racingCarGame = initiate();
        setCars(parsedCarNames, racingCarGame);

        outputView.printGameResultHeader();
        for (int roundCount=0; roundCount<10; roundCount++) {
            outputView.printRoundResult(racingCarGame.runRound());
        }


    }

    private RacingCarGame initiate() {
        Range range = new Range(4, 9);
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(range, numberGenerator);
        return new RacingCarGame(advanceJudgement);
    }

    private List<String> getParsedCarNames() {
        String carNames = inputView.readCarName();
        return Parser.parsing(carNames, ",");
    }

    private String getTryCount() {
        return inputView.readTryCount();
    }

    private void setCars(List<String> carNames, RacingCarGame racingCarGame){
        for(String carName : carNames){
            racingCarGame.addRacingCar(new RacingCar(carName));
        }
    }
}
