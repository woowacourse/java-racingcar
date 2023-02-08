package service;

import domain.Car;
import domain.repository.CarRepository;
import service.validate.InputVerifier;
import view.input.InputView;

import java.util.List;

public class GameService {

    private final CarRepository carRepository;

    public GameService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> splitNames(String[] names) {
        return carRepository.createCars(names);
    }
}
