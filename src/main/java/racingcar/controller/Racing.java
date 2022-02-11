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
        String[] carNames = staff.getCarNames().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            participants.participateInRacing(car);
        }
        PlayTime playTime = new PlayTime(staff.getPlayTimes());

        board.announceRacingStart();
        while (!playTime.isZero()) {
            participants.race();
            playTime.decreasePlayTime();
            board.recordCurrentScore(participants.getParticipantCars());
        }
        Referee referee = new Referee();
        board.recordRacingWinners(referee.judgeRacingWinners(participants.getParticipantCars()));
    }
}
