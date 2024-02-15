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

        Race race = new Race(count, cars);
        String playResult = race.play();
        view.printRace(playResult);

        String winners = judge.getWinners(cars);
        view.printWinners(winners);
    }
}