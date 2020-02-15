package application.racing.domain;

public class RacingGame {
    private int round;

    public RacingGame() {
        this.round = 0;
    }

    public void raceOneLab(Cars cars) {
        cars.moveEachCar();
        this.round = this.round + 1;
    }

    public boolean isEnd(RacingLab racingLab) {
        return this.round == racingLab.getRacingLab();
    }
}
