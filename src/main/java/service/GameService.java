package service;

import domain.Car;
import domain.repository.CarRepository;
import service.validate.InputVerifier;
import view.input.InputView;

import java.util.List;
import java.util.Random;

public class GameService {

    private final CarRepository carRepository;

    public GameService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> splitNames(String[] names) {
        return carRepository.createCars(names);
    }

    public void move(List<Car> cars) {
        for (Car car : cars) {
            if (decideMove(getRandomNumber())) {
                moving(car);
            }
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private boolean decideMove(int randomNumber) {
        return 4 <= randomNumber;
    }

    private void moving(Car car) {
        car.increaseStep();
    }
}
