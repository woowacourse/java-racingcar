package racingcar.service;

import racingcar.model.car.Cars;
import racingcar.model.car.RandomNumber;
import racingcar.model.score.GameScoreBoard;
import racingcar.model.score.ScoreBoard;
import racingcar.service.converter.ScoreConverter;

import java.util.List;

public class CarService {
    private final Cars cars;
    private final GameScoreBoard gameScoreBoard;

    public CarService() {
        this.cars = new Cars();
        this.gameScoreBoard = new GameScoreBoard();
    }

    public void createCars(List<String> names) {
        cars.create(names);
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


    private void addScoreBoard(int round, List<CarDto> cars) {
        gameScoreBoard.add(round, ScoreConverter.of(cars));
    }
}
