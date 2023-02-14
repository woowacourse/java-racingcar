package domain;

import dto.response.CarStatusDto;
import dto.response.WinnersNameDto;
import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<List<CarStatusDto>> play(Cars cars, TryCount tryCount) {
        List<List<CarStatusDto>> gameResult = new ArrayList<>();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.move(numberGenerator);
            List<CarStatusDto> carStatusDtos = cars.getCars()
                    .stream()
                    .map(CarStatusDto::of)
                    .collect(Collectors.toList());
            gameResult.add(carStatusDtos);
        }
        return gameResult;
    }

    public WinnersNameDto findWinners(Cars cars) {
        List<Car> winners = cars.findWinners();
        return WinnersNameDto.of(winners);
    }
}
