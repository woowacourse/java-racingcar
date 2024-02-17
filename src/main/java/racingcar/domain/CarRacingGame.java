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

    public void race(OutputView outputView) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        while (!isGameEnd()) {
            playRound(numberGenerator);
            showRoundResult(outputView);
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

    private void showRoundResult(OutputView outputView) {
        List<CarDto> carsDto = new CarsDto(getCurrentCarStatuses()).getCars();
        outputView.printRoundResult(carsDto);
    }

    public List<Car> getCurrentCarStatuses() {
        return cars.getCars();
    }
}
