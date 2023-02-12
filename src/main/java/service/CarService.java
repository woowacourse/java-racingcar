package service;

import dto.CarDto;
import dto.WinnerCarDto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import exception.DuplicateCarNameException;
import model.Car;
import model.Cars;
import utils.RacingNumberGenerator;
import utils.StringUtils;

public class CarService {

    private Cars cars;

    public void initCars(String inputCarsName) {
        String[] carsName = StringUtils.splitBySeparator(inputCarsName);
        checkDuplication(carsName);
        this.cars = new Cars(mapToCars(carsName));
    }

    private List<Car> mapToCars(String[] carsName) {
        return Arrays.stream(carsName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void checkDuplication(String[] carsName) {
        if (getDistinctCarsCount(carsName) != carsName.length) {
            throw new DuplicateCarNameException();
        }
    }

    private long getDistinctCarsCount(String[] carsName) {
        return Arrays.stream(carsName)
                .distinct()
                .count();
    }

    public void race(RacingNumberGenerator generator) {
        cars.race(generator);
    }

    public List<CarDto> getCarsDto() {
        return cars.getCarsDto();
    }

    public List<WinnerCarDto> getWinner() {
        return cars.getWinner();
    }
}
