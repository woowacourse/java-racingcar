package model;

import dto.RacingCarStateDto;
import dto.RacingRoundStateDto;
import dto.WinnerCarDto;
import exception.EmptyCarsException;
import exception.WrongRangeMovableNumberException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.wrapper.Round;
import utils.RacingNumberGenerator;

public class Cars {

    private static final int MIN_INCLUSIVE_VALUE = 0;
    private static final int MAX_INCLUSIVE_VALUE = 9;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<RacingRoundStateDto> race(RacingNumberGenerator generator, Round round) {
        List<RacingRoundStateDto> racingResult = new ArrayList<>();

        while (round.isRacing()) {
            racingResult.add(race(generator));
        }
        return racingResult;
    }

    private RacingRoundStateDto race(RacingNumberGenerator generator) {
        List<RacingCarStateDto> racingCarsStateDto = cars.stream()
                .map(car -> car.race(generateValidMovableNumber(generator)))
                .collect(Collectors.toUnmodifiableList());
        return new RacingRoundStateDto(racingCarsStateDto);
    }

    private int generateValidMovableNumber(RacingNumberGenerator generator) {
        int movableNumber = generator.generate();

        if (isValidRangeMovableNumber(movableNumber)) {
            throw new WrongRangeMovableNumberException();
        }
        return movableNumber;
    }

    private boolean isValidRangeMovableNumber(int movableValue) {
        return movableValue < MIN_INCLUSIVE_VALUE || movableValue > MAX_INCLUSIVE_VALUE;
    }

    public List<WinnerCarDto> calculateWinners() {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(EmptyCarsException::new);

        return addSamePositionCars(winner);
    }

    private List<WinnerCarDto> addSamePositionCars(Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::mapToWinnerCarDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
