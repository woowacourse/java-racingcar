package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Participants;
import racingcar.model.PlayTime;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class Racing {

    private final InputView inputView;
    private final Participants participants;
    private final OutputView outputView;

    public Racing() {
        this.inputView = new InputView();
        this.participants = new Participants();
        this.outputView = new OutputView();
    }

    public void start() {
        enrollCars();
        PlayTime playTime = new PlayTime(inputView.getPlayTimes());
        startRacing(playTime);
        showRacingResult();
    }

    private void enrollCars() {
        String[] carNames = inputView.getCarNames().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            participants.participateInRacing(car);
        }
    }

    private void startRacing(PlayTime playTime) {
        outputView.announceRacingStart();
        while (!playTime.isZero()) {
            participants.race();
            playTime.decrease();
            outputView.recordCurrentScore(participants.getParticipantCars());
        }
    }

    private void showRacingResult() {
        outputView.recordRacingWinners(participants.findRacingWinners());
    }
}
