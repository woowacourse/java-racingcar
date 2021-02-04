package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int trial;
    private ExceptionHandler exceptionHandler = new ExceptionHandler();

    public void race() {
        prepareCars();
        //play
        //finish
    }

    private void prepareCars() {
        String input = RacingGameView.requestCars();
        cars = exceptionHandler.setCars(input);
    }

}
