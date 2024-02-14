public class RacingGameController {


    public void run() {

        Cars cars = Cars.fromEmpty();
        RacingGame racingGame = RacingGame.of(3, cars);
        racingGame.play();
        Winners winners = Winners.from(cars);

    }
}
