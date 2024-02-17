package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.view.OutputView;

import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        while (!isGameEnd()) {
            playRound(numberGenerator);
            showRoundResult();
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

    private void showRoundResult() {
        List<CarDto> carsDto = new CarsDto(getCurrentCarStatuses()).getCars();
        OutputView.printRoundResult(carsDto);
    }

    public List<Car> getCurrentCarStatuses() {
        return cars.getCars();
    }
}
