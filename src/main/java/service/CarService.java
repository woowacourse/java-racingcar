package service;

import dto.CarDto;
import dto.WinnerCarDto;
import java.util.List;
import model.Car;
import model.Cars;
import utils.RacingNumberGenerator;

public class CarService {

    private Cars cars;

    public void generateCars(List<Car> car) {
        this.cars = new Cars(car);
    }

    public void race(RacingNumberGenerator generator) {
        cars.race(generator);
    }

    public List<CarDto> getCarsDto() {
        return cars.getCarsDto();
    }

    public List<WinnerCarDto> getWinner() {
        return cars.processWinner();
    }
}
