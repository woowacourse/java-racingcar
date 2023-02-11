package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;
import racingcar.dto.CarPositionDto;
import racingcar.dto.CreateRacingCarsDto;

public class RacingCars {

    private final Cars cars;
    private final Count count;

    public RacingCars(CreateRacingCarsDto dto) {
        cars = new Cars(dto.getCarNames());
        count = new Count(dto.getTryCount());
    }

    public void race(NumberPicker numberPicker, Consumer<List<CarPositionDto>> resultHandler) {
        while (!count.isFinished()) {
            cars.moveCars(numberPicker);
            resultHandler.accept(cars.toDto());
            count.next();
        }
    }

    public List<String> findWinner() {
        return cars.findWinner();
    }
}
