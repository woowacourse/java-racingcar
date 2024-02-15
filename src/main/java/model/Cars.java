package model;

import java.util.List;
import utils.Converter;
import view.dto.CarDto;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(List<Boolean> moves) {
        for (int i = 0; i < moves.size(); i++) {
            cars.get(i).move(moves.get(i));
        }
    }

    public List<CarDto> convertCarsToCarDtos() {
        return Converter.convertCarToCarDtos(cars);
    }

    public List<Car> findWinners() {
        int maxMovement = cars.stream().mapToInt(Car::getMovement).max().getAsInt();
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    public int getCarsSize() {
        return cars.size();
    }
}
