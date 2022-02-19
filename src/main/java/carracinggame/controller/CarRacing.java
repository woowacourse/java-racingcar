package carracinggame.controller;

import carracinggame.domain.Car;
import carracinggame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    Cars cars = new Cars();

    public void start(String[] carNames, int times) {
        cars.makeCars(carNames);

    }
}
