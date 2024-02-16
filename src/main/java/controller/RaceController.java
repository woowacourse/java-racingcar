package controller;

import domain.Car;
import domain.Judge;
import domain.Race;
import view.View;

import java.util.List;

public class Controller {

    private final View view = new View();
    private final Judge judge = new Judge();

    public void start() {
        List<Car> cars = view.readCars();
        int count = view.readCount();

        Race race = new Race(cars, count);
        view.printResultNotice();
        while (race.hasCount()) {
            race.play();
            view.printRace(cars);
        }

        String winners = judge.getWinners(cars);
        view.printWinners(winners);
    }
}