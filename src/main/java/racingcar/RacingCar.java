package racingcar;

import racingcar.Controller.Game;

public class RacingCar {
    public static void main(String[] args){
        Game.initialize();
        Game.race();
        Game.showWinner();
    }
}
