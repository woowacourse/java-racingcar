package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Participants;
import racingcar.model.PlayTime;
import racingcar.model.Referee;
import racingcar.view.Board;
import racingcar.view.Staff;

public class Racing {

    private final Staff staff;
    private final Participants participants;
    private final Board board;

    public Racing() {
        this.staff = new Staff();
        this.participants = new Participants();
        this.board = new Board();
    }

    public void start() {
        enrollCars();
        PlayTime playTime = new PlayTime(staff.getPlayTimes());
        startRacing(playTime);
        showRacingResult();
    }

    private void enrollCars() {
        String[] carNames = staff.getCarNames().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            participants.participateInRacing(car);
        }
    }

    private void startRacing(PlayTime playTime) {
        board.announceRacingStart();
        while (!playTime.isZero()) {
            participants.race();
            playTime.decreasePlayTime();
            board.recordCurrentScore(participants.getParticipantCars());
        }
    }

    private void showRacingResult() {
        Referee referee = new Referee();
        board.recordRacingWinners(referee.judgeRacingWinners(participants.getParticipantCars()));
    }
}
