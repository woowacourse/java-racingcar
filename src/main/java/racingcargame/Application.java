package racingcargame;

import racingcargame.controller.CarGameController;

public class Application {

    public static void main(String[] args) {
        CarGameController carGameController = new CarGameController();
        carGameController.playGame();
    }
}
