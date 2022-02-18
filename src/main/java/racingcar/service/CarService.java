package racingcar.service;

import racingcar.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarRepository carRepository;
    private final GameScoreBoard gameScoreBoard;

    public CarService() {
        this.carRepository = new CarRepository();
        this.gameScoreBoard = new GameScoreBoard();
    }

    public Car toCar(CarDto carDto) {
        return new Car(carDto.getName());
    }

    public List<Car> toCars(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(this::toCar)
                .collect(Collectors.toList());
    }

    public void createCars(List<Car> cars) {
        cars.forEach(carRepository::save);
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carRepository.getSize(); i++) {
            randomNumbers.add(RandomNumber.getNumber());
        }
        return randomNumbers;
    }

    public void addScoreBoard(int round, List<Car> cars) {
        gameScoreBoard.add(new ScoreBoard(round, ScoreConverter.of(cars)));
    }
}
