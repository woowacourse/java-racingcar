package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Participants;
import racingcar.model.PlayTime;
import racingcar.view.Staff;

public class Racing {

    private final Staff staff;
    private final Participants participants;

    public Racing() {
        this.staff = new Staff();
        this.participants = new Participants();
    }

    public void start() {
        String[] carNames = staff.getCarNames().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            participants.participateInRacing(car);
        }
        PlayTime playTime = new PlayTime(staff.getPlayTimes());
    }
}
