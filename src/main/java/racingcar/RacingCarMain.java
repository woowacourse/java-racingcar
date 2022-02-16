package racingcar;

import racingcar.controller.RacingController;
import racingcar.ui.RacingCarOutput;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.generateRacingCars();
        int round = racingController.roundInput();
        RacingCarOutput.printRoundResultMessage();
        racingController.race(round);
        racingController.checkWinners();
    }
}
