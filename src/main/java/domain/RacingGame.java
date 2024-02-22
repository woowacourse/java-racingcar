package domain;

import dto.CarDto;
import dto.ResultDto;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final CarGroup carGroup;

    public RacingGame(final String[] carNames) {
        this.carGroup = new CarGroup(carNames);
    }

    public List<ResultDto> race(final Attempts attempts) {
        List<ResultDto> result = new ArrayList<>();

        while (!attempts.isEnd()) {
            result.add(carGroup.move());
            attempts.decrease();
        }

        return result;
    }

    public List<CarDto> getResult() {
        return carGroup.getWinners();
    }
}
