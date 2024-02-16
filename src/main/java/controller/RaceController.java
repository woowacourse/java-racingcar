package controller;

import domain.Car;
import domain.Count;
import domain.Judge;
import domain.RaceCars;
import view.View;

import java.util.List;

public class Controller {

    private final View view = new View();
    private final Judge judge = new Judge();

    public void start() {
        RaceCars raceCars = view.readCars();
        Count count = view.readCount();

        view.printResultNotice();
        while (count.isRemain()) {
            race(raceCars, count);
        }

        List<Car> winners = judge.getWinners(raceCars);
        view.printWinners(winners);
    }

    private void race(RaceCars raceCars, Count count) {
        raceCars.play();
        count.down();
        view.printRace(raceCars);
    }
}