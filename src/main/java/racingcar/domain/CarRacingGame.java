package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race(PrintRequestListener<List<CarDto>> printRequestListener) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        while (!isGameEnd()) {
            playRound(numberGenerator);
            printRequestListener.print(new CarsDto(findWinners()).getCars());
        }
    }

    public boolean isGameEnd() {
        return round.isLast();
    }

    public List<Car> findWinners() {
        return cars.findCarsAtMaxPosition();
    }

    public void playRound(NumberGenerator numberGenerator) {
        cars.moveCars(numberGenerator);
        round.decrease();
    }

    public List<Car> getCurrentCarStatuses() {
        return cars.getCars();
    }
}
