package racingcar.service;

import racingcar.model.*;

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

    public void createCars(List<String> names) {
        names.forEach(name -> carRepository.save(new Car(name)));
    }

    public void addScoreBoard(int round, List<CarDto> cars) {
        gameScoreBoard.add(new ScoreBoard(round, ScoreConverter.of(cars)));
    }

    public void moveCars(int iteration) {
        for (int i = 0; i < iteration; i++) {
            carRepository.move(RandomNumber.getNumbers(carRepository.getSize()));
            addScoreBoard(i, carRepository.getCarDtos());
        }
    }

    public List<ScoreBoard> findScoreBoard() {
        return gameScoreBoard.getScoreBoards();
    }
}
