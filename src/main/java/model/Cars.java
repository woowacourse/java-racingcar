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
                .map(car -> car.race(generator.generate()))
                .collect(Collectors.toUnmodifiableList());
        return new RacingRoundStateDto(racingCarsStateDto);
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
