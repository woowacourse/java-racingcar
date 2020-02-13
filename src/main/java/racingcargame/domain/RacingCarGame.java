package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public String winner;
    public final static ArrayList<CarDto> carStatus = new ArrayList<>();

    public ArrayList<CarDto> run(String userInputName, int userInputRepeat) {
        final RacingCars cars = new RacingCars(userInputName);
        processGame(userInputRepeat, cars);
        winner = cars.getWinner();
        return carStatus;
    }

    private void processGame(int repeat, RacingCars cars) {

        for (int i = 0; i < repeat; i++) {
            carStatus.add(cars.processOneTime());
        }

    }


}
