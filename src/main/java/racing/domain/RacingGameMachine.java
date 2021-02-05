package racing.domain;

import racing.domain.dto.CarDto;
import racing.domain.dto.WinnersDto;

import java.util.List;

public class RacingGameMachine {
    private static final int ZERO = 0;

    private final Cars cars;
    private int tryCounts;

    public RacingGameMachine(Cars cars, int tryCounts) {
        this.cars = cars;
        this.tryCounts = tryCounts;
        validateTryCounts();
    }

    private void validateTryCounts() {
        if (tryCounts <= ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        tryCounts--;
        cars.race();
    }

    public boolean canPlay() {
        return tryCounts > ZERO;
    }

    public WinnersDto getWinnersDtos(){
        List<String> winnersName = cars.findWinners().getWinnersName();
        return new WinnersDto(winnersName);
    }

    public List<CarDto> getCarDtos() {
        return cars.getCarDtos();
    }
}
