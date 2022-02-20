package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Participants;
import racingcar.model.PlayTime;
import racingcar.model.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {

    private final InputView inputView;
    private final OutputView outputView;

    public Racing() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Participants participants = enrollCars();
        PlayTime playTime = new PlayTime(inputView.requestPlayTimes());
        startRacing(participants, playTime);
        List<String> racingWinnerNames = participants.findRacingWinners().stream()
                .map(Car::getName).collect(Collectors.toList());
        showRacingResult(racingWinnerNames);
    }

    private Participants enrollCars() {
        String[] carNames = inputView.requestCarNames();
        return new Participants(carNames);
    }

    private void startRacing(Participants participants, PlayTime playTime) {
        outputView.announceRacingStart();
        List<RoundResult> racingResults = new ArrayList<>();
        while (!playTime.isEnd()) {
            racingResults.add(participants.race());
            playTime.decrease();
        }
        outputView.recordScore(racingResults);
    }

    private void showRacingResult(List<String> winners) {
        outputView.recordRacingWinners(winners);
    }
}
