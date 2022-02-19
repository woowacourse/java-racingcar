package racingcar.service;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.score.GameScoreBoard;
import racingcar.model.score.ScoreBoard;
import racingcar.model.score.ScoreConverter;
import racingcar.model.car.RandomNumber;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final Cars cars;
    private final GameScoreBoard gameScoreBoard;

    public CarService() {
        this.cars = new Cars();
        this.gameScoreBoard = new GameScoreBoard();
    }

    private Car toCar(CarDto carDto) {
        return new Car(carDto.getName());
    }

    public List<Car> toCars(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(this::toCar)
                .collect(Collectors.toList());
    }

    public void createCars(List<String> names) {
        names.forEach(name -> cars.save(new Car(name)));
    }

    private void addScoreBoard(int round, List<CarDto> cars) {
        gameScoreBoard.add(new ScoreBoard(round, ScoreConverter.of(cars)));
    }

    public void moveCars(int iteration) {
        for (int i = 0; i < iteration; i++) {
            cars.move(RandomNumber.getNumbers(cars.getSize()));
            addScoreBoard(i, cars.getCarDtos());
        }
    }

    public List<ScoreBoard> findScoreBoard() {
        return gameScoreBoard.getScoreBoards();
    }


    public List<String> findWinners() {
        return gameScoreBoard.findWinners();
    }
}
