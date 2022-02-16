package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGeneratePolicy;
import racingcar.domain.Round;
import racingcar.dto.RecordDto;
import racingcar.dto.ResultDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void run() {
        RacingGame racingGame = new RacingGame(
            Cars.fromNames(InputView.getCarsName()),
            Round.fromNumber(InputView.getRound()),
            new RandomNumberGeneratePolicy()
        );
        OutputView.printRacingRecordHeadLine();
        while (racingGame.isFinished()) {
            OutputView.printRacingRecord(RecordDto.createRecordDto(racingGame.race()));
        }
        OutputView.printRacingResult(ResultDto.createResultDto(racingGame.getRacingResult()));
    }
}
