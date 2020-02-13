package racingcargame.domain;

import java.util.ArrayList;

public class RacingCarGame {
    public String winner;

    public ArrayList<CarDto> run(String userInputName, int userInputRepeat) {
        final RacingCars cars = new RacingCars(userInputName);
        ArrayList<CarDto> carStatus = processGame(userInputRepeat, cars);
        winner = cars.getWinner();
        return carStatus;
    }

    private ArrayList<CarDto> processGame(int repeat, RacingCars cars) {
        ArrayList<CarDto> carStatus = new ArrayList<>();
        for (int i = 0; i < repeat; i++) {
            carStatus.add(cars.processOneRace());
        }
        return carStatus;
    }


}
