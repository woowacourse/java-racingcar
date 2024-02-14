package controller;

import domain.*;
import util.NumberGenerator;
import view.InputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    public GameController(InputView inputView){
        this.inputView = inputView;
    }

    public void play(){
        CarNameCatalog carNameCatalog=inputView.inputCarNameCatalog();
        RaceCount raceCount=inputView.inputRaceCount();

        List<Car> cars=carNameCatalog.getNames().stream().map(Car::new).toList();

        for(int i=0;i< raceCount.getValue();i++){
            for(Car car:cars){
                car.race(NumberGenerator.generate());
            }
        }
        RaceResult raceResult = RaceResult.of(cars);
        cars.stream().forEach(car -> {
            System.out.println(car.getPosition());
        });
        raceResult.getWinnerCars().forEach(car -> {
            System.out.println(car.getPosition());
        });

    }
}
